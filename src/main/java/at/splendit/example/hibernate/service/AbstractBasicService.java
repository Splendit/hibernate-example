package at.splendit.example.hibernate.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import at.splendit.example.hibernate.dao.InterfaceBasicDaoSupport;
import at.splendit.example.hibernate.domain.AbstractEntityObject;

@Transactional
public abstract class AbstractBasicService<E extends AbstractEntityObject<I>, I extends Serializable, D extends InterfaceBasicDaoSupport<E, I>>
		implements InterfaceBasicService<E, I, D> {

	protected D dao;

	@Required
	public void setDao(D dao) {
		this.dao = dao;
	}

	public E findById(I id) {
		return dao.findById(id);
	}

	public List<E> findAll() {
		return dao.findAll();
	}

	public void save(E e) {
		dao.saveOrUpdate(e);
	}

	public void delete(E e) {
		dao.delete(e);
	}

	public void update(E e) {
		dao.update(e);
	}

	public void shutdown() {
		dao.shutdown();
	}

}
