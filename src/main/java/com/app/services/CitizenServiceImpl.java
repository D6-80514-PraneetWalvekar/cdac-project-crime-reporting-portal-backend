package com.app.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.CitizenDAO;
import com.app.dtos.CitizenGetDTO;
import com.app.dtos.CitizenPostDTO;
import com.app.entities.end_users.Citizen;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService {
	
	@Autowired
	private CitizenDAO citizenDao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CitizenGetDTO getUserById(Long user_id) {
		Citizen us =  citizenDao.findById(user_id).orElseThrow();
				return mapper.map(us,CitizenGetDTO.class);
	}

	@Override
	public List<CitizenGetDTO> findAllUser() {
		return citizenDao.findAll()
				.stream()
				.map(user -> mapper.map(user,CitizenGetDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String addNewUser(CitizenPostDTO us) {
		Citizen newUser = mapper.map(us, Citizen.class);
		citizenDao.save(newUser);
		return "User Created";
		}
	
}
