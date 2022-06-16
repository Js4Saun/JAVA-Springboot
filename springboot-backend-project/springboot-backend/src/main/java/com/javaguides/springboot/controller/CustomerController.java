package com.javaguides.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javaguides.springboot.model.Product;
import com.javaguides.springboot.model.User;
import com.javaguides.springboot.repository.UserRepository;
import com.javaguides.springboot.service.UserService;
import com.javaguides.springboot.service.ProductService;

@Controller
@SessionAttributes("userName")
public class CustomerController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String loginPage() {
		return "login";
	}
	
	
	@GetMapping("/home")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/regpage")
	public String userRegistrationPage() {

		return "register";
	}
	
	@PostMapping("/register")
	public String userRegister(User user) {

		userService.addUser(user);
		return "login";
	}
	
	@RequestMapping("/regproduct")
	public String ProductAdditionPage() {

		return "registerProduct";
	}
	
	@PostMapping("/addProduct")
	public String ProductRegister(Product product) {

		productService.addProduct(product);
		return "homePage";
	}
	
	@PostMapping("/login")
	public String customerLogin(@RequestParam String userEmail, String password, ModelMap model) {
		String userName = userService.validateRegisteredUser(userEmail, password);
		System.out.println("Controller says "+userEmail+" password "+password);
		if(userName==null) {
			model.put("errorMessage", "Not a valid user");
			return "login";
		}
		model.put("userName", userName);
		
	
		return "homePage";
	}
	
	@GetMapping("/logout")
	public String userLogOut(ModelMap model, HttpSession session) {
		session.invalidate();
		model.put("loggedout", "Logged out successfully!");
		return "login";
	}
	
}


