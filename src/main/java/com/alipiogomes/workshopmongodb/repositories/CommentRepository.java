package com.alipiogomes.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alipiogomes.workshopmongodb.domain.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{
	
}
