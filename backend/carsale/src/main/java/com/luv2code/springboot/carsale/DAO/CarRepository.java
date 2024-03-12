package com.luv2code.springboot.carsale.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.carsale.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
