/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	DuplicateCustomerID.java
 Program Description: Exception for duplicate customer id
 */
package ch.makery.address.model;

public class DuplicateCustomerID extends Exception{
	
	public DuplicateCustomerID(){		
		super("Duplicate Customer ID detected!");
	}
	
	public DuplicateCustomerID(String message){
		super(message);
	}
}
