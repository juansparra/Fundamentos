package com.fundamentosplazi.springboot.fundamentos.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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

import com.fundamentosplazi.springboot.fundamentos.caseUse.CreateUser;
import com.fundamentosplazi.springboot.fundamentos.caseUse.DeleteUser;
import com.fundamentosplazi.springboot.fundamentos.caseUse.GetUser;
import com.fundamentosplazi.springboot.fundamentos.caseUse.UpdateUser;
import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	//create, get, delete, update
	private GetUser getUser;
	private CreateUser createUser;
	private DeleteUser deleteUser;
	private UpdateUser updateUser;
	private UserRepository userRepository;
	public UserRestController (GetUser getUser, CreateUser createUser, DeleteUser deleteUser,UpdateUser updateUser,UserRepository userRepository) {
		this.createUser = createUser;
		this.getUser= getUser;
		this.deleteUser = deleteUser;
		this.updateUser = updateUser;
		this.userRepository= userRepository;
	}
	@GetMapping("/")
	List<User> get(){
		return getUser.getAll();
	}
	
	
	@PostMapping("/")
	ResponseEntity<User> newUser(@RequestBody User newUser){
		return new ResponseEntity<>(createUser.save(newUser),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deleteUser(@PathVariable Long id) {
		deleteUser.remove(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
		return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	List<User>getUserPageable(@RequestParam int page,@RequestParam int size){
		return userRepository.findAll(PageRequest.of(page, size)).getContent();
		
	}
}
