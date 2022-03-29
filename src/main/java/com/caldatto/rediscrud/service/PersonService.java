package com.caldatto.rediscrud.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.caldatto.rediscrud.model.Person;
import com.caldatto.rediscrud.repository.PersonRepository;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public Person getOne(Long id){
        return personRepository.getOne(id);
    }

    public Map<String, Person> getAll(){
        return personRepository.getAll();
    }

}
