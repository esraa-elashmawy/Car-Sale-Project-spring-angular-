package com.luv2code.springboot.carsale.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.carsale.entity.Car;
import com.luv2code.springboot.carsale.service.CarService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600, allowCredentials="true")
//@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = {"Authorization", "Origin"}) 
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api")
public class CarRestController {
	
	public CarService carService;
	
	@Autowired
	public CarRestController(CarService CarsService) {
		this.carService= CarsService;
	}
	
	@GetMapping("/car")
	public List<Car> findAll(){
		return carService.findAll();
	}
	
	@GetMapping("/car/{eId}")
	public Car findbyId(@PathVariable int eId){
		Car theCars = carService.findbyId(eId);
		if(theCars== null) {
			throw new RuntimeException("car id not found: "+eId);
		}
		return theCars;
	}
	
	@PostMapping("/car")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Car postCars(@RequestBody Car car){
		carService.save(car);
		return car;
	}
	
////	@CrossOrigin(origins = "http://localhost:50885")
//	@PutMapping("/car")
//	public Car updateCars(@RequestBody Car car){
//		carService.save(car);
//		return car;
//	}
	
	@DeleteMapping("/car/{eId}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteCars(@PathVariable int eId){
//		Car theCars = carService.findbyId(eId);
//		if(theCars== null) {
//			throw new RuntimeException("car id not found: "+eId);
//		}
		System.out.println("jkhi");
		carService.deleteById(eId);
	//	return theCars;
	}
	
	

}
