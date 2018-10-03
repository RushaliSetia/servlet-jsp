package com.bean;

public class InvalidAgeException extends Exception {

	final String msg="Age should be greater than 18";

	@Override
	public String toString() {
		return "InvalidAgeException [msg=" + msg + "]";
	}
	
	
	
	
}
