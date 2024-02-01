package com.in28min.demo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;





@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	//GET /users
	//retrieve all users
	@GetMapping("/users")
	public List<User> retrieveAllusers(){
		return service.findAll();
	}
	
	//GET  /users/{id}
	//retrieveUser(int id)
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user=service.findOne(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+ id);
		EntityModel<User> model=EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers=linkTo(methodOn(this.getClass()).retrieveAllusers());
		
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=service.deleteById(id);
		if(user==null) 
			throw new UserNotFoundException("id-"+ id);
		
		
	}

	
	//input -details of user
	//output- CREATED and return the created URI
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser=service.save(user);
		//created
		// /user/{id}  savedUser.getId()
	URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	

}
