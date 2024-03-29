package com.facisa.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonDto extends RepresentationModel<PersonDto> implements Serializable {
	private static final long serialVersionID = 1L;
	@JsonProperty("id")
	private UUID key;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	
	public PersonDto(UUID key, String firstName, String lastName, String address, String gender) {
		this.key = key;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}
	
	public PersonDto() {
	}
	
	public UUID getKey() {
		return key;
	}
	
	public void setKey(UUID key) {
		this.key = key;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PersonDto personDto = (PersonDto) o;
		return Objects.equals(key, personDto.key)
				&& Objects.equals(firstName, personDto.firstName)
				&& Objects.equals(lastName, personDto.lastName)
				&& Objects.equals(address, personDto.address)
				&& Objects.equals(gender, personDto.gender);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), key, firstName, lastName, address, gender);
	}
	
	@Override
	public String toString() {
		return "PersonDto{" +
				"key=" + key +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address='" + address + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
}
