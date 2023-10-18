package com.exam.examportal.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
@Service
public interface UserService {
	//creating user
	public User createUser(User user,Set<UserRole> userRoles ) throws Exception;
}
