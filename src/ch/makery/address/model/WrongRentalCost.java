/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	WrongRentalCost.java
 Program Description: Exception for wrong rental costs
 */
package ch.makery.address.model;

public class WrongRentalCost extends Exception{
	
	public WrongRentalCost(){		
		super("Wrong Rental Cost!");
	}
	
	public WrongRentalCost(String message){
		super(message);
	}
}
