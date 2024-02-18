package com.app.controllers;

import java.time.LocalDateTime;

import com.app.utilities.ApiResponseArray;
import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ComplaintDTO;
import com.app.dtos.CitizenGetDTO;
import com.app.services.CitizenService;
import com.app.services.ComplaintService;


@RestController
@RequestMapping("/citizen")
@PreAuthorize("hasRole('CITIZEN')")
public class CitizenController {
	
	@Autowired
	private CitizenService userService;
	@Autowired
	private ComplaintService complaintService;
	
	@GetMapping()
	public ResponseEntity<?> getUser(@AuthenticationPrincipal String principal){
		ApiResponseData<CitizenGetDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,userService.getUserByEmail(principal), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}
//	@GetMapping
//	public ResponseEntity<?> getAllUsers(){
//		ApiResponseArray<CitizenGetDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,userService.findAllUser(),LocalDateTime.now());
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(apiResponseData);
//	}
//	@PostMapping
//	public ResponseEntity<?> createNewUser(@AuthenticationPrincipal String principal, @RequestBody CitizenPostDTO user){
//		ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,userService.addNewUser(user),LocalDateTime.now());
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(apiResponseData);
//	}
	@GetMapping("/all-complaints")
	public ResponseEntity<?>getAllComplaints(@AuthenticationPrincipal String principal){
		ApiResponseArray<ComplaintDTO> apiResponseData = new ApiResponseArray<>(ApiResponseStatus.SUCCESS,complaintService.getCompById(principal),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}
	@PostMapping("/add-complaint")
	public ResponseEntity<?> addNewComplaint(@AuthenticationPrincipal String principal , @RequestBody ComplaintDTO newComp){
		ApiResponseData<ComplaintDTO> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,complaintService.addNewComplaint(principal,newComp),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(apiResponseData);
		
	}
	@DeleteMapping("/delete-complaint/{complaint_id}")
	public ResponseEntity<?> deleteComplaint(@AuthenticationPrincipal String principal, @PathVariable Long complaint_id ){
		ApiResponseData<String> apiResponseData = new ApiResponseData<>(ApiResponseStatus.SUCCESS,complaintService.deleteComplaint(principal, complaint_id),LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.OK)
				.body(apiResponseData);
	}

}
