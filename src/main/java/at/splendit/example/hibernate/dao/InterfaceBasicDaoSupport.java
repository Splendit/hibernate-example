package at.splendit.example.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import at.splendit.example.hibernate.domain.AbstractEntityObject;

public interface InterfaceBasicDaoSupport<E extends AbstractEntityObject<I>, I extends Serializable> {

	public E findById(I id);

	public void update(E e);

	public List<E> findAll();

	public void saveOrUpdate(E e);

	public void delete(E e);

	public void merge(E e);

	public List<E> findByCriteria(Criterion criterion);

	public void shutdown();
}
