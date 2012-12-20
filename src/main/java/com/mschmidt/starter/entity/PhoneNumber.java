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
public class PhoneNumber extends Entity {
	private static final long serialVersionUID = 1L;

	private String type;
	private String number;

	@Column(nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(nullable = false)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
