package com.mariana.workshopmongo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mariana.workshopmongo.models.DTO.PostDTO;
import com.mariana.workshopmongo.models.DTO.UserDTO;
import com.mariana.workshopmongo.service.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>findAll(){
		List<UserDTO>list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO>findById(@PathVariable String id){
		UserDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
      
	@PostMapping
	public ResponseEntity<UserDTO>insert(@RequestBody UserDTO obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
     
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO>update(@PathVariable String id, @RequestBody UserDTO obj){
    	obj = service.update(id, obj);
    	return ResponseEntity.ok().body(obj);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO>delete(@PathVariable String id){
    	service.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostDTO>> getUserPosts(@PathVariable String id) {
            List<PostDTO> list = service.getUserPosts(id);
            return ResponseEntity.ok().body(list);
        
    }
 
    }
    
    


    	
   

