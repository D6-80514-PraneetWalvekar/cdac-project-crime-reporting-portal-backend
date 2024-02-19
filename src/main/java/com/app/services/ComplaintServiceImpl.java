package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import com.app.custom_exceptions.ResourseNotFound;
import com.app.daos.FIRDao;
import com.app.daos.PoliceStationDao;
import com.app.dtos.FirDTO;
import com.app.entities.FirstInformationReport;
import com.app.entities.PoliceStation;
import com.app.entities.enums.StatusEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.ComplaintDAO;
import com.app.daos.CitizenDAO;
import com.app.dtos.ComplaintDTO;
import com.app.entities.Complaint;
import com.app.entities.end_users.Citizen;
import com.app.exception.NoSuchEntityExistsException;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private CitizenDAO citizenDao;
	@Autowired
	private ComplaintDAO compDao;

	@Autowired
	private FIRDao firDao;

	@Autowired
	private PoliceStationDao policeStationDao;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<ComplaintDTO> getCompById(String principal) {
		List<Complaint> comp = citizenDao.findByBaseEntityUserEmail(principal).orElseThrow().getComplaints();
		return comp.stream().map(compl -> {
			ComplaintDTO dto = mapper.map(compl, ComplaintDTO.class);
			dto.setPoliceStationAddress(compl.getPoliceStation().getAddress());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public ComplaintDTO addNewComplaint(String principal, ComplaintDTO complaintDTO) {
		Citizen currentUser = citizenDao.findByBaseEntityUserEmail(principal)
									.orElseThrow(() -> new NoSuchEntityExistsException("User Not Found !! "));
		Complaint newComplaint = mapper.map(complaintDTO, Complaint.class);

		PoliceStation ps = policeStationDao.findPoliceStationByAddress(complaintDTO.getPoliceStationAddress()).
				orElseThrow(() -> new NoSuchEntityExistsException("PS Not Found !! "));

		newComplaint.setPoliceStation(ps);

		newComplaint.setCitizen(currentUser);
		currentUser.getComplaints().add(newComplaint);

		compDao.save(newComplaint);

		return complaintDTO;

	}

	@Override
	public String deleteComplaint(String principal, Long complaint_id) {
		citizenDao.findByBaseEntityUserEmail(principal)
				.orElseThrow(() -> new NoSuchEntityExistsException("User Not Found !! "));

		Complaint currentComp = compDao.findById(complaint_id)
									.orElseThrow(() -> new NoSuchEntityExistsException("Complaint does not exist !!"));
		Citizen currenCitizen = currentComp.getCitizen();

		currenCitizen.getComplaints().remove(currentComp);
		compDao.deleteById(complaint_id);

		return "Complaint Deleted";
	}

	//find FIRs of citizen by status enum
	@Override
	public List<FirDTO> getListOfComplaintByStatus(Long citizen_id, StatusEnum status) {
		List<FirstInformationReport> complaintList = citizenDao.findById(citizen_id).orElseThrow().
				getComplaints().stream().filter((Complaint::isFIR)).
				map((complaint -> firDao.findById(complaint.getID()).orElseThrow())).
				filter((fir)->fir.getStatusEnum().equals(status)).
				collect(Collectors.toList());

		return complaintList.stream().map((fir)->
				{
			FirDTO firDTO = mapper.map(fir, FirDTO.class);
			firDTO.setStatus(status.name());
			return firDTO;
				}
		).collect(Collectors.toList());
	}

	@Override
	public List<FirDTO> getAllFIRs(String principal) {

		Citizen citizen = citizenDao.findByBaseEntityUserEmail(principal).orElseThrow(()->new ResourseNotFound("Invalid citizen!"));
		List<FirstInformationReport> FIRs = firDao.findByComplaint_Citizen(citizen);

		return FIRs.stream().map((fir)->mapper.map(fir, FirDTO.class)
		).collect(Collectors.toList());
	}

}