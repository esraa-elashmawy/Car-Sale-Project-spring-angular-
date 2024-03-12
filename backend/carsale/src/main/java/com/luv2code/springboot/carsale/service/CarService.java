package com.luv2code.springboot.carsale.service;

import java.util.List;

import com.luv2code.springboot.carsale.entity.Car;

public interface CarService {
	public List<Car> findAll();
	public Car findbyId(int theId);
	public void save(Car theCars);
	public void deleteById(int theId);
}
