/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Item.java
 Program Description: Abstract item class 
 */
package ch.makery.address.model;

public abstract class Item {
	private static int item_ID = 0;//Item id that will increment when a new item is created
	private int currentItemID;//Item id given to this object
	private String item_Name;
	
	//Constructors
	public Item (){
	}

	public Item (String name){//remove id **must be done using a static variable
		currentItemID = item_ID++;
		item_Name = name;
	}
	
	//Constructor that allows initializing of id
	public Item(int id, String name){
		currentItemID = id;
		item_Name = name;
	}
	
	//Accessors
	public int getItemID(){
		return currentItemID;
	}
	
	public String getItemName(){
		return item_Name;
	}
	
	//Mutators	
	public void setItemName(String s){
		//Checks for valid string name (not empty name)
		if (s.equals("")){
			System.out.println("Invalid item Name!");
		} else {
			item_Name = s;
		}
	}
	
	//Abstract method
	public abstract double getLateFees(int daysLate);
	
	//equals method
	public boolean equals(Item i){
		if (i instanceof Item){
			return this.getItemID() == i.getItemID() && this.getItemName().equals(i.getItemName());//Checks if they are equal
		}
		return false;//Returns false if not item
	}
	
	//toString method
	public String toString(){
		return "Item ID: " + currentItemID + "\nItem Name: " + item_Name;
	}
	
	//clone method
	public Item clone (){
		Item clonedItem = this.clone();
		return clonedItem;
	}
}
	