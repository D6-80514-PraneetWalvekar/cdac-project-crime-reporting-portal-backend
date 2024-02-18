package com.app.controllers;

import java.time.LocalDateTime;
import java.util.List;

import com.app.entities.enums.StatusEnum;

import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/citizen")
@PreAuthorize("hasRole('CITIZEN')")
public class CitizenController {
	
	@Autowired
	private CitizenService userService;
	@Autowired
	private ComplaintService complaintService;
	
	@GetMapping("/{citizenid}")
	public ResponseEntity<?> getUser(@PathVariable Long citizenid){
		ApiResponseData<CitizenGetDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,userService.getUserById(citizenid), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}
	@GetMapping
	public ResponseEntity<?> getAllUsers(){
		ApiResponseArray<CitizenGetDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,userService.findAllUser(),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}
	@PostMapping
	public ResponseEntity<?> createNewUser(@RequestBody CitizenPostDTO user){
		ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,userService.addNewUser(user),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(apiResponseData);
	}
	@GetMapping("/complaint/{citizenid}")
	public ResponseEntity<?>getComplaintById(@PathVariable Long citizenid){
		ApiResponseArray<ComplaintDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,complaintService.getCompById(citizenid),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}
	@PostMapping("/complaint/{citizenid}")
	public ResponseEntity<?> addNewComplaint(@PathVariable Long citizenid , @RequestBody ComplaintDTO newComp){
		ApiResponseData<ComplaintDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,complaintService.addNewComplaint(citizenid,newComp),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(complaintService.addNewComplaint(citizenid,newComp));
		
	}
	@DeleteMapping("/complaint/{complaint_id}")
	public ResponseEntity<?> deleteComplaint(@PathVariable Long complaint_id ){
		ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,complaintService.deleteComplaint(complaint_id),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}

}
