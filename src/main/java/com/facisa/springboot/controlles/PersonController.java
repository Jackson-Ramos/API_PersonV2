package com.facisa.springboot.controlles;

import java.util.List;
import java.util.UUID;

import com.facisa.springboot.dto.PersonDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facisa.springboot.entities.Person;
import com.facisa.springboot.services.PersonService;

@RestController
@RequestMapping("/person")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Find all People", description = "Find all People",
			tags = {"People"}, responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = {
							@Content(
									mediaType = "application/json",
									array = @ArraySchema(schema = @Schema(implementation = PersonDto.class))
							)
					}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Serve Erro", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<List<PersonDto>> findAll() {
		return personService.findAll();
	}
	
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Find a Person", description = "Find a Person",
			tags = {"People"}, responses = {
			@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PersonDto.class))
			),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Serve Erro", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<PersonDto> findById(@PathVariable(value = "id") UUID id) {
		return personService.findById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Adds a new Person",
			description = "Add a new Person by passing in JSON, XML or YML representation of the person!",
			tags = {"People"}, responses = {
			@ApiResponse(description = "Create", responseCode = "201",
					content = @Content(schema = @Schema(implementation = PersonDto.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Internal Serve Erro", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<PersonDto> save(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Delete a Person",
			description = "Delete a Person by passing in JSON, XML or YML representation of the person!",
			tags = {"People"}, responses = {
			@ApiResponse(description = "No Content", responseCode = "204",
					content = @Content(schema = @Schema(implementation = PersonDto.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Serve Erro", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<PersonDto> delete(@PathVariable(name = "id") UUID id) {
		return personService.Delete(id);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Updates a Person",
			description = "Updates a Person by passing in JSON, XML or YML representation of the person!",
			tags = {"People"}, responses = {
			@ApiResponse(description = "Updated", responseCode = "200",
					content = @Content(schema = @Schema(implementation = PersonDto.class))
			),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Serve Erro", responseCode = "500", content = @Content),
	}
	)
	public ResponseEntity<PersonDto> update(@PathVariable(value = "id") UUID id, @RequestBody Person person) {
		return personService.update(id, person);
	}
	
}
