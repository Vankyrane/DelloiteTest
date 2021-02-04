package com.deloitte.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.deloitte.Utils.StatusCodes;
import com.deloitte.deloitte.Utils.WSResponse;
import com.deloitte.deloitte.models.User;
import com.deloitte.deloitte.services.UserService;



@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@CrossOrigin
	@PostMapping("/registerUser")
	public WSResponse registerUser(@RequestBody User user) {

		WSResponse wsResponse = new WSResponse();

		try {
			wsResponse.setResultSet(userService.registerUser(user));
			 wsResponse.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL); 

		
		} catch (Exception e) {
			e.printStackTrace();
			wsResponse.setOperationStatus(StatusCodes.UNKNOWNERROR);
			

		}

		return wsResponse;
	}
	
	
}
