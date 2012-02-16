package com.mschmidt.starter.api.rest.resource;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mschmidt.starter.entity.xml.TestPojo;

/**
 * Test resource
 * 
 * @author mschmidt18@gmail.com
 * 
 */
@Path("example")
public class ExampleResource {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHtml() {
		return "<html><head></head><body>\n"
				+ "This is an easy resource (as html text).\n"
				+ "</body></html>";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPlain() {
		return "This is an easy resource (as plain text)";
	}

	@GET
	@Path("xml")
	@Produces(MediaType.APPLICATION_XML)
	public TestPojo getXml() {
		TestPojo test = new TestPojo();
		test.setValue("test");
		test.setDesc("desc");
		test.setDate(new Date());
		return test;
	}
}
