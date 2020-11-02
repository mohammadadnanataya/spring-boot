/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ASUS
 */
public interface PersonRepository extends MongoRepository<Person, String> {
    
    public List<Person> findByLastName(String lastName);
    public List<Person> findByAgeGreaterThan(int age);
    
}
