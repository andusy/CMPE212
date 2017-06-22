/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Textbook.java
 Program Description: Textbook class that extends the book class
 */
package ch.makery.address.model;
public class Textbook extends Book{
	
	//Constructors
	//Empty Constructor
	public Textbook(){
	}
	
	public Textbook(String name, String auth, String pub, int yr){
		super(name, auth, pub, yr);
	}
	
	//Copy constructor
	public Textbook(Textbook tb){
		super(tb);
	}
	
	//Constructor that allows initializing of id
	public Textbook(int id, String name, String auth, String pub, int yr){
		super(id,name,auth, pub,yr);
	}
	
	//Calculate the late fees of the textbook item
	public double getLateFees(int daysLate){
		return daysLate;
	}

	//equals method
	public boolean equals(Textbook tb){
		if (tb instanceof Textbook){
			return 	super.equals(tb);
		}
		return false;//tb is not a textbook object
	}
	
	//toString method
	public String toString (){
		return super.toString();
	}
	
	//clone method
	public Textbook clone(){
		Textbook newTB = new Textbook(this.getItemName(), this.getAuthor(), this.getPublisher(), this.getYear());
		return newTB;
	}
	
}
