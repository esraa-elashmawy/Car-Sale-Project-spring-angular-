package com.luv2code.springboot.carsale.service;

import java.util.List;

import com.luv2code.springboot.carsale.entity.User;


public interface UserService {
	
	public List<User> findAll();
	public User findbyId(int theId);
	public void save(User theUsers);
	public void deleteById(int theId);
	public String addUser(User userInfo);
	public User checkUser(String email, String password);
	public User checkUserByEmail(String email);

}
