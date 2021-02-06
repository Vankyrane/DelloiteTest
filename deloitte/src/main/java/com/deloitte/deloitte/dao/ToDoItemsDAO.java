package com.deloitte.deloitte.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitte.models.ToDoItems;

// DAO/Repository interfaces extending JPA repository to access buit-in JPA methods for implementing MVC pattern
@Repository
public interface ToDoItemsDAO extends JpaRepository<ToDoItems, String>{

	ArrayList<ToDoItems> findAllByUserId(String id);

}
