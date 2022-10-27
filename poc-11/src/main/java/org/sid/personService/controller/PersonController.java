package org.sid.personService.controller;

import org.sid.personService.model.Person;
import org.sid.personService.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/persons")
	public Page<Person> listPersons(@PageableDefault(sort = { "nom",
			"prenom", "dateNaissance" }, value = 20) Pageable pageable) {
		return personRepository.findAll(pageable);
	}
}
