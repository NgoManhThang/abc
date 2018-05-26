package com.trungtamjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.dao.PersonDao;
import com.trungtamjava.model.Person;
import com.trungtamjava.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonDao personDao;
	
	public boolean addPerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void search(Person person) {
		// TODO Auto-generated method stub
		
	}

}
