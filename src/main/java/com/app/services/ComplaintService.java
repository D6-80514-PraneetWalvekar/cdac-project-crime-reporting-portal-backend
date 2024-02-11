package com.app.services;

import com.app.dtos.ComplaintDTO;

import java.util.List;

import com.app.dtos.CitizenGetDTO;

public interface ComplaintService {

	List<ComplaintDTO> getCompById(Long citizen_id);

	ComplaintDTO addNewComplaint(Long user_id, ComplaintDTO newComp);

	String deleteComplaint(Long complaint_id);

//	List<ComplaintDTO> getListOfComplaintByStatus(String status);

}
