package br.com.sandes.MyApi.mapper;

import br.com.sandes.MyApi.data.vo.v1.PersonDTO;
import br.com.sandes.MyApi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

    private final static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    static {
        mapper.createTypeMap(Person.class, PersonDTO.class)
                .addMapping(Person::getId, PersonDTO::setKey);

        mapper.createTypeMap(PersonDTO.class, Person.class)
                .addMapping(PersonDTO::getKey, Person::setId);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination){
        List<D> destinationObject = new ArrayList<D>();

        for(O o: origin){
            destinationObject.add(mapper.map(o, destination));
        }

        return destinationObject;
    }
}
