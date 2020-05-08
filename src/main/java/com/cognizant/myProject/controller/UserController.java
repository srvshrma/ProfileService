package com.cognizant.myProject.controller;

import java.util.List;
import java.util.Optional;

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
	
	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) throws ProfileNotFoundException
	{
		/*Login login = new Login(user.getUserId(), user.getEmail(), user.getPassword());
		userService.createLogin(login);*/
		logger.error("Error...............................");
		return userService.createUser(user);
	}
	
	@GetMapping("/user/id/{id}")
	public Optional<User> getUserById(@PathVariable(value="id") int id) throws ProfileNotFoundException {
		return userService.findById(id);
	}
	@GetMapping("/users")
	public Iterable<User> getAll() throws ProfileNotFoundException{
		
		return userService.getAllUsers();
	}
	@GetMapping("/user/name/{name}")
	public List<User> getByName(@PathVariable String name){
		
		return userService.getByName(name);
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
	
	@PostMapping("/address/create")
	public Address createAddress(@RequestBody Address address) {
		return feign.createAddress(address);
	}
	
	@RequestMapping("/address/id/{id}")
	public Optional<Address> getAddressById(@PathVariable(value="id")int id){
		
		return feign.getAddressById(id);
	}
	
}
