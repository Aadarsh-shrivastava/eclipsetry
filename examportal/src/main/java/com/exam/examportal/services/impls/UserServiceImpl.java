package com.exam.examportal.services.impls;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.entity.User;
import com.exam.examportal.entity.UserRole;
import com.exam.examportal.repo.RoleRepository;
import com.exam.examportal.repo.UserRepository;
import com.exam.examportal.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userRepo.findByUserName(user.getUserName());
		if(local!=null) {
			System.out.println("0user already exist"); 
			throw new Exception("User already exist"); 
		}
		else {

			System.out.println(userRoles+"urroles");
			for(UserRole ur:userRoles) {
				roleRepo.save(ur.getRole());
				
			}
			user.getUserRoles().addAll(userRoles);
			System.out.println(local+"printing local value222");
			local= (User) this.userRepo.save(user);	
			System.out.println(local+"printing local value");
		}
		
		return local;
	}

}
