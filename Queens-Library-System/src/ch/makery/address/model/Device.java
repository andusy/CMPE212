/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Device.java
 Program Description: Device class that extends the item class
 */
package ch.makery.address.model;

public class Device extends Item{
	private static final double FEE = 2; //Cost of the device per day
	private double rentalCost;//Cost of renting device per day
	
	//Constructors
	public Device (){
	}
	
	public Device (String name, double rent){
		super(name);
		rentalCost = rent;
	}
	
	//Copy constructor
	public Device (Device d){
		super(d.getItemName());
		rentalCost = d.rentalCost;
	}
	
	//Constructor that allows initializing of id
	public Device(int id, String name, double rent){
		super(id,name);
		rentalCost = rent;
	}
	
	//Accessors
	public double getRent(){
		return rentalCost;
	}
	
	//Mutators
	public void setRent(double r){
		//Checks for valid rental cost
		if (r >= 0){
			rentalCost = r;
		} else {
			System.out.println("Invalid rental cost!");
		}
	}
	
	//Calculates the late fees of a device item
	public double getLateFees(int daysLate){ 
		return (FEE*daysLate) + (0.1*rentalCost);
	}
	
	//equals method
	public boolean equals(Device d){
		if (d instanceof Device){
			return super.equals(d)  && this.getRent() == d.getRent();//Checks if they are equal
		}
		return false;//If not device compared with device returns false
	}
	
	//toString method
	public String toString (){
		return super.toString() + "\nRental Cost: " + rentalCost;
	}
	
	//clone method
	public Device clone(){
		Device i = new Device (this.getItemName(), this.rentalCost);
		return i;
	}
	
}
