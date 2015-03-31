package at.splendit.example.hibernate.spring;

import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import at.splendit.example.hibernate.app.AppSingleton;

public final class SpringUtils {

	private SpringUtils() {
	}

	/**
	 * Get the bean with the specified name, or throw an exception.
	 */
	public static <E> E getRequiredBean(String name, Class<E> clazz) throws NoSuchBeanDefinitionException {
		return (E) getApplicationContext().getBean(name, clazz);
	}

	/**
	 * check if a bean with given name exists
	 */
	public static boolean containsBean(String name) {
		return getApplicationContext().containsBean(name);
	}

	/**
	 * Get the bean with the specified name, or null if no such bean exists.
	 */
	public static <E> E getBean(String name, Class<E> clazz) {
		try {
			return (E) getApplicationContext().getBean(name, clazz);
		} catch (NoSuchBeanDefinitionException e) {
			return null;
		}
	}

	/**
	 * Get the bean with the specified name, or null if no such bean exists.
	 */
	public static <E> Map<String, E> getBeansOfType(Class<E> clazz) {
		try {
			return (Map<String, E>) getApplicationContext().getBeansOfType(clazz);
		} catch (NoSuchBeanDefinitionException e) {
			return null;
		}
	}

	/**
	 * Get the bean with the specified name, or throw an exception.
	 */
	public static <E> E getRequiredBean(Class<E> clazz) throws NoSuchBeanDefinitionException {
		return getRequiredBean(clazz.getName(), clazz);
	}

	/**
	 * Get the bean with the specified name, or null if no such bean exists.
	 */
	public static <E> E getBean(Class<E> clazz) {
		return getBean(clazz.getName(), clazz);
	}

	/**
	 * Normal code should not use this method, but access beans via the other
	 * get methods defined on this class.
	 */
	static ApplicationContext getApplicationContext() {
		return AppSingleton.getApplicationContext();
	}
}
