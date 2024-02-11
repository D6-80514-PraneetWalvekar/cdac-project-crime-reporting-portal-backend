package com.app.controllers;

import java.util.List;

import com.app.entities.enums.StatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ComplaintDTO;
import com.app.dtos.CitizenGetDTO;
import com.app.dtos.CitizenPostDTO;
import com.app.services.CitizenService;
import com.app.services.ComplaintService;

import ch.qos.logback.core.status.Status;


@RestController
@RequestMapping("/user")
@Validated
public class CitizenController {
	
	@Autowired
	private CitizenService userService;
	@Autowired
	private ComplaintService complaintService;
	
	@GetMapping("/{citizenid}")
	public ResponseEntity<?> getUser(@PathVariable Long citizenid){
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.getUserById(citizenid));
	}
	@GetMapping
	public ResponseEntity<List<CitizenGetDTO>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.findAllUser());
	}
	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody CitizenPostDTO user){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.addNewUser(user));
	}
	@GetMapping("/complaint/{citizenid}")
	public ResponseEntity<?>getComplaintById(@PathVariable Long citizenid){
		return ResponseEntity.status(HttpStatus.OK)
				.body(complaintService.getCompById(citizenid));
	}
	@PostMapping("/complaint/{citizenid}")
	public ResponseEntity<?> addNewComplaint(@PathVariable Long citizenid , @RequestBody ComplaintDTO newComp){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(complaintService.addNewComplaint(citizenid,newComp));
		
	}
	@DeleteMapping("/complaint/{complaint_id}")
	public ResponseEntity<?> deleteComplaint(@PathVariable Long complaint_id ){
		return ResponseEntity.status(HttpStatus.OK)
				.body(complaintService.deleteComplaint(complaint_id));
	}
	

	
}
