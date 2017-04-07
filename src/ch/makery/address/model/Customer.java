/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Customer.java
 Program Description: Customer class that contains the info for a customer
 */
package ch.makery.address.model;

public class Customer {

	private CustomerType type;
	private int customer_ID;
	private String name;
	private String department;
	
	private final double STUDENT_DISCOUNT = 0.25; //Discount on rental costs recieved by students
	
	
	//Constructors
	public Customer (){		
	}
	
	public Customer (CustomerType customer, int id, String nm, String dep){
		type = customer;
		customer_ID = id;
		name = nm;
		department = dep;
	}
	
	//Accessors
	public CustomerType getCustomerType(){
		return type;
	}
	
	public int getCustomerID(){
		return customer_ID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public double getDiscount(){
		return STUDENT_DISCOUNT;
	}
	
	//Mutators
	public void setCustomerType(CustomerType t){
		type = t;
	}
	
	public void setCustomerID(int id){
		customer_ID = id;
	}
	
	public void setName(String nm){
		name = nm;
	}
	
	public void setDepartment (String dep){
		department = dep;
	}
	
	//toString function
	public String toString (){
		return "Customer Type: " + type + "\nCustomer ID: " + customer_ID + "\nName: " + name + "\nDepartment: " + department;
	}
		
	//Equals function
	public boolean equals(Customer c){
		return (this.type.equals(c.type)) && (this.customer_ID == c.customer_ID) && (this.name.equals(c.name)) && (this.department.equals(c.department));
	}
}
