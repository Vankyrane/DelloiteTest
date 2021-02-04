package com.deloitte.deloitte.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.deloitte.dao.UserDAO;
import com.deloitte.deloitte.models.User;



@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public Object registerUser(User user) {

		user.setId(UUID.randomUUID().toString());
		user = userDAO.save(user);

		return user;
	}

}
