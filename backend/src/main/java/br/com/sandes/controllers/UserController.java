package br.com.sandes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sandes.model.Users;
import br.com.sandes.services.UserServices;

@RestController
@RequestMapping(name = "/myapi")
public class UserController {
	
	@Autowired
	private UserServices services;

	@GetMapping
	public List<Users> findAll(){
		return services.findAll();
	}
	
	@PostMapping
	public Users create(@RequestBody Users user) {
		return services.create(user);
	}
}
