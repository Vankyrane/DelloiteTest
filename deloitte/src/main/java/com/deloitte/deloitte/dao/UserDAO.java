package com.deloitte.deloitte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.deloitte.models.User;


@Repository
public interface UserDAO extends JpaRepository<User, String>{

}
