package com.luv2code.springboot.carsale.DAO;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luv2code.springboot.carsale.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query("SELECT u FROM User u WHERE u.username = :username")
//    public User getUserByUsername(@Param("username") String username);

	
//  @Query("SELECT u FROM User WHERE email=:email and password=:pass")
//  public boolean checkUser(@Param("email") String email,@Param("password") String password);
// 
	
	
	
  @Query("select u from User u where u.email =:email and u.password =:password")
  User checkUser(@Param("email")String email, @Param("password")String password);
  
  @Query("select u from User u where u.email =:email")
  User checkUserByEmail(@Param("email")String email );


  Optional<User> findByEmail(String email);
}

