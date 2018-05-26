package com.trungtamjava.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.model.Person;

@Component
public class PersonValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return arg0.isAssignableFrom(Person.class);
	}

	public void validate(Object object, Errors errors) {
		Person p = (Person) object;

		if (p.getName() == null || p.getName().length() == 0) {
			errors.rejectValue("name", "error.name.required");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.age.required");

	}

}
