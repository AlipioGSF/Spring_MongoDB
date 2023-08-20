package com.alipiogomes.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alipiogomes.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
