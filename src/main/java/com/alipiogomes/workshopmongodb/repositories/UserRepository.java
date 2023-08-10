package com.alipiogomes.workshopmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alipiogomes.workshopmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
}
