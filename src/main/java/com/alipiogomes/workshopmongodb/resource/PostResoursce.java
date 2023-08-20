package com.alipiogomes.workshopmongodb.resource;

import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipiogomes.workshopmongodb.domain.Comment;
import com.alipiogomes.workshopmongodb.domain.Post;
import com.alipiogomes.workshopmongodb.resource.util.URL;
import com.alipiogomes.workshopmongodb.services.PostService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/posts")
public class PostResoursce {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> getPost(@PathVariable String id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	@GetMapping(value = "/{id}/comments")
	public ResponseEntity<List<Comment>> findComments(@PathVariable String id){
		List<Comment> list = postService.findById(id).getComments();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}

}
