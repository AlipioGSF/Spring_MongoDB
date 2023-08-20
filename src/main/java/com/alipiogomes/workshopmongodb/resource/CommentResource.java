package com.alipiogomes.workshopmongodb.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipiogomes.workshopmongodb.domain.Comment;
import com.alipiogomes.workshopmongodb.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

	@Autowired
	private CommentService commentService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Comment> findById(@PathVariable String id){
		Comment obj = commentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
