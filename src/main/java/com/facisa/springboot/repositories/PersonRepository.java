package com.facisa.springboot.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facisa.springboot.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

//	List<Person> findAllByActiveTrue();
}
