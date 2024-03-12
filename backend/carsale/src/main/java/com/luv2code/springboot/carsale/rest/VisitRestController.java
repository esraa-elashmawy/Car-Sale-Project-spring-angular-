package com.luv2code.springboot.carsale.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.carsale.entity.Visit;
import com.luv2code.springboot.carsale.service.VisitService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v")
public class VisitRestController  {

public VisitService visitService;
	
	@Autowired
	public VisitRestController(VisitService visitService) {
		this.visitService = visitService;
	}
	
	@GetMapping("/visit")
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<Visit> findAll(){
		return visitService.findAll();
	}
	
	
	@PostMapping("/visit")
	@PreAuthorize("hasAuthority('USER')")
	public Visit postVisit(@RequestBody Visit visit){
		visitService.save(visit);
		return visit;
	}
	
	@GetMapping("/visit/{buyerId}")
	@PreAuthorize("hasAuthority('USER')")
	public List<Visit> findByBuyer(@PathVariable int buyerId) {
		return visitService.findByBuyer(buyerId);
	}
	
	
	 


}
