package com.javaguides.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaguides.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	void deleteProductById(Long id);
	
	Optional<Product> findProductById(Long id);

}
