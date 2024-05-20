package br.com.sandes.MyApi.mocks;

import br.com.sandes.MyApi.data.dto.v1.PersonDTO;
import br.com.sandes.MyApi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity(){
        return mockEntity(0);
    }

    public PersonDTO mockDto(){
        return mockDto(0);
    }

    public List<PersonDTO> mockDtoList(){
        List<PersonDTO> dtos = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            dtos.add(mockDto(i));
        }

        return dtos;
    }

    public List<Person> mockEntityList(){
        List<Person> entities = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            entities.add(mockEntity(i));
        }

        return entities;
    }

    public PersonDTO mockDto(Integer number){
        PersonDTO person = new PersonDTO();

        person.setKey(number.longValue());
        person.setName("Test name " + number);
        person.setAddress("Test Address " + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");

        return person;
    }

    public Person mockEntity(Integer number){
        Person person = new Person();

        person.setId(number.longValue());
        person.setName("Test name " + number);
        person.setAddress("Test address " + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");

        return person;
    }
}
