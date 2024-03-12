package com.luv2code.springboot.carsale.exceptions;

public class CarNotFoundException extends RuntimeException{

	public CarNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CarNotFoundException(String arg0) {
		super(arg0);
	}

	public CarNotFoundException(Throwable arg0) {
		super(arg0);
	}
	

}
