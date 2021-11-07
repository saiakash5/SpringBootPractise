package com.practise.spring.practise.PersonDetails.service;

import com.practise.spring.practise.PersonDetails.model.SampleBean;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.spring.practise.PersonDetails.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "select * from getPerson(?1)",nativeQuery = true)
    List<Map<?, ?>> getPerson(int person_id);

    @Query(value = "select * from get_person_details()", nativeQuery = true)
    List<Map<?,?>> getPersonDetails();

    @Query(value = "select * from get_person_details()",nativeQuery = true)
    List<SampleBean> getSampleBeanList();
}
