package com.luv2code.springboot.carsale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.carsale.DAO.CarRepository;
import com.luv2code.springboot.carsale.entity.Car;
import com.luv2code.springboot.carsale.exceptions.CarNotFoundException;

@Service
public class CarServiceImpl implements CarService {
	public CarRepository carRepository;
	
	
	@Autowired
	public CarServiceImpl(CarRepository carDAO) {
		this.carRepository = carDAO;
	}


	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public Car findbyId(int theId) {
		Optional<Car> result = carRepository.findById(theId);
		Car theCar =null;
		if(result.isPresent()) {
			theCar= result.get(); 
		}else {
			throw new RuntimeException("can not find car in DB");
		}
		return theCar;
	}

	@Override
	public void save(Car theCars) {
		if(theCars.getBrand() == "" || theCars.getModel() == "" || theCars.getType() == null || theCars.getInspectionReport() == "" 
				|| theCars.getKm() == -1  || theCars.getPrice() == 0  || theCars.getYear() == 0  ) {
	   //     throw new IllegalArgumentException(" all is required.");
	        throw new CarNotFoundException("all fields are required");

		}
		 carRepository.save(theCars);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		Car theCars = this.findbyId(theId);
		if(theCars== null) {
			throw new RuntimeException("car id not found: "+theId);
		}
	//	carRepository.deleteById(theId);
		carRepository.delete(theCars);

	}
	


}
