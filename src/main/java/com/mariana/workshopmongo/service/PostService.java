package com.mariana.workshopmongo.service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public List<PostDTO> findByTitle(String text){
		List<Post>list = repository.findByTitleContainingIgnoreCase(text);
	    return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	
	private Post getEntityById(String id) {
		Optional<Post>result = repository.findById(id);
		return result.orElseThrow(()-> new ResourceNotFoundException("Object not found"));
		
	}
	
	public List<PostDTO> fullSearch(String text, String start, String end){
		Instant startMoment= convertMoment(start, Instant.ofEpochMilli(0L));
		Instant endMoment= convertMoment(end, Instant.now());
		List<Post>list = repository.fullSearch(text, startMoment, endMoment);
	    return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	private Instant convertMoment(String originalString, Instant allternative) {
		try {
			return Instant.parse(originalString);
		}
		catch(DateTimeParseException e) {
			return allternative;
		}
	}
	
	
}
