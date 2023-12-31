package com.alipiogomes.workshopmongodb.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipiogomes.workshopmongodb.domain.Post;
import com.alipiogomes.workshopmongodb.repositories.PostRepository;
import com.alipiogomes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService implements Serializable{

	@Autowired
	private PostRepository postRepository;
	
	private static final long serialVersionUID = 1L;
	
	public Post findById(String id) {
		Post post = postRepository.findById(id).get();
		if(post == null ) {
			throw new ObjectNotFoundException(id);
		}
		return post;
	}
	
	public List<Post> findByTitle(String txt){
		List<Post> posts = postRepository.searchTitle(txt);
		if(posts == null) {
			throw new ObjectNotFoundException(txt);
		}
		return posts;
		
	}
	
}
