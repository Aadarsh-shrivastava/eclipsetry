package com.exam.examportal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.exam.examportal.entity.User;
import com.exam.examportal.entity.Role;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.services.UserService;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner{
	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting user creations");
		User user =new User();	
		user.setFirstName("Aadarsh");
		user.setLastName("Shrivastava");
		user.setEmail("Aadarsh@Hotmale.com");
		user.setUserName("Aj32");
		user.setPassword("12345");
		user.setProfile("default.png");
		user.setEnabled(true);

		
		Role role=new Role();
		role.setRoleId(45);
		role.setRoleName("chutiya");
		
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole=new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		System.out.println(userRoleSet);
		
		User user1=this.userService.createUser(user, userRoleSet);
		
	}

}
