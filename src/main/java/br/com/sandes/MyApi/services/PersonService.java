package br.com.sandes.MyApi.services;

import br.com.sandes.MyApi.controllers.PersonController;
import br.com.sandes.MyApi.data.dto.v1.PersonDTO;
import br.com.sandes.MyApi.exception.RequiredObjectNullException;
import br.com.sandes.MyApi.exception.ResourceNotFoundException;
import br.com.sandes.MyApi.mapper.ModelMapper;
import br.com.sandes.MyApi.model.Person;
import br.com.sandes.MyApi.repositories.PersonRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonDTO> findAll(){
        logger.info("Found all people!");

        var entities = ModelMapper.parseListObject(repository.findAll(), PersonDTO.class);

        entities.forEach(p -> p.add(
                        linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return entities;
    }

    public PersonDTO findById(Long id){
        logger.info("Found one person!");

        var entity = repository.findById(id);

        var dto = ModelMapper.parseObject(entity, PersonDTO.class);

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());

        return dto;
    }

    public PersonDTO create(PersonDTO personDTO){
        if(personDTO == null){
            throw new RequiredObjectNullException();
        }

        logger.info("Person created");

        var entity = ModelMapper.parseObject(personDTO, Person.class);

        var dto = ModelMapper.parseObject(repository.save(entity), PersonDTO.class);

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());

        return dto;
    }

    public PersonDTO update(PersonDTO person){
        if(person == null){
            throw new RequiredObjectNullException();
        }

        logger.info("Person updated!");

        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setName(person.getName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        var dto = ModelMapper.parseObject(repository.save(entity), PersonDTO.class);

        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());

        return dto;
    }

    public void delete(Long id){
        logger.info("Person deleted!");

        var entity = repository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
