package com.cognizant.myProject.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.myProject.client.FeignClient;
import com.cognizant.myProject.dto.UserAddress;
import com.cognizant.myProject.exception.ExceptionMessage;
import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.Address;
import com.cognizant.myProject.model.User;
import com.cognizant.myProject.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	FeignClient feign;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value="/user/create",produces = "application/json")
	public User createUser(@RequestBody User user) throws ProfileNotFoundException, InterruptedException, ExecutionException
	{
		
		logger.error("Error...............................");
		return userService.createUser(user);
	}
	
	@GetMapping("/user/id/{id}")
	public Optional<UserAddress> getUserById(@PathVariable(value="id") int id) throws ProfileNotFoundException, InterruptedException, ExecutionException {
		logger.info("Finding user by id");
		UserAddress user= new UserAddress();
		User us = userService.findById(id).get();
		user.setAddress(getAddressById(id));
		user.setId(us.getId());
		user.setFirstName(us.getFirstName());
		user.setLastName(us.getLastName());
		user.setEmail(us.getEmail());
		user.setAge(us.getAge());
		user.setGender(us.getGender());
		//if(!user.isPresent()) throw new ProfileNotFoundException(ExceptionMessage.EMPTY.getMessage()+id);
		//logger.error("Cannot find...............");
		return Optional.of(user);
	}
	@GetMapping("/users")
	public Iterable<User> getAll() throws ProfileNotFoundException{
		
		return userService.getAllUsers();
	}
	@GetMapping("/user/name/{name}")
	public List<User> getByName(@PathVariable String name) throws ProfileNotFoundException{
		List<User> movie = userService.getByName(name);
		if(!movie.isEmpty()) throw new ProfileNotFoundException(ExceptionMessage.User_FirstName_Not_Found.getMessage() +name);
		return movie;
	}
	@PutMapping("/updateuser/{id}")
	public void updateById(@RequestBody User user,@PathVariable int id) {
		User update = new User(id, user.getFirstName(),user.getLastName(), user.getAge(),user.getGender(), user.getEmail());
		userService.updateProfileById(update);
	}
	@DeleteMapping("/deleteuser/{id}")
	public void deleteById(@PathVariable int id) {
		userService.deleteProfileById(id);
	}
	
	@RequestMapping("/address/id/{id}")
	public Optional<Address> getAddressById(@PathVariable(value="id")int id){
		
		return feign.getAddressById(id);
	}
	
	
	
}
