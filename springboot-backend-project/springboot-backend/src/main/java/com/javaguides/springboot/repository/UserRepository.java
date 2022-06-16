package com.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.springboot.model.User;

// JpaRepository takes two params, the name of the entity and the type of the primary key

// Spring Data JPA provides @Repository internally
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	void deleteUserById(Long id);
	
	Optional<User> findUserById(Long id);
	
	Optional<User> findUserByuserName(String userName);
}
