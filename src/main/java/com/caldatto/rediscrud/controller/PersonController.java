package com.caldatto.rediscrud.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caldatto.rediscrud.model.Person;
import com.caldatto.rediscrud.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping
    public void save(@RequestBody Person person){
        personService.save(person);
    }

    @GetMapping
    public Map<String, Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getOne(@RequestParam("id") Long id) {
        return personService.getOne(id);
    }
}
