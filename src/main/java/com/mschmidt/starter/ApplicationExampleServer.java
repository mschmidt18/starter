package com.mschmidt.starter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.Component;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.jaxrs.JaxRsApplication;

import com.mschmidt.starter.api.rest.RestApplication;

/**
 * Contains main that can be run to start the application within the embedded
 * Restlet server
 * 
 * @author mschmidt18@gmail.com
 * 
 */
@Deprecated
public class ApplicationExampleServer {

	private static Log log = LogFactory.getLog(ApplicationExampleServer.class);

	/**
	 * run this to start the application in the embedded Restlet server
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// create Component (as ever for Restlet)
		Component comp = new Component();
		Server server = comp.getServers().add(Protocol.HTTP, 8182);

		// create JAX-RS runtime environment
		JaxRsApplication application = new RestApplication(comp.getContext());

		// Attach the application to the component and start it
		comp.getDefaultHost().attach(application);
		comp.start();

		log.info("Server started on port " + server.getPort());
	}
}
