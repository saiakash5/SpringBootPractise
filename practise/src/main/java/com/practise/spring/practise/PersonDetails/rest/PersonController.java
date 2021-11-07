package com.practise.spring.practise.PersonDetails.rest;

import com.practise.spring.practise.PersonDetails.model.Parameters;
import com.practise.spring.practise.PersonDetails.model.SampleBean;
import com.practise.spring.practise.PersonDetails.service.PersonService;
import com.practise.spring.practise.PersonDetails.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

//    @GetMapping(path = "/hello")
//    public String getHello(){
//        return "Hello World";
//    }

    @Autowired
    PersonService personService;

    @GetMapping(path = "/persons")
    private List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(path = "/person/{id}")
    private Person getPerson(@PathVariable int id) throws Exception {
        try {
            return personService.getPerson(id);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Person not found with id : "+id,e);
        }
    }

    @PostMapping(path = "/person")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<Person> savePerson(@RequestBody Person person){
        Person savedPerson = personService.savePerson(person);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPerson.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/persons")
    @ResponseStatus(code = HttpStatus.CREATED)
    private ResponseEntity<Person> saveAllPersons(List<Person> persons){
        personService.saveAllPersons(persons);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/")
                .build().toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/person/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    private void deletePerson(@PathVariable int id){
        try {
            personService.deletePerson(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Person not found with id : "+id);
        }
    }
    @DeleteMapping(path = "/persons")
    private ResponseEntity<Person> deleteAll(){
        personService.deleteAll();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/")
                .build().toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/person/{id}")
    private Person updatePerson(@RequestBody Person person,@PathVariable int id){
        return personService.updatePerson(person,id);
    }

    @GetMapping(path = "/person_proc/{id}")
    private List<Map<?,?>> getPersonProc(@PathVariable int id){
        return personService.getPersonProc(id);
    }

    @GetMapping(path = "/person_proc_details")
    private List<Map<?,?>> getPersonDetailsProc(){
        return personService.getPersonDetails();
    }

    @GetMapping(path = "/test/db")
    private List<SampleBean> getSampleBean(@RequestBody Parameters parameters){
        if(parameters.getType().equals("test")){
            List<Map<?,?>>  sampleBeans = personService.getPersonDetails();
            List<SampleBean> output = new ArrayList<>();
            for(Map<?,?> s : sampleBeans ){
                output.add(new SampleBean(Integer.parseInt(String.valueOf(s.get("user_id"))),s.get("first_name").toString(),s.get("last_name").toString(),s.get("username").toString()));
            }
            return output;
        }
        return null;
    }
}
