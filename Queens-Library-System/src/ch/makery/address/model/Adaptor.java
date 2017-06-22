/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Adaptor.java
 Program Description: Adaptor item that extends device
 */
package ch.makery.address.model;

public class Adaptor extends Device{
	private static final double FEE = 2.5; //Cost of the adaptor per day
	
	//Constructors
	public Adaptor (){
	}
	
	public Adaptor (String name, double rent){
		super(name, rent);
	}
	
	//Copy constructor
	public Adaptor(Adaptor a){
		super(a);
	}
	
	//Constructor that allows initializing of id
	public Adaptor(int id, String name, double rent){
		super(id,name,rent);
	}
	
	//Calculates the late fees of a Adaptor
	public double getLateFees(int daysLate){ 
		return (FEE*daysLate) + (0.15*super.getRent());
	}
	
	//equals method
	public boolean equals(Adaptor a){
		if (a instanceof Adaptor){
			return super.equals(a);//Checks if the adaptors are equal
		}
		return false;//a is not an adaptor
	}
	
	//toString method
	public String toString (){
		return super.toString();
	}
	
	//clone method
	public Adaptor clone(){
		Adaptor adap = new Adaptor (this.getItemName(), this.getRent());
		return adap;
	}
}
