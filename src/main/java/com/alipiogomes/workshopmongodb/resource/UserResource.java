package com.alipiogomes.workshopmongodb.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipiogomes.workshopmongodb.domain.User;
import com.alipiogomes.workshopmongodb.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable{
	
	@Autowired
	private UserService userService;

	private static final long serialVersionUID = 1L;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	
	

}
