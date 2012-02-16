package com.mschmidt.starter.api.rest;

import org.restlet.ext.jaxrs.JaxRsApplication;

/**
 * Restlet application that runs in a servlet container
 * 
 * @author mschmidt18@gmail.com
 * 
 */
public class RestApplication extends JaxRsApplication {

	public RestApplication(org.restlet.Context context) {
		super(context);
		this.add(new JaxRsAppConfig());

		// if needed
		// this.setGuard(...);
		// this.setRoleChecker(...);
	}

}
