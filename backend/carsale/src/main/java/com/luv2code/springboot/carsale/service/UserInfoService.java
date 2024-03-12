package com.luv2code.springboot.carsale.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.carsale.DAO.UserRepository;
import com.luv2code.springboot.carsale.entity.User;

@Service
public class UserInfoService implements UserDetailsService  {
	
	@Autowired
	private UserRepository repository; 
	  
	  @Autowired
	    private PasswordEncoder encoder; 
	  


		@Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
	  
	        Optional<User> userDetail = repository.findByEmail(username); 
	  
	        // Converting userDetail to UserDetails 
	        return userDetail.map(UserInfoDetails::new) 
	                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
	    } 
	  
	    public void addUser(User userInfo) { 
	        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
	        repository.save(userInfo); 
	      //  return "User Added Successfully"; 
	    } 
}
