package com.app.services;

import com.app.daos.BaseEntityUsersDao;
import com.app.daos.CitizenDAO;
import com.app.entities.end_users.BaseEntityUsers;
import com.app.entities.end_users.Citizen;
import com.app.entities.enums.RoleEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.Signup;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private CitizenDAO userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		Citizen user=mapper.map(reqDTO, Citizen.class);
		user.getBaseEntityUser().setRole(RoleEnum.ROLE_CITIZEN);
		user.getBaseEntityUser().setPassword(encoder.encode(user.getBaseEntityUser().getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), Signup.class);
	}

}
