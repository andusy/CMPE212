/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	March 29,2017
 Title:	Book.java
 Program Description: Book class that extends the Item class
 */
package ch.makery.address.model;

public class Book extends Item{
	private String author;
	private String publisher;
	private int year;
	
	//Constructors
	//Empty constructor
	public Book(){
	}
	
	public Book (String name, String auth, String pub, int yr){
		super(name);
		author = auth;
		publisher = pub;
		year = yr;
	}
	
	//Copy Constructor
	public Book (Book b){
		super(b.getItemName());
		author = b.getAuthor();
		publisher = b.getPublisher();
		year = b.getYear();
	}
	
	//Constructor that allows initializing of id
	public Book(int id, String name, String auth, String pub, int yr){
		super(id,name);
		author = auth;
		publisher = pub;
		year = yr;
	}
	
	//Accessors
	public String getAuthor(){
		return this.author;
	}
	
	public String getPublisher(){
		return this.publisher;
	}
	
	public int getYear(){
		return this.year;
	}
	
	//Mutators
	public void setAuthor(String a){
		if (a.equals("")){//Entered string is blank
			System.out.println("Invalid Author!");
		} else {
			author = a;
		}
	}
	
	public void setPublisher(String p){
		if (p.equals("")){//Entered string is blank
			System.out.println("Invalid Publisher!");
		} else {
			publisher = p;
		}
	}
	
	public void setYear(int y){
		if (y >= 0){ //Non negative year
			year = y;
		} else {
			System.out.println("Invalid Year!");
		}
	}

	//Calculates the late fees of a book item
	public double getLateFees(int daysLate){
		return 0.5 * daysLate;
	}
	
	//qquals method
	public boolean equals(Book b){
		if (b instanceof Book){
			return super.equals(b) && this.getAuthor().equals(b.getAuthor()) && this.getPublisher().equals(b.getPublisher()) && this.getYear() == b.getYear();//Checks if all the instances are equal
		}
		return false;//b is not a book item
	}
	
	//toString method
	public String toString(){
		return super.toString() + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nYear: " + year;
	}
	
	//clone method
	public Book clone(){
		Book newBook = new Book(this.getItemName(), this.getAuthor(), this.getPublisher(), this.getYear());
		return newBook;
	}
}
