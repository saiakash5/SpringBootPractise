package com.practise.spring.practise.PersonDetails.service;

import com.practise.spring.practise.PersonDetails.model.Person;
import com.practise.spring.practise.PersonDetails.model.SampleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDaoService personDaoService;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        personDaoService.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public Person getPerson(int id) throws Exception {
        try {
            return personDaoService.findById(id).get();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public Person savePerson(Person person) {
        personDaoService.save(person);
        return person;
    }

    @Override
    public void saveAllPersons(List<Person> persons) {
        personDaoService.saveAll(persons);
    }

    @Override
    public void deletePerson(int id) throws Exception {
        try {
            personDaoService.deleteById(id);
        }
        catch (Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        personDaoService.deleteAll();
    }

    @Override
    public Person updatePerson(Person person, int id) {
        Person existingPerson = personDaoService.findById(id).get();
        this.updateExistingPerson(existingPerson,person);
        return personDaoService.save(existingPerson);
    }

    @Override
    public List<Map<?, ?>> getPersonProc(int id) {
        return personRepository.getPerson(id);
    }

    @Override
    public List<Map<?, ?>> getPersonDetails() {
        return personRepository.getPersonDetails();
    }

    @Override
    public List<SampleBean> getSampleBeans() {
        return personRepository.getSampleBeanList();
    }

    private void updateExistingPerson(Person existingPerson, Person person) {
        if(person.getFirst_name()!=null){
            existingPerson.setFirst_name(person.getFirst_name());
        }
        existingPerson.setLast_name(person.getLast_name());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setGender(person.getGender());
        existingPerson.setUsername(person.getUsername());
        existingPerson.setCreated_on(person.getCreated_on());
    }
}
