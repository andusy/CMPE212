/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Laptop.java
 Program Description: Laptop object that extends Device
 */
package ch.makery.address.model;

public class Laptop extends Device{
	private static final double FEE = 5; //Cost of the laptop per day
	
	//Constructors
	public Laptop(){
	}
	
	public Laptop(String name, double rent){
		super(name, rent);
	}
	
	//Copy constructor
	public Laptop(Laptop l){
		super(l);
	}
	
	//Constructor that allows initializing of id
	public Laptop(int id, String name, double rent){
		super(id,name, rent);
	}
	
	//Calculates the late fees of the Laptop
	public double getLateFees(int daysLate){ 
		return (FEE*daysLate) + (0.2*super.getRent());
	}
	
	//equals method
	public boolean equals(Laptop l){
		if (l instanceof Laptop){
			return super.equals(l);//Checks if the laptop items are equal
		}
		return false;//l is not a Laptop item
	}
	
	//toString method
	public String toString (){
		return super.toString();
	}
	
	//clone method
	public Laptop clone(){
		Laptop lap = new Laptop (this.getItemName(), this.getRent());
		return lap;
	}
}
