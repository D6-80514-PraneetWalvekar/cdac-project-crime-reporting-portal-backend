package com.app.services;

import com.app.dtos.ComplaintDTO;

import java.util.List;

import com.app.dtos.CitizenGetDTO;

import com.app.dtos.FirDTO;
import com.app.entities.enums.StatusEnum;


public interface ComplaintService {

	List<ComplaintDTO> getCompById(Long citizen_id);

	ComplaintDTO addNewComplaint(Long user_id, ComplaintDTO newComp);

	String deleteComplaint(Long complaint_id);

	List<FirDTO> getListOfComplaintByStatus(Long citizen_id, StatusEnum status);


}
