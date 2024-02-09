package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.ComplaintDAO;
import com.app.dtos.ComplaintDTO;
import com.app.entities.Complaint;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	private ComplaintDAO compDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ComplaintDTO getCompById(Long comp_id) {
		Complaint comp = compDao.findById(comp_id).orElseThrow();
		return mapper.map(comp,ComplaintDTO.class);
	}

}
