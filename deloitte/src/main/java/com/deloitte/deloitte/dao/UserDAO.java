package com.deloitte.deloitte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitte.models.User;

// DAO/Repository interfaces extending JPA repository to access buit-in JPA methods for implementing MVC pattern
@Repository
public interface UserDAO extends JpaRepository<User, String>{

//Query to fetch User's Email address and password
	@Query(value = "Select * from user u where u.email_id=?1 AND password=?2", nativeQuery = true)
	User getUserFromEmailAndPassword(String emailId, String password);

//Query to fetch User's Email address and password
	@Query(value = "Select * from user u where u.session_token=?1", nativeQuery = true)
	User getUserFromSessionToken(String sessionToken);

}
