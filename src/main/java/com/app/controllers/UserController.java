package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserDTO;
import com.app.services.ComplaintService;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ComplaintService complaintService;
	
	@GetMapping("/{user_id}")
	public ResponseEntity<?> getUser(@PathVariable Long user_id){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(user_id));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());
	}
	
	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody UserDTO user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(user));
	}
	
	@GetMapping("/complaint/{comp_id}")
	public ResponseEntity<?>getComplaintById(@PathVariable Long comp_id){
		return ResponseEntity.status(HttpStatus.OK).body(complaintService.getCompById(comp_id));
		
	}
	
	@PostMapping("/complaint/{user_id}")
	public ResponseEntity<?> addNewComplaint(){
		return null;
		
	}
	
}
