package com.luv2code.springboot.carsale.service;

import java.util.List;

import com.luv2code.springboot.carsale.entity.Visit;

public interface VisitService {
	public List<Visit> findAll();
	public Visit findbyId(int theId);
	public void save(Visit theVisits);
	public void deleteById(int theId);
	public List<Visit> findByBuyer(int buyerId);
}
