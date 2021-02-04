package com.deloitte.deloitte.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitte.models.ToDoItems;


@Repository
public interface ToDoItemsDAO extends JpaRepository<ToDoItems, String>{

	ArrayList<ToDoItems> findAllByUserId(String id);

}
