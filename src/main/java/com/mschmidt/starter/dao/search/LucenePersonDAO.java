/**
 * 
 */
package com.mschmidt.starter.dao.search;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import com.mschmidt.starter.entity.Person;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@Repository
public class LucenePersonDAO extends LuceneDAO<Person, Long> {

	private static final String[] SEARCH_FIELDS = { "firstName", "lastName" };

	private static final String[] PROJECTED_FIELDS = {};

	@Override
	protected FilterType getFilterType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getSearchFields() {
		return SEARCH_FIELDS;
	}

	@Override
	protected String[] getProjectedFields() {
		return PROJECTED_FIELDS;
	}

	@Override
	public List<Long> retrieveEntitiesToIndex() {
		Query query = getEntityManager().createQuery(
				"select p.id from Person as p");
		List<Long> results = query.getResultList();
		return results;
	}

	@Override
	protected Person retrieveEntityToIndex(Long id) {
		Query query = getEntityManager().createQuery(
				"select p from Person as p where p.id = :id");
		query.setParameter("id", id);
		Person result = (Person) query.getSingleResult();
		return result;
	}

}
