/**
 * 
 */
package com.mschmidt.starter.business;

import java.util.List;

import com.mschmidt.starter.dao.IBaseDAO;
import com.mschmidt.starter.entity.Entity;

/**
 * @author mschmidt18@gmail.com
 * 
 */
public abstract class BaseBO<T extends Entity> {

	protected abstract IBaseDAO<T, Long> getBaseDAO();

	/**
	 * Find an entity by its primary key
	 * 
	 * @param id
	 *            the primary key
	 * @return the entity
	 */
	public T findById(final Long id) {
		return getBaseDAO().findById(id);
	}

	/**
	 * Load all entities.
	 * 
	 * @return the list of entities
	 */
	public List<T> findAll() {
		return getBaseDAO().findAll();
	}

	/**
	 * Find entities based on an example.
	 * 
	 * @param exampleInstance
	 *            the example
	 * @return the list of entities
	 */
	public List<T> findByExample(final T exampleInstance) {
		return getBaseDAO().findByExample(exampleInstance);
	}

	/**
	 * Count all entities.
	 * 
	 * @return the number of entities
	 */
	public int countAll() {
		return getBaseDAO().countAll();
	}

	/**
	 * Count entities based on an example.
	 * 
	 * @param exampleInstance
	 *            the search criteria
	 * @return the number of entities
	 */
	public int countByExample(final T exampleInstance) {
		return getBaseDAO().countByExample(exampleInstance);
	}

	/**
	 * save an entity. This can be either a INSERT or UPDATE in the database.
	 * 
	 * @param entity
	 *            the entity to save
	 * 
	 * @return the saved entity
	 */
	public T save(final T entity) {
		return getBaseDAO().save(entity);
	}

	/**
	 * delete an entity from the database.
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	public void delete(final T entity) {
		getBaseDAO().delete(entity);
	}

}
