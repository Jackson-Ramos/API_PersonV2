package com.facisa.springboot.services;

import java.util.List;
import java.util.UUID;

import com.facisa.springboot.controlles.PersonController;
import com.facisa.springboot.dto.PersonDto;
import com.facisa.springboot.mapper.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.facisa.springboot.entities.Person;
import com.facisa.springboot.exceptions.ResourceNotFoundException;
import com.facisa.springboot.repositories.PersonRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	/// FindById
	public ResponseEntity<PersonDto> findById(UUID id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		PersonDto dto = Mapper.parseObject(entity, PersonDto.class);
		return ResponseEntity.status(HttpStatus.OK)
				.body(dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("Lista de produtos")));
	}
	
	/// FindAll
	public ResponseEntity<List<PersonDto>> findAll() {
		var persons = Mapper.parseListObjects(repository.findAll(), PersonDto.class);
		persons.stream()
				.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return ResponseEntity.status(HttpStatus.OK).body(persons);
	}
	
	/// Save
	public ResponseEntity<PersonDto> save(Person person) {
		PersonDto dto = Mapper.parseObject(repository.save(person), PersonDto.class);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel()));
	}
	
	/// Update
	public ResponseEntity<PersonDto> update(UUID id, Person person) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		BeanUtils.copyProperties(person, entity);
		PersonDto dto = Mapper.parseObject(repository.save(person), PersonDto.class);
		return ResponseEntity.status(HttpStatus.OK)
				.body(dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel()));
	}
	
	/// Delete
	public ResponseEntity<PersonDto> Delete(UUID id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
		return ResponseEntity.status(HttpStatus.OK).body(Mapper.parseObject(entity, PersonDto.class));
	}
	
	
}
