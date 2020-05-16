package com.cognizant.myProject.client;


import java.util.Optional;
import org.springframework.stereotype.Component;

import com.cognizant.myProject.model.Address;
@Component
public class AddressFallBack implements FeignClient {


	@Override
	public Optional<Address> getAddressById(int id) {
		Optional<Address> address=Optional.of(new Address(00, "down", "down", "down", 00, "down"));
		
		
		return address;
	}

}
