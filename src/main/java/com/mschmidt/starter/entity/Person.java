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

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@javax.persistence.Entity
@Table
@Indexed
public class Person extends Entity {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private Address address;
	private Set<PhoneNumber> phoneNumbers;

	@Field(name = "firstName", index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = false, updatable = true, length = 500)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Field(name = "lastName", index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
