/**
 * 
 */
package com.mschmidt.starter.test.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mschmidt.starter.utils.ApplicationProperties;

/**
 * @author mschmidt
 * 
 */
@Service
public class DBUnitDataInitializer implements InitializingBean
{
	private static final Logger log = Logger
			.getLogger(DBUnitDataInitializer.class);

	// @Autowired
	// private PersonBO personBO;

	@Autowired
	private ApplicationProperties appProps;

	private void loadData()
	{
		// loadPersons();
	}

	// private void loadPersons()
	// {
	// Person p1 = new Person();
	// p1.setFirstName("Matt");
	// p1.setLastName("Schmidt");
	//
	// personBO.save(p1);
	// }

	@Override
	public void afterPropertiesSet() throws Exception
	{
		if (Boolean.parseBoolean(appProps.getProperty("app.seedDatabase")))
		{
			loadData();
		}
	}

}
