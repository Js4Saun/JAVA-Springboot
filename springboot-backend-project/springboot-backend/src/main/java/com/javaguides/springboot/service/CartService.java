package com.javaguides.springboot.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaguides.springboot.exception.EntityNotFoundException;
import com.javaguides.springboot.model.CartItems;
import com.javaguides.springboot.repository.CartItemRepository;

@Service
public class CartService {
	private final CartItemRepository cartItemRepository;
	
	@Autowired
	public CartService(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository; 
	}
	
	public CartItems addCartItem(CartItems cartItems) 
	{
		return cartItemRepository.save(cartItems);
	}
	
	public List<CartItems> findAll(){ return cartItemRepository.findAll(); }
	
	@Transactional
	public void deleteCartItem(Long id) { cartItemRepository.deleteCartItemById(id);}
	
	public CartItems findCartById(Long id) {
	
		return cartItemRepository.findCartById(id) 
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
	}	

}
