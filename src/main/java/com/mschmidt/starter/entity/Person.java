/**
 * 
 */
package com.mschmidt.starter.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@javax.persistence.Entity
@Table
public class Person extends Entity {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private Address address;
	private Set<PhoneNumber> phoneNumbers;

	@Column(nullable = false, updatable = true, length = 500)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false, updatable = true, length = 500)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
