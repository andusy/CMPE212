/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	DateReturnedBeforeDateRented.java
 Program Description: Exception improperly entered date
 */
package ch.makery.address.model;

public class DateReturnedBeforeDateRented extends Exception{
	public DateReturnedBeforeDateRented(){		
		super("The return date is before the rental date!");
	}
	
	public DateReturnedBeforeDateRented(String message){
		super(message);
	}
}
