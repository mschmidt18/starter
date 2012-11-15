/**
 * 
 */
package com.mschmidt.starter.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mschmidt.starter.dao.IBaseDAO;
import com.mschmidt.starter.dao.PersonDAO;
import com.mschmidt.starter.entity.Person;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@Service
public class PersonBO extends BaseBO<Person> {

	@Autowired
	private PersonDAO personDAO;

	@Override
	protected IBaseDAO<Person, Long> getBaseDAO() {
		return personDAO;
	}
}
