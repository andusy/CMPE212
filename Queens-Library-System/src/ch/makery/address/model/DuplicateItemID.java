/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	DuplicateItemID.java
 Program Description: Exception for duplicate item id
 */
package ch.makery.address.model;

public class DuplicateItemID extends Exception{
	
	public DuplicateItemID(){		
		super("Duplicate Item ID detected!");
	}
	
	public DuplicateItemID(String message){
		super(message);
	}
}
