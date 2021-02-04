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

@Service
public class TodoService {
	
	@Autowired 
	private ToDoItemsDAO toDoItemsDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserService userService;

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

	public Object GetUserAllItems(String sessionToken) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		ArrayList<ToDoItems>items=toDoItemsDAO.findAllByUserId(logedInUser.getId());
		
		return items;
	}

	public Object editUserItem(String sessionToken, ToDoItems toDoItems) throws UserNotLoggedIn {
		User logedInUser = userService.getUserFromSessionToken(sessionToken);
		if(logedInUser.getId().equals(toDoItems.getUserId())) {
			
			toDoItems = toDoItemsDAO.save(toDoItems);
			return toDoItems;
		}else {
			throw new UserNotLoggedIn();
		}
	}

}
