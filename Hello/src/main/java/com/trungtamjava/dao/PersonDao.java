package com.trungtamjava.dao;

import com.trungtamjava.entity.PersonEntity;
import com.trungtamjava.model.Person;

public interface PersonDao {
	boolean addPerson(PersonEntity person);
	
	boolean updatePerson(PersonEntity person);
	
	boolean deletePerson(int id);
	
	Person getPersonById(int id);
	
	void search(PersonEntity person);
}
