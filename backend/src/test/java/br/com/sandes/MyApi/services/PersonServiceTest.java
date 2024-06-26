package br.com.sandes.MyApi.services;

import br.com.sandes.MyApi.data.dto.v1.PersonDTO;
import br.com.sandes.MyApi.mapper.ModelMapper;
import br.com.sandes.MyApi.mocks.MockPerson;
import br.com.sandes.MyApi.model.Person;
import br.com.sandes.MyApi.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static javax.management.Query.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @Mock
    ModelMapper mapper;

    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonService service;

    @BeforeEach
    void setUp() throws Exception{
        mapper = new ModelMapper();
        input = new MockPerson();
    }

    @Test
    @DisplayName("Valida que é possivel listar todos os registros do banco de dados")
    void findAll() {

        List<Person> entities = input.mockEntityList();

        when(repository.findAll()).thenReturn(entities);

        var result = service.findAll();

        assertEquals(10, result.size());
        assertNotNull(result);
    }

    @Test
    @DisplayName("Valida que é possivel encontrar um recurso pelo seu id")
    void findById() {

        Person dto = input.mockEntity(1);
        dto.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(dto));

        var result = service.findById(1L);

        assertNotNull(result);
        assertEquals(result.getKey(), 1L);
        assertEquals(result.getName(), "Test name 1");
        assertEquals(result.getAddress(), "Test address 1");
        assertEquals(result.getGender(), "Female");
    }
}