/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Rental.java
 Program Description: Rental class that contains an item, customer id, rent days, and days late
 */
package ch.makery.address.model;
import java.util.Date;

public class Rental {
	private Item i;
	private Customer custom;
	
	private int rentalDays;
	private int daysLate;
	
	private static int transactionID = 0;
	private int currentTransactionID;
	
	//Dates
	private Date rental;
	private Date estimatedReturn;
	private Date returned;
	
	private RentalType status; //Rental Status
	
	
	//Empty Constructor
	public Rental (){
	}
	
	//Copy constructor
	public Rental (Rental r){
		i = r.i;
		custom = r.custom;
		rentalDays = r.rentalDays;
		daysLate = r.daysLate;
		currentTransactionID = r.currentTransactionID;
		rental = r.rental;
		estimatedReturn = r.estimatedReturn;
		status = r.status;
	}
	
	//Constructor with all the attributes
	public Rental (Item item, Customer c, Date rent, Date due, Date returnd){
		i = item;
		custom = c;
		rentalDays = daysBetween(rent, returnd);
		daysLate = daysBetween(due, returnd);
		currentTransactionID = transactionID++;
		rental = rent;
		estimatedReturn = due;
		returned = returnd;
		status = RentalType.ACTIVE; //Initialized to active
	}
	
	//Accessors
	public Item getItem(){
		return i;
	}
	
	
	public int getRent(){
		return rentalDays;
	}
	
	public int getLate(){
		return daysLate;
	}
	
	public int getTransactionID(){
		return currentTransactionID;
	}
	
	public Date getRented(){
		return rental;
	}
	
	public Date getDue(){
		return estimatedReturn;
	}
	
	public Date getReturned(){
		return returned;
	}
	
	public RentalType getStatus(){
		return status;
	}
	
	//Mutators
	public void setItem(Item item){
		if (item instanceof Device){ //If the item in the rental is a device
			if (item instanceof Adaptor){//If the item is an adaptor
				i = new Adaptor();	//Create adaptor object
			} else if (item instanceof Laptop){//If the item is a laptop
				i = new Laptop();//Create laptop object
			} else {
				i = new Device();//Create device object
			}
		} else { //Item is not a device therefore it is a book
			if (item instanceof Textbook){//If item is a textbook
				i = new Textbook();//Create textbook object
			} else if (item instanceof Magazine){ //If item is a magazine
				i = new Magazine();//Create magazine object
			} else {
				i = new Book();
			}
		}
		i = item.clone();
	}
		
	public void setRent(int rent){
		//Checks for valid rental cost
		if (rent >= 0){
			rentalDays = rent;
		} else {
			System.out.println("Invalid rental days!");
		}
	}
	
	public void setLate(int late){
		//Checks for valid number of days
		if (late >= 0){
			daysLate = late;
		} else {
			System.out.println("Invalid number of Days!");
		}
	}
	
	//Status Modifiers
	//Takes in the current date and checks if the rental is late
	public boolean isLate(Date current){
		if (current.after(this.estimatedReturn)){//Checks if the current date is after the current date
			status = RentalType.LATE;
			return true;
		}
		return false;
	}
	
	//Takes in the current date and time and closes the rental
	public void itemReturned(Date current){
		status = RentalType.CLOSED;
		returned = current;
	}
	
	//getLateFees Function that calls the getLateFees functions from the other objects using the dates in the rental
	public double getLateFee(){
		int daysLate = daysBetween(estimatedReturn, returned);
		
		if (this.isLate(returned)){
			return i.getLateFees(daysLate);
		} else {
			return 0;
		}
	}
	
	//Method to calculate the days between 2 dates
	private int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	//Method to calculate the rental cost (without late fees) of the rental
	public double getRentalCost (){
		if (i instanceof Device){
			return ((Device) i).getRent(); //The rental cost of the device 
		} else {
			return 0;
		}
	}
	
	//Calculates the total cost after applying discounts
	public double getTotalToBePaid(){
		double total = this.getRentalCost() + this.getLateFee();
		
		if (this.custom.getCustomerType().equals(CustomerType.STUDENT)){
			return total * (1 - custom.getDiscount()); 
		} else {
			return total;
		}
		
	}
	
	//Equals method
	public boolean equals (Rental r){
		return this.i.equals(r.i) && this.custom.equals(r.custom) && this.rentalDays == r.rentalDays && this.daysLate == r.daysLate;
	}
	
	//toString Method
	public String toString (){
		return (this.i.toString() + "\n" + this.custom.toString() + "\nRental Days: " + this.rentalDays + "\nDays Late: " + this.daysLate);
	}
	
	//Clone Method
	public Rental clone (){
		Rental r = new Rental(this.i, this.custom, this.rental, this.estimatedReturn, this.returned);
		return r;
	}
}
