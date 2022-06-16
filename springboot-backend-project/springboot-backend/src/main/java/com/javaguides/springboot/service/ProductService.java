package com.javaguides.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.exception.EntityNotFoundException;
import com.javaguides.springboot.model.Product;
import com.javaguides.springboot.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product addProduct(Product product) 
	{
		return productRepository.save(product);
	}
	
	public List<Product> findAll(){ return productRepository.findAll(); }
	
	@Transactional
	public void deleteProduct(Long id) { productRepository.deleteProductById(id);}
	
	public Product findProductById(Long id) {
	
		return productRepository.findProductById(id) 
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
	}
}
