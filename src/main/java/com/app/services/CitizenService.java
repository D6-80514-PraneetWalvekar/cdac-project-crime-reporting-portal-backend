package com.app.services;

import java.util.List;

import com.app.dtos.CitizenGetDTO;
import com.app.dtos.CitizenPostDTO;

public interface CitizenService {

	CitizenGetDTO getUserById(Long user_id);
	CitizenGetDTO getUserByEmail(String email);

	List<CitizenGetDTO> findAllUser();

	String addNewUser(CitizenPostDTO user);
	
}
