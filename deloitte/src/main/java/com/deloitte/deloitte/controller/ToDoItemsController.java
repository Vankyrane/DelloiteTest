package com.deloitte.deloitte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.deloitte.Utils.StatusCodes;
import com.deloitte.deloitte.Utils.UserNotLoggedIn;
import com.deloitte.deloitte.Utils.WSResponse;
import com.deloitte.deloitte.models.ToDoItems;
import com.deloitte.deloitte.services.TodoService;

@RestController
public class ToDoItemsController {
	@Autowired
	private TodoService todoService;

	@CrossOrigin
	@PostMapping("/createItem")
	public WSResponse createItem(@RequestBody ToDoItems toDoItems, @RequestHeader String sessionToken) {

		WSResponse wsResponse = new WSResponse();

		try {
			wsResponse.setResultSet(todoService.createItem(toDoItems,sessionToken));
			wsResponse.setOperationStatus(StatusCodes.OPERATIONSUCCESSFULL);

		}catch (UserNotLoggedIn e) {
			wsResponse.setOperationStatus(StatusCodes.USERNOTLOGGEDIN);
		} catch (Exception e) {
			e.printStackTrace();
			wsResponse.setOperationStatus(StatusCodes.UNKNOWNERROR);

		}

		return wsResponse;
	}
}
