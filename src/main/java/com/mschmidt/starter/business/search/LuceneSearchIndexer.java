/**
 * 
 */
package com.mschmidt.starter.business.search;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mschmidt.starter.dao.search.LucenePersonDAO;
import com.mschmidt.starter.utils.ApplicationProperties;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@Service
public class LuceneSearchIndexer {
	private static final Log log = LogFactory.getLog(LuceneSearchIndexer.class);

	@Autowired
	private LucenePersonDAO lucenePersonDAO;

	@Autowired
	private ApplicationProperties appProperties;

	@PostConstruct
	public void init() {
		// only rebuild the index if specified in the properties file
		if (appProperties.getReindex()) {
			reindexPersons();
		}
	}

	private void reindexPersons() {
		log.info("Indexing Persons...");
		lucenePersonDAO.reIndex();
	}
}
