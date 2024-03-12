package com.luv2code.springboot.carsale.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="VISITS")
public class Visit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private int visit_id;
	
	//@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@Column(name="DateTime",nullable = false)
	private Date dateTime;
	
	@JoinColumn(name="Car_Id")
	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Car car_id;
	

	@JoinColumn(name="Buyer_Id")
	@ManyToOne()
	private User buyer;

	public Visit() {
		
	}
	

	public Visit(int visit_id, Date dateTime, Car car_id, User buyer_id) {
		this.visit_id = visit_id;
		this.dateTime = dateTime;
		this.car_id = car_id;
		this.buyer = buyer_id;
	}



	public int getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Car getCar_id() {
		return car_id;
	}

	public void setCar_id(Car car_id) {
		this.car_id = car_id;
	}


	public User getBuyer() {
		return buyer;
	}


	public void setBuyer(User buyer_id) {
		this.buyer = buyer_id;
	}


	
	
	
	
	

	



}
