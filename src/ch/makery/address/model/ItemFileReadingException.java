/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	ItemFileReadingException.java
 Program Description: Exception for item file reading
 */
package ch.makery.address.model;

public class ItemFileReadingException extends Exception{

	public ItemFileReadingException(){		
		super("Error Reading Item File!");
	}
	
	public ItemFileReadingException(String message){
		super(message);
	}
	
}
