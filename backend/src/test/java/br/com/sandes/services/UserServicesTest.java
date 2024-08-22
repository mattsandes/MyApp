package br.com.sandes.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sandes.model.Users;
import br.com.sandes.repositories.UsersRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UserServicesTest {
	
	@InjectMocks
	private UserServices service;
	
	@Mock
	private UsersRepository repository;
	
	@Test
	@DisplayName("Valida que o metodo findAll() retorna todos os usuarios que estiverem no banco de dados")
	void canSeeHelloWorldOnMethod() {
		
		List<Users> users = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			users.add(new Users());
		}
		
		
		when(repository.findAll()).thenReturn(users);
		
		var result = service.findAll();
		
		assertNotNull(result);
		assertEquals(5, result.size());
	}
	
	@Test
	@DisplayName("Valida que é possivel criar recursos usando o metodo create()")
	void canCreateUsers() {
		Users user = new Users();
		
		user.setFirstName("Test First Name");
		user.setLastName("Test Last Name");
		user.setEmail("test.email@test.com");
		user.setAge(5);
		user.setId(UUID.randomUUID());
		user.setAddress("Test Address");
		
		when(repository.save(user)).thenReturn(user);
		
		var result = service.create(user);
		
		assertNotNull(result);
		assertEquals(result.getFirstName(), "Test First Name");
		assertEquals(result.getLastName(), "Test Last Name");
		assertEquals(result.getAge(), 5);
		assertEquals(result.getAddress(), "Test Address");
		assertEquals(result.getEmail(), "test.email@test.com");
		assertNotNull(result.getId());
	}

}
