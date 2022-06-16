package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javaguides.springboot.model.Product;
import com.javaguides.springboot.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct()
    {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK); 
    }
	
	@GetMapping("/productDetails")
	public String getProductDetails(ModelMap model) {
		
		
		model.put("products", productService.findAll());
		
		return "homePage";
	}

    @GetMapping("/{id}")
    public ResponseEntity<Product> getP(@PathVariable("id") Long id)
    {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK); 
    }

    @PostMapping("/getPWithID")
    public ResponseEntity<Product> getProductWithID(@RequestBody Product product)
    {
        Product attempt = productService.findProductById(product.getId());
        return new ResponseEntity<>(attempt, HttpStatus.OK); 
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)
    {
    	System.out.println(product);
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteP(@PathVariable("id") Long id)
    {
        productService.findProductById(id);
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
