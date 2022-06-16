package com.javaguides.springboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.javaguides.springboot.model.Product;

public interface ProductDAO extends CrudRepository<Product, Long>{
	
}
