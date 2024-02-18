package com.app.services;

import com.app.daos.BaseEntityUsersDao;
import com.app.entities.end_users.BaseEntityUsers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.app.dao.UserEntityDao;
import com.app.dtos.Signup;
import com.app.entities.BaseEntity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//dep : dao layer i/f
	@Autowired
	private BaseEntityUsersDao userDao;
	//dep
	@Autowired
	private ModelMapper mapper;
	//dep 
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Signup userRegistration(Signup reqDTO) {
		//dto --> entity
		BaseEntityUsers user=mapper.map(reqDTO, BaseEntityUsers.class);
		user.setPassword(encoder.encode(user.getPassword()));//pwd : encrypted using SHA
		return mapper.map(userDao.save(user), Signup.class);
	}

}
