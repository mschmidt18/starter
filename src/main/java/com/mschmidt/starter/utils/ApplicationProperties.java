package com.mschmidt.starter.utils;

import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 
 * @author mschmidt18@gmail.com
 * 
 */
@Service
public class ApplicationProperties implements InitializingBean
{

	@Autowired
	@Qualifier(value = "propertiesBean")
	private Properties properties;

	@Override
	public void afterPropertiesSet() throws Exception
	{
		if (properties == null)
		{
			throw new IllegalArgumentException(
					"Property 'properties' is required");
		}
	}

	public boolean getReindex()
	{
		return Boolean.parseBoolean(properties.getProperty("reindex"));
	}

	public String getProperty(String property)
	{
		return properties.getProperty(property);
	}

	// example
	// public String getBaseUrl() {
	// return properties.getProperty("seekr.baseUrl");
	// }

}
