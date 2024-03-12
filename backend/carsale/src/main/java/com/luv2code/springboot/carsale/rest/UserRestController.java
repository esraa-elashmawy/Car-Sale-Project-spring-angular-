package com.luv2code.springboot.carsale.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.carsale.entity.AuthRequest;
import com.luv2code.springboot.carsale.entity.User;
import com.luv2code.springboot.carsale.service.JwtService;
import com.luv2code.springboot.carsale.service.UserInfoService;
import com.luv2code.springboot.carsale.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class UserRestController {

	@Autowired
	private UserInfoService service;

	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/checkUser/{email}/{password}")
	public User checkUser(@PathVariable String email, @PathVariable String password) {
		return userService.checkUser(email, password);
	}
	
	@GetMapping("/checkUserByEmail/{email}")
	public User checkUserByEmail(@PathVariable String email) {
		return userService.checkUserByEmail(email);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/addNewUser")
	public void addNewUser(@RequestBody User userInfo) {
		 service.addUser(userInfo);
	} 

	@GetMapping("/user/userProfile")
	@PreAuthorize("hasAuthority('USER')")
	public String userProfile() {
		return "Welcome to User Profile";
	}

	@GetMapping("/admin/adminProfile")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String adminProfile() {
		return "Welcome to Admin Profile";
	}

	@PostMapping("/generateToken")
	public  List<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		List<String> userLogin = new ArrayList<String>();
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			System.out.println("token:" + authentication.getAuthorities());
			User user=checkUserByEmail(authentication.getName());
			userLogin.add(jwtService.generateToken(authRequest.getUsername()));
			userLogin.add(authentication.getAuthorities().toString());
			userLogin.add(user.getUser_id()+"");
			//return jwtService.generateToken(authRequest.getUsername());
			return userLogin;
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	

}
