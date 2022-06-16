package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.javaguides.springboot.model.CartItems;
import com.javaguides.springboot.model.Product;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@RequestMapping("/shoppingCart")
	public String getCartDetails(ModelMap model) {
		
		
		model.put("shoppingCart", cartService.findAll());
		
		return "shopping cart";
	}

	private final CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/findAllOrders")
	public List<Product> findAllOrders(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<CartItems> getCart(@PathVariable("id") Long id)
    {
        CartItems cartItems = cartService.findCartById(id);
        return new ResponseEntity<>(cartItems, HttpStatus.OK); 
    }
	
	@PostMapping("/getCWithID")
    public ResponseEntity<CartItems> getCartWithID(@RequestBody CartItems cartItems)
    {
		CartItems attempt = cartService.findCartById(cartItems.getId());
        return new ResponseEntity<>(attempt, HttpStatus.OK); 
    }
	
	@PostMapping("/addCartItem")
    public ResponseEntity<CartItems> addCartItem(@RequestBody CartItems cartItems)
    {
    	System.out.println(cartItems);
        CartItems newCartItem = cartService.addCartItem(cartItems);
        return new ResponseEntity<>(newCartItem, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteC(@PathVariable("id") Long id)
    {
        cartService.findCartById(id);
        cartService.deleteCartItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
