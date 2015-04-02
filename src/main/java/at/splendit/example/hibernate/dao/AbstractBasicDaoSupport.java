package at.splendit.example.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import at.splendit.example.hibernate.domain.AbstractEntityObject;
import at.splendit.example.hibernate.spring.SpringUtils;

public abstract class AbstractBasicDaoSupport<E extends AbstractEntityObject<I>, I extends Serializable> implements
		InterfaceBasicDaoSupport<E, I> {

	private final static Logger log = LogManager.getLogger(AbstractBasicDaoSupport.class);

	@Autowired
	private ApplicationContext springContext;

	protected Class<E> entityClass;

	protected AbstractBasicDaoSupport(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	protected Session _getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Criteria createCriteria() {

		return _getCurrentSession().createCriteria(entityClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByCriteria(Criterion criterion) {
		Criteria criteria = createCriteria();
		if (criterion != null) {
			criteria.add(criterion);
		}

		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	protected final static <T> T getInstance(Class<T> clazz) {
		return SpringUtils.getBean(clazz.getName(), clazz);
	}

	public void shutdown() {
		_getCurrentSession().getSessionFactory().openSession().createSQLQuery("SHUTDOWN").executeUpdate();
	}

	@Override
	public List<E> findAll() {
		return findByCriteria(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(I id) {
		return (E) _getCurrentSession().get(entityClass, id);
	}

	@Override
	public void saveOrUpdate(E e) {

		try {
			_getCurrentSession().saveOrUpdate(e);
			_getCurrentSession().flush();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}

	}

	@Override
	public void merge(E e) {
		try {
			_getCurrentSession().merge(e);
			_getCurrentSession().flush();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
	}

	@Override
	public void delete(E e) {

		try {
			_getCurrentSession().delete(e);
			_getCurrentSession().flush();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}
	}

	@Override
	public void update(E e) {
		try {
			_getCurrentSession().update(e);
			_getCurrentSession().flush();
		} catch (Throwable t) {
			log.error(t.getMessage(), t);
		}

	}

}
