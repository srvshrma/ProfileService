package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.myProject.exception.ProfileNotFoundException;
import com.cognizant.myProject.model.User;
import com.cognizant.myProject.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@MockBean
	private UserService service;
	@Autowired
	private MockMvc mockMvc;
	@Test
	void testGetUserById() throws Exception, ProfileNotFoundException {
		Optional<User> user = Optional.of(new User(1, "Saurav", "Sharma", 21, "male", "srv@srv"));
		when(service.findById(Mockito.anyInt())).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/id/1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
		String expected = "{\"id\":1,\"firstName\":\"Saurav\",\"lastName\":\"Sharma\",\"age\":21,\"gender\":\"male\",\"email\":\"srv@srv\"}";
		System.out.println("IM THE TESTER: " +result.getResponse().getContentAsString());
		assertEquals(200, status);
		//JSONAssert.assertEquals(expected, actual, strict);
		assertEquals(expected, result.getResponse().getContentAsString());
}
}
