package com.mariana.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mariana.workshopmongo.models.entities.Post;


@Repository
public interface  PostRepository extends MongoRepository<Post, String> {

}
