package com.cognizant.myProject.service;



import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.myProject.client.FeignClient;

import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.Address;
import com.cognizant.myProject.model.User;

import com.cognizant.myProject.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userR;
	
	@Autowired
	FeignClient fiegn;
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Override
	public User createUser(User user) throws ProfileNotFoundException{
		
		return userR.save(user);
	}

	
	@Override
	public Optional<User> findById(int id) throws ProfileNotFoundException{
		// TODO Auto-generated method stub
		
		return userR.findById(id);
	}


	@Override
	public Iterable<User> getAllUsers() throws ProfileNotFoundException{
		// TODO Auto-generated method stub
		return userR.findAll();
	}


	@Override
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		return userR.findByFirstName(name);
	}


	@Override
	public void updateProfileById(User user) {
		// TODO Auto-generated method stub
		userR.save(user);
	}


	@Override
	public void deleteProfileById(int id) {
		// TODO Auto-generated method stub
		userR.deleteById(id);
	}


	@Override
	public CompletableFuture<Optional<Address>> findAddress(int id) {
		log.info("get id of address by "+Thread.currentThread().getName());
		Optional<Address> adds= fiegn.getAddressById(id);
		return CompletableFuture.completedFuture(adds);
	}


}
