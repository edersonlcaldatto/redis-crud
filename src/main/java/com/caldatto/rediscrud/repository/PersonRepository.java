package com.caldatto.rediscrud.repository;

import java.util.Map;
import java.util.Random;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.caldatto.rediscrud.model.Person;

@Repository
public class PersonRepository {

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    public PersonRepository(
            RedisTemplate<String, Object> redisTemplate) {

        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(Person person) {
        hashOperations.put("person", new Random(100), person);
    }

    public Person getOne(Long id){
        return (Person) hashOperations.get("person", id);
    }

    public Map<String, Person> getAll(){
        return hashOperations.entries("person");
    }

}
