package com.practise.spring.practise.PersonDetails.service;

import com.practise.spring.practise.PersonDetails.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public interface PersonDaoService extends CrudRepository<Person, Integer> {

}
