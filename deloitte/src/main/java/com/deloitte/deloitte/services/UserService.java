package com.deloitte.deloitte.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.deloitte.Utils.UserDoesNotExists;
import com.deloitte.deloitte.Utils.UserNotLoggedIn;
import com.deloitte.deloitte.dao.UserDAO;
import com.deloitte.deloitte.models.User;


//Service class to implement business logic for User functionalities
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public Object registerUser(User user) {

		user.setId(UUID.randomUUID().toString());
		user = userDAO.save(user);

		return user;
	}

//Login User method to allow user to login through Email Id and Password based on session token created while registering the user.
	public Object loginUser(User user) throws  UserDoesNotExists {
		user = userDAO.getUserFromEmailAndPassword(user.getEmailId(),user.getPassword());
		if(user!=null) {
			user.setSessionToken(UUID.randomUUID().toString());
			user = userDAO.save(user);
		}else {
			throw new UserDoesNotExists();
		}
		return user;
	}

//Get User from Session token method to allow user to login through Email Id and Password based on session token created while registering the user.
	public User getUserFromSessionToken(String sessionToken) throws UserNotLoggedIn {
		 User loggedInUser = userDAO.getUserFromSessionToken(sessionToken);
		 if(loggedInUser!=null) {
			 return loggedInUser;
		 }else {
			 throw new UserNotLoggedIn();
		 }
		
		// TODO Auto-generated method stub
		
	}

}
