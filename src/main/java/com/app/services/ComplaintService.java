package com.app.services;

import com.app.dtos.ComplaintDTO;

import java.util.List;

import com.app.dtos.FirDTO;
import com.app.entities.enums.StatusEnum;


public interface ComplaintService {

	List<ComplaintDTO> getCompById(String principal);

	ComplaintDTO addNewComplaint(String principal, ComplaintDTO newComp);

	String deleteComplaint(String principal,Long complaint_id);

	List<FirDTO> getListOfComplaintByStatus(Long citizen_id, StatusEnum status);

	List<FirDTO> getAllFIRs(String principal);


}
