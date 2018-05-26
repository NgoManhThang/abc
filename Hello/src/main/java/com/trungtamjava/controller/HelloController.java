package com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trungtamjava.model.Order;
import com.trungtamjava.model.Person;
import com.trungtamjava.validator.PersonValidator;

@Controller
public class HelloController {

	@Autowired
	@Qualifier("personB")
	private Person person;

	@Autowired
	private Order order;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PersonValidator personValidator;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(Model model) {
		// String mess = "Trung tam java";
		String mess = messageSource.getMessage("person.name", new Object[] {}, null);
		model.addAttribute("msg", mess);
		return "hello";
	}

	@RequestMapping(value = "/hello1")
	public String sayHello1(HttpServletRequest request) {
		String mess = "Trung tam java 1235";
		request.setAttribute("msg", mess);
		return "hello";
	}

	@RequestMapping(value = "/person")
	public String sayHello2(HttpServletRequest request) {
		String mess = "Trung tam java 1235";
		request.setAttribute("msg", person);
		request.setAttribute("msg2", order);
		return "person";
	}

	@RequestMapping(value = "/person2")
	public ModelAndView sayHello3(HttpServletRequest request) {
		String mess = "Trung tam java 1235";
		request.setAttribute("msg", person);
		request.setAttribute("msg2", order);
		return new ModelAndView("person");
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public ModelAndView addUser(ModelMap map) {
		Person p = new Person();
		map.addAttribute("person", p);
		return new ModelAndView("add-user");
	}

	/*
	 * @RequestMapping(value = "/user/add", method=RequestMethod.POST) public
	 * ModelAndView addUser(ModelMap map,
	 * 
	 * @RequestParam(value="name", required = false) String name,
	 * 
	 * @RequestParam(value="age", required = false) Integer age) {
	 * map.addAttribute("msg", name); return new ModelAndView("hello"); }
	 */

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ModelAndView addUser(ModelMap map, @ModelAttribute("person") Person person, BindingResult errors) {

		personValidator.validate(person, errors);
		if (errors.hasErrors()) {
			return new ModelAndView("add-user");
		}

		map.addAttribute("msg", person.getName());
		map.addAttribute("p", person);
		return new ModelAndView("hello");
	}

	@RequestMapping(value = "/user/{name}/update", method = RequestMethod.GET)
	public ModelAndView getUser(ModelMap map, @PathVariable("name") String name) {
		Person p = new Person();
		p.setName(name);
		map.addAttribute("person", p);
		return new ModelAndView("view-edit");
	}

}
