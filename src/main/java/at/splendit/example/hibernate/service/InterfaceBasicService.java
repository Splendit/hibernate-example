package at.splendit.example.hibernate.service;

import java.io.Serializable;
import java.util.List;

import at.splendit.example.hibernate.dao.InterfaceBasicDaoSupport;
import at.splendit.example.hibernate.domain.AbstractEntityObject;

public interface InterfaceBasicService<E extends AbstractEntityObject<I>, I extends Serializable, D extends InterfaceBasicDaoSupport<E, I>> {

	public void setDao(D dao);

	public E findById(I id);

	public void update(E e);

	public List<E> findAll();

	public void save(E e);

	public void delete(E e);

	public void shutdown();

}
