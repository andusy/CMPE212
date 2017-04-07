/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	LibrarySystem.java
 Program Description: This class only contains 3 methods. It has an arraylist of rental objects that keep track of the library system
 */
package ch.makery.address.model;
import java.util.HashMap;

public class LibrarySystem {
	private HashMap<Integer, Rental> transactions;
	private HashMap<Integer, Item> uniqueItems;
	private HashMap<Integer, Customer> customers;
	
	//Constructor
	public LibrarySystem (){
		transactions = new HashMap<Integer, Rental>();
		uniqueItems = new HashMap<Integer, Item>();
		customers = new HashMap<Integer, Customer>();
	}
	
	//Adds a transaction to the list, returns true if successfully added
	public boolean addTransaction (Rental r){
		if (transactions.containsKey(r.getTransactionID()) == false){ //If the array element at that key is empty
			transactions.put(r.getTransactionID(),r);
			return true;
		}
		return false;
	}
	
	//Adds an item to the uniqueItems list, returns true if successfully added
	public boolean addItem (Item i){
		if (uniqueItems.containsKey(i.getItemID()) == false){ //If the array element at that key is empty
			uniqueItems.put(i.getItemID(), i);
			return true;
		}
		return false;
	}
	
	//Adds a customer to the customer list, returns true if successfully added
	public boolean addCustomer (Customer c){
		if (customers.containsKey(c.getCustomerID()) == false){
			customers.put(c.getCustomerID(), c);
			return true;
		}
		return false;
	}
			
	//Method to Get Total Late Fees
	public double getTotalLateFees(){
		double lateFees = 0;
		int arraysize = transactions.size();
		Item itm;
		
		for (int i = 0; i < arraysize; i++){
			itm = transactions.get(i).getItem();//itm is equal to item in the array element i of the array list
			lateFees += itm.getLateFees(transactions.get(i).getLate());//Calculates and adds the late fees to the total
		}
		return lateFees;
	}
	
	//Method to calculate the total rental costs
	public double getTotalRentalCosts (){
		double rentalCost = 0;
		int arraysize = transactions.size();
		Item itm;
		Device d = new Device();
		
		for (int i = 0; i < arraysize; i++){
			itm = transactions.get(i).getItem();//itm is equal to item in the array element i of the array list
			
			if (itm instanceof Device){ //Checks if the item is an instance of device (device, adaptor, laptop)
				d = (Device)itm;
				rentalCost += d.getRent();
			}	
		}
		return rentalCost;
	}
	
}
