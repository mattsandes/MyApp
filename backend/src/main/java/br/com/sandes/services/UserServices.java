package br.com.sandes.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sandes.model.Users;
import br.com.sandes.repositories.UsersRepository;

@Service
public class UserServices {
	
	@Autowired
	private UsersRepository repository;
	
	private static final Logger logger = Logger.getLogger(UserServices.class.getName());
	
	public List<Users> findAll(){
		logger.info("Found all Users on database!");
		return repository.findAll();
	}
	
	public Users create(Users user) {
		if(user == null) {
			throw new IllegalArgumentException("Argument can't be null");
		}
		
		logger.info("User created!");
		
		return repository.save(user);
	}
}
