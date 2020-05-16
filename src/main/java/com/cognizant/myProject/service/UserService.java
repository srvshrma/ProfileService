package com.cognizant.myProject.service;


import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.Address;
import com.cognizant.myProject.model.User;

public interface UserService {
	
	User createUser(User user) throws ProfileNotFoundException;
	
	Iterable<User> getAllUsers() throws ProfileNotFoundException ;
	Optional<User> findById(int id) throws ProfileNotFoundException;
	public List<User> getByName(String name);
	public void updateProfileById(User user);
	public void deleteProfileById(int id);
	public CompletableFuture<Optional<Address>> findAddress(int id);
	
}
