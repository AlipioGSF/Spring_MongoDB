package com.alipiogomes.workshopmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.alipiogomes.workshopmongodb.domain.User;
import com.alipiogomes.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User alipio = new User(null, "Alipio", "alipio@gmail.com");
		User leo = new User(null, "Leo", "leo@gmail.com");
		User gabs = new User(null, "Gabs", "gabs@gmail.com");
		
		userRepository.saveAll(Arrays.asList(alipio, leo, gabs));
	}
	
}
