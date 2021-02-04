package com.deloitte.deloitte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitte.models.User;


@Repository
public interface UserDAO extends JpaRepository<User, String>{

	@Query(value = "Select * from user u where u.email_id=?1 AND password=?2", nativeQuery = true)
	User getUserFromEmailAndPassword(String emailId, String password);

}
