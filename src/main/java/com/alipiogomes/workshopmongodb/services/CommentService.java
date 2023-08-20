package com.alipiogomes.workshopmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipiogomes.workshopmongodb.domain.Comment;
import com.alipiogomes.workshopmongodb.repositories.CommentRepository;
import com.alipiogomes.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment findById(String id) {
		Comment obj = commentRepository.findById(id).get();
		if(obj == null) {
			throw new ObjectNotFoundException(id);
		}
		return obj;
	}
	
}
