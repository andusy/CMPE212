/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	CustomerFileReadingException.java
 Program Description: Exception for file reading
 */
package ch.makery.address.model;

public class CustomerFileReadingException extends Exception{
	
	public CustomerFileReadingException(){		
		super("Error Reading Customer File!");
	}
	
	public CustomerFileReadingException(String message){
		super(message);
	}
}
