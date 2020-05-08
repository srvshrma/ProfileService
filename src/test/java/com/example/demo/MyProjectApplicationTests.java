package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.User;
import com.cognizant.myProject.repository.UserRepository;
import com.cognizant.myProject.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyProjectApplicationTests {
	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository repo;
	@Test
	public void createUserTest() throws ProfileNotFoundException {
		User user = new User();
	when(repo.save(user)).thenReturn(user);
	assertEquals(user,userService.createUser(user));
	}

}
