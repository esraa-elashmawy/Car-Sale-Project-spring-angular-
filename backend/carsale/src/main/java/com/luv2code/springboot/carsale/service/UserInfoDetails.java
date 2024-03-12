package com.luv2code.springboot.carsale.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.luv2code.springboot.carsale.entity.User;

public class UserInfoDetails implements UserDetails {

	  private String email; 
	  private String password; 
	  private List<GrantedAuthority> authorities;
	  
	  private String theRole ;

	  
	    public UserInfoDetails(User userInfo) { 
	        this.email = userInfo.getEmail(); 
	        this.password = userInfo.getPassword(); 
	       this.theRole=userInfo.getRole();
	        System.out.println(userInfo.getRole());
	//  	    authorities.add(new SimpleGrantedAuthority(userInfo.getRole().name()));
	        this.authorities = Arrays.stream(userInfo.getRole().split(",")) 
	                .map(SimpleGrantedAuthority::new) 
	                .collect(Collectors.toList());
	        System.out.println(authorities);

//	       this.authorities = List.of( new SimpleGrantedAuthority(userInfo.getRole().name()));

	    } 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getTheRole() {
		return theRole;
	}

	public void setTheRole(String theRole) {
		this.theRole = theRole;
	}
	
	

}
