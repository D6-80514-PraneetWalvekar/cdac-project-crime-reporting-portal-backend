package com.app.services;

import java.util.List;

import com.app.dtos.UserDTO;

public interface UserService {

	UserDTO getUserById(Long user_id);

	List<UserDTO> findAllUser();

	String addNewUser(UserDTO user);
	
}
