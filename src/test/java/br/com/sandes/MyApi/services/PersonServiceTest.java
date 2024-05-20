package br.com.sandes.MyApi.services;

import br.com.sandes.MyApi.data.dto.v1.PersonDTO;
import br.com.sandes.MyApi.mocks.MockPerson;
import br.com.sandes.MyApi.model.Person;
import br.com.sandes.MyApi.repositories.PersonRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    MockPerson input;

    @Mock
    PersonRepository repository;

    @InjectMocks
    PersonService service;

    @BeforeEach
    void setUp() throws Exception{
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

    @Test
    @DisplayName("Valida que é possivel criar um novo recurso")
    void create() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonDTO dto = input.mockDto(1);
        dto.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(dto);
    }
//
//    @Test
//    void update() {
//    }
}