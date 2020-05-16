package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.myProject.controller.UserController;
import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.User;
import com.cognizant.myProject.repository.UserRepository;
import com.cognizant.myProject.service.UserService;

@SpringBootTest
public class MyProjectApplicationTests {
	@Autowired
	private UserController controller;
	@Test
	void contextLoads() {
	assertThat(controller).isNotNull();
	}
	

}
