package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaguides.springboot.model.User;
import com.javaguides.springboot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	 @GetMapping
	 public ResponseEntity<List<User>> getAllUsers()
	 {
	     List<User> getUsers = userService.findAllUsers();
	     return new ResponseEntity<>(getUsers, HttpStatus.OK); 
	 }
	 
	 @GetMapping("/displayUsers")
	 public String GetAllUsers2(ModelMap map)
	 {
		 map.put("getUsers", userService.findAllUsers());
		 System.out.print(userService.findAllUsers());
		 return "homePage";
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<User> getU(@PathVariable("id") Long id)
	 {
	     User user = userService.findUserById(id);
	     return new ResponseEntity<>(user, HttpStatus.OK); 
	 }
	 
	 @GetMapping("/{username}")
	 public ResponseEntity<User> getUname(@PathVariable("username") String userName)
	 {
	     User user = userService.findUserByuserName(userName);
	     return new ResponseEntity<>(user, HttpStatus.OK); 
	 }
	 
	 @PostMapping("/getUWithID")
	    public ResponseEntity<User> getUserWithID(@RequestBody User user)
	    {
	        User attempt = userService.findUserById(user.getId());
	        return new ResponseEntity<>(attempt, HttpStatus.OK); 
	    }

	    @PostMapping("/addUser")
	    public ResponseEntity<User> addUser(@RequestBody User user)
	    {
	        User newUser = userService.addUser(user);
	        return new ResponseEntity<>(newUser, HttpStatus.CREATED); 
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteU(@PathVariable("id") Long id)
	    {
	        userService.findUserById(id);
	        userService.deleteUser(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
