package com.deloitte.deloitte.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.deloitte.Utils.UserNotLoggedIn;
import com.deloitte.deloitte.dao.ToDoItemsDAO;
import com.deloitte.deloitte.dao.UserDAO;
import com.deloitte.deloitte.models.ToDoItems;
import com.deloitte.deloitte.models.User;

//Service class to implement business logic specific to action performed in GUI

@Service
public class TodoService {
	
	@Autowired 
	private ToDoItemsDAO toDoItemsDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserService userService;

//Create Item method to create new TODOLIST by specific user based on the session token.
	public Object createItem(ToDoItems toDoItems, String sessionToken) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		if(logedInUser.getId().equals(toDoItems.getUserId())) {
			toDoItems.setId(UUID.randomUUID().toString());
			toDoItems = toDoItemsDAO.save(toDoItems);
			return toDoItems;
		}else {
			throw new UserNotLoggedIn();
		}
		
	}
//Get User Items method to fetch all the TODO task created by a specific user based on session token
	public Object GetUserAllItems(String sessionToken) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		ArrayList<ToDoItems>items=toDoItemsDAO.findAllByUserId(logedInUser.getId());
		
		return items;
	}

//Edit User Items method to edit the TODOLIST  created by a specific user based on session token
	public Object editUserItem(String sessionToken, ToDoItems toDoItems) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		if(logedInUser.getId().equals(toDoItems.getUserId())) {
			
			toDoItems = toDoItemsDAO.save(toDoItems);
			return toDoItems;
		}else {
			throw new UserNotLoggedIn();
		}
	}

//Delete User Items method to delete the TODOLIST created by a specific user based on session token
	public Object deleteItem(String sessionToken, ToDoItems toDoItems) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		if(logedInUser.getId().equals(toDoItems.getUserId())) {
			
			toDoItemsDAO.deleteById(toDoItems.getId());
			return null;
		}else {
			throw new UserNotLoggedIn();
		}
	}

}
