package com.app.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.daos.UserDAO;
import com.app.dtos.UserDTO;
import com.app.entities.end_users.Citizen;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO user;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDTO getUserById(Long user_id) {
		Citizen us =  user.findById(user_id).orElseThrow();
				return mapper.map(us,UserDTO.class);
	}

	@Override
	public List<UserDTO> findAllUser() {
		return user.findAll()
				.stream()
				.map(user -> mapper.map(user,UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public String addNewUser(UserDTO us) {
		Citizen newUser = mapper.map(us, Citizen.class);
		user.save(newUser);
		return "User Created";
		}
	
}
