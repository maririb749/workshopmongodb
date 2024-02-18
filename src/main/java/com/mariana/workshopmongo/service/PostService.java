package com.mariana.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariana.workshopmongo.models.DTO.PostDTO;
import com.mariana.workshopmongo.models.entities.Post;
import com.mariana.workshopmongo.repositories.PostRepository;
import com.mariana.workshopmongo.service.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public PostDTO findById(String id){
		Post entity = getEntityById(id);
	 return new PostDTO(entity);
	}
	
	
	private Post getEntityById(String id) {
		Optional<Post>result = repository.findById(id);
		return result.orElseThrow(()-> new ResourceNotFoundException("Object not found"));
		
	}

	
}
