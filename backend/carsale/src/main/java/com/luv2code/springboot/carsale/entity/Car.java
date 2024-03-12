package com.luv2code.springboot.carsale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARS")
public class Car{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID")
	private int car_id;
	
	@Column(name="Brand",nullable = false)
	private String brand;
	
	@Column(name="Model",nullable = false)
	private String model;
	
	@Column(name="KM",nullable = false)
	private int km; 
	
	@Column(name="Year",nullable = false)
	private int year;
	
	@Column(name="Type",nullable = false)
	private carType type;
	
	@Column(name="InspectionReport",nullable = false)
	private String inspectionReport;
	
	@Column(name="Price",nullable = false)
	private int price;
	
	@Column(name="Picture")
	private String picture;
	
	
	
	enum carType {
	    Automatic,
	    Manual;
	}


	public Car() {
		
	}

	public Car(int car_id, String brand, String model, int km, int year, carType type, String inspectionReport,
			int price, String picture) {
		this.car_id = car_id;
		this.brand = brand;
		this.model = model;
		this.km = km;
		this.year = year;
		this.type = type;
		this.inspectionReport = inspectionReport;
		this.price = price;
		this.picture = picture;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public carType getType() {
		return type;
	}

	public void setType(carType type) {
		this.type = type;
	}

	public String getInspectionReport() {
		return inspectionReport;
	}

	public void setInspectionReport(String inspectionReport) {
		this.inspectionReport = inspectionReport;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Cars [car_id=" + car_id + ", brand=" + brand + ", model=" + model + ", km=" + km + ", year=" + year
				+ ", type=" + type + ", inspectionReport=" + inspectionReport + ", price=" + price + ", picture="
				+ picture + "]";
	}
	
	
	
	

	

}
