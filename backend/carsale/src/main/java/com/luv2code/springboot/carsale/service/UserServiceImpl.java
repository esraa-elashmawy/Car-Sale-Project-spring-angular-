package com.luv2code.springboot.carsale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.carsale.DAO.UserRepository;
import com.luv2code.springboot.carsale.entity.User;

@Service
public class UserServiceImpl implements UserService {
	public UserRepository userRepository;
	
	  @Autowired
	    private PasswordEncoder encoder; 
	  

	
	@Autowired
	public UserServiceImpl(UserRepository userDAO) {
		this.userRepository = userDAO;
	}
	
	public User checkUser(String email, String password) {
		
		return userRepository.checkUser(email, password);
	}
	

	

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findbyId(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User theUsers) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}



	@Override
    public String addUser(User userInfo) { 
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        userRepository.save(userInfo); 
        return "User Added Successfully"; 
    }

	@Override
	public User checkUserByEmail(String email) {
		return userRepository.checkUserByEmail(email);
	} 

}
