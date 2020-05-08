package com.cognizant.myProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.myProject.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findByFirstName(String name);
}
