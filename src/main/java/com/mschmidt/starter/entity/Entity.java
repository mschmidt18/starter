/**
 * 
 */
package com.mschmidt.starter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author mschmidt18@gmail.com
 * 
 */

@MappedSuperclass
public abstract class Entity implements Serializable {
	private static final long serialVersionUID = -3037325210588178986L;

	private Long id;
	private Date created_date;
	private Date modified_date;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

}
