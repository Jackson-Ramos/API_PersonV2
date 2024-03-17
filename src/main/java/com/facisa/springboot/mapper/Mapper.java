package com.facisa.springboot.mapper;

import java.util.ArrayList;
import java.util.List;

import com.facisa.springboot.dto.PersonDto;
import com.facisa.springboot.entities.Person;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;

public class Mapper {
	
	private static final ModelMapper mapper = new ModelMapper();
	
	static {
		mapper.createTypeMap(Person.class, PersonDto.class).addMapping(Person::getId, PersonDto::setKey);
	}
	
	public static <O, D> D parseObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <O, D> @NotNull List<D> parseListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<>();
		for (O o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}