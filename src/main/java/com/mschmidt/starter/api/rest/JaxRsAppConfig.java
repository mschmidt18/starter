package com.mschmidt.starter.api.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.mschmidt.starter.api.rest.resource.ExampleResource;

/**
 * JAX-RS application configuration implementation. Add all resources classes
 * here
 * 
 * @author mschmidt18@gmail.com
 * 
 */
public class JaxRsAppConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> rrcs = new HashSet<Class<?>>();
		rrcs.add(ExampleResource.class);
		return rrcs;
	}
}
