package com.trungtamjava.service;

import com.trungtamjava.entity.PersonEntity;
import com.trungtamjava.model.Person;

public interface PersonService {
	boolean addPerson(Person person);

	boolean updatePerson(Person person);

	boolean deletePerson(int id);

	Person getPersonById(int id);

	void search(Person person);
}
