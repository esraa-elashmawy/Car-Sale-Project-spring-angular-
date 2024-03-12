package com.luv2code.springboot.carsale.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.carsale.DAO.VisitRepository;
import com.luv2code.springboot.carsale.entity.Visit;

@Service
public class VisitServiceImpl implements VisitService {
	@Autowired
	public VisitRepository visitRepository;

	@Override
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return visitRepository.findAll();
	}

	@Override
	public Visit findbyId(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	@Transactional
	public void save(Visit theVisits) {
		System.out.println(theVisits);
		// TODO Auto-generated method stub
		this.visitRepository.save(theVisits);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Visit> findByBuyer(int buyerId) {
		return visitRepository.findByBuyer_UserId(buyerId);
	}
	


}
