package com.app.services;

import java.util.List;

import com.app.dtos.CitizenGetDTO;
import com.app.dtos.CitizenPostDTO;

public interface CitizenService {

	CitizenGetDTO getUserById(Long user_id);

	List<CitizenGetDTO> findAllUser();

	String addNewUser(CitizenPostDTO user);
	
}
