/**
 * 
 */
package com.mschmidt.starter.dao;

import org.springframework.stereotype.Repository;

import com.mschmidt.starter.entity.Person;

/**
 * @author mschmidt18@gmail.com
 * 
 */
@Repository(value = "personDAO")
public class PersonDAO extends BaseDAO<Person, Long> {

}
