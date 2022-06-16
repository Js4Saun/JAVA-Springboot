package com.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.springboot.model.CartItems;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Long>{
	
	void deleteCartItemById(Long id);
	
	Optional<CartItems> findCartById(Long id);

}
