package com.alipiogomes.workshopmongodb.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipiogomes.workshopmongodb.domain.User;


@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User alipio = new User("1", "Alipio Gomes", "alipio@gmail.com");
		User tay = new User("1", "tay nara", "tay@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(alipio, tay));
		return ResponseEntity.ok().body(list);
	}
	
	
	

}
