package ch.makery.address.model;

public class DuplicateTransactionID extends Exception {
	
	public DuplicateTransactionID(){		
		super("Duplicate Transaction ID detected!");
	}
	
	public DuplicateTransactionID(String message){
		super(message);
	}
}
