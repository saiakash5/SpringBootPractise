package com.practise.spring.practise.PersonDetails.service;

import com.practise.spring.practise.PersonDetails.model.Person;
import com.practise.spring.practise.PersonDetails.model.SampleBean;

import java.util.List;
import java.util.Map;

public interface PersonService {

    List<Person> getAllPersons();

    Person getPerson(int id) throws Exception;

    Person savePerson(Person person);

    void saveAllPersons(List<Person> persons);

    void deletePerson(int id) throws Exception;

    void deleteAll();

    Person updatePerson(Person person, int id);

    List<Map<?, ?>> getPersonProc(int id);

    List<Map<?,?>> getPersonDetails();

    List<SampleBean> getSampleBeans();
}
