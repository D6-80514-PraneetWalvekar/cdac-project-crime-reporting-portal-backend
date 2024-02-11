package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.ComplaintDAO;
import com.app.daos.CitizenDAO;
import com.app.dtos.ComplaintDTO;
import com.app.entities.Complaint;
import com.app.entities.end_users.Citizen;
import com.app.exceptions.NoSuchEntityExistsException;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private CitizenDAO citizenDao;
	@Autowired
	private ComplaintDAO compDao;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<ComplaintDTO> getCompById(Long citizen_id) {
		List<Complaint> comp = citizenDao.findById(citizen_id).orElseThrow().getComplaints();
		return comp.stream().map(compl -> mapper.map(compl, ComplaintDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ComplaintDTO addNewComplaint(Long citizenid, ComplaintDTO newComp) {
		Citizen currentUser = citizenDao.findById(citizenid)
									.orElseThrow(() -> new NoSuchEntityExistsException("User Not Found !! "));
		Complaint newComplaint = mapper.map(newComp, Complaint.class);
		currentUser.addUserInComplaint(newComplaint);
		return mapper.map(newComplaint, ComplaintDTO.class);

	}

	@Override
	public String deleteComplaint(Long complaint_id) {
		Complaint currentComp = compDao.findById(complaint_id)
									.orElseThrow(() -> new NoSuchEntityExistsException("Complaint does not exist !!"));
		Citizen currenCitizen = currentComp.getCitizen();
		int index = currenCitizen.getComplaints().indexOf(currentComp);
		currenCitizen.getComplaints().remove(index);
		compDao.deleteById(complaint_id);
		return "Complaint Deleted";
	}

//	@Override
//	public List<ComplaintDTO> getListOfComplaintByStatus(String status) {
//			
//		return 
//	}

}