/**
 * 
 */
package com.mschmidt.starter.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@javax.persistence.Entity
@Table
public class Address extends Entity {
	private static final long serialVersionUID = 1L;

	private String street;
	private String city;
	private String state;
	private String zip;

	@Column(nullable = false)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(nullable = false)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
