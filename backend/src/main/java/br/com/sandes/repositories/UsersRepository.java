package br.com.sandes.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sandes.model.Users;

public interface UsersRepository extends JpaRepository<Users, UUID>{}