/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> findById(@RequestParam("id") String id) {
        return repository.findById(id);
    }

    @PostMapping
    public Person add(@RequestBody Person p) {
        //p.setId((persons.size()+1)+"");
        p = repository.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id") String id) {
        repository.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody Person p) {
        /*Person person = persons.stream().filter(it -> it.getId().equals(p.getId())).findFirst().get();
        persons.set(persons.indexOf(person), p);*/
        repository.save(p);
    }

    @GetMapping("/lastname/{lastName}")
    public List<Person> findByLastName(@RequestParam("lastName") String lastName) {
        return repository.findByLastName(lastName);
    }

    @GetMapping("/age/{age}")
    public List<Person> findByAgeGreaterThan(@RequestParam("age") int age) {
        return repository.findByAgeGreaterThan(age);
    }

}
