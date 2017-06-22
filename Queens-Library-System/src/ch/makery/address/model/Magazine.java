/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Magazine.java
 Program Description: Magazine class that extends the book class
 */
package ch.makery.address.model;

public class Magazine extends Book{

	//Constructors
	//Empty Constructor
	public Magazine(){
	}
	
	public Magazine(String name, String auth, String pub, int yr){
		super(name, auth, pub, yr);
	}
	
	//Copy constructor
	public Magazine(Magazine mg){
		super(mg);
	}
	
	//Constructor that allows initializing of id
	public Magazine(int id, String name, String auth, String pub, int yr){
		super(id,name,auth, pub,yr);
	}
	
	//Calculate the late fees of the Magazine item
	public double getLateFees(int daysLate){
		return 0.75 * daysLate;
	}

	//equals method
	public boolean equals(Magazine mg){
		if (mg instanceof Magazine){
			return 	super.equals(mg);
		}
		return false;//mg is not a textbook object
	}
	
	//toString method
	public String toString (){
		return super.toString();
	}
	
	//clone method
	public Magazine clone(){
		Magazine newMG = new Magazine(this.getItemName(), this.getAuthor(), this.getPublisher(), this.getYear());
		return newMG;
	}

}
