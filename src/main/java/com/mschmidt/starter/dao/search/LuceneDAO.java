/**
 * 
 */
package com.mschmidt.starter.dao.search;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.context.annotation.FilterType;

import com.mschmidt.starter.dao.BaseDAO;
import com.mschmidt.starter.entity.Entity;

/**
 * @author mschmidt18@gmail.com
 * 
 */
public abstract class LuceneDAO<E extends Entity, ID extends Serializable>
		extends BaseDAO<E, ID> {

	private static final Log log = LogFactory.getLog(LuceneDAO.class);

	public List<E> executeSearch(String keyword) {
		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(getEntityManager());
		// create native Lucenequery using the query DSL
		// alternatively you can write the Lucene query using the Lucene query
		// parser
		// or the Lucene programmatic API. The Hibernate Search DSL is
		// recommended
		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
				.buildQueryBuilder().forEntity(getEntityClass()).get();
		Query query = qb.keyword().onFields(getSearchFields())
				.matching(keyword).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query persistenceQuery = fullTextEntityManager
				.createFullTextQuery(query, getEntityClass());

		// execute search
		List<E> result = persistenceQuery.getResultList();
		return result;
	}

	public void reIndex() {
		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(getEntityManager());

		try {
			// TODO configure MassIndexer with fine tuning
			fullTextEntityManager.createIndexer(getEntityClass())
					.startAndWait();
		} catch (InterruptedException e) {
			log.error(e, e);
		}
	}

	public void reIndex(ID id) {
		purgeIndex(id);
		doReIndex(id);
	}

	public void doReIndex(final ID id) {
		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(getEntityManager());
		E entity = null;

		try {
			entity = retrieveEntityToIndex(id);
			if (entity != null) {
				fullTextEntityManager.index(entity);
			}
		} catch (Exception e) {
			log.error(
					"Unknown exception indexing entity " + id + ": "
							+ e.getMessage(), e);
		}
	}

	private void purgeIndex(final ID id) {
		FullTextEntityManager fullTextEntityManager = Search
				.getFullTextEntityManager(getEntityManager());
		fullTextEntityManager.purge(getEntityClass(), id);
	}

	/**
	 * @return the types of filters applicable to this search
	 */
	protected abstract FilterType getFilterType();

	/**
	 * @return the default Lucene document fields to search in the index
	 */
	protected abstract String[] getSearchFields();

	/**
	 * @return the fields to project in the search results
	 */
	protected abstract String[] getProjectedFields();

	/**
	 * @return entities to index when the DAO is initialized
	 */
	public abstract List<ID> retrieveEntitiesToIndex();

	/**
	 * 
	 * @param id
	 * @return entity to index when the DAO is initialized
	 */
	protected abstract E retrieveEntityToIndex(ID id);
}
