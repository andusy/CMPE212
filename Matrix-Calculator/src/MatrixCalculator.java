/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	February 13,2017
 Title:	MatrixCalculator.java
 Program Description: Used to test all of the methods available in the Matrix.java class
 */

public class MatrixCalculator {

	public static void main(String[] args) {	
		Matrix m = new Matrix(3,3); //Constructor that creates a mxn matrix
		//Matrix m = new Matrix(); //Constructor that prompts user for dimensions and contents of matrix
		//Matrix m = new Matrix("C:\\Users\\Andus\\workspace\\MatrixCalculator\\src\\input.txt");//Constructor that takes in the file location and file name as a string and creates the matrix
		
		//Displays the matrix m
		System.out.println(m.toString() + "\n");
		
		//Testing Accessors
		System.out.println(m.getN());
		System.out.println(m.getM());
		System.out.println(m.get(0, 0) + "\n");
		
		Matrix n = new Matrix(3,3); //Creating another 3x3 matrix to test other methods
		Matrix result = new Matrix(3,3);//Matrix holding the results of the other methods
		
		//Initialization of n matrix using mutator
		n.set(0, 0, 3);
		n.set(0, 1, 0);
		n.set(0, 2, 2);
		n.set(1, 0, 2);
		n.set(1, 1, 0);
		n.set(1, 2, -2);
		n.set(2, 0, 0);
		n.set(2, 1, 1);
		n.set(2, 2, 1);
		
		/*	Matrix n
		 * 	3 0 2
		 * 	2 0 -2
		 * 	0 1 1
		 */
		
		
		//Testing Other Methods
		result = n.add(n);		//Add Method
		System.out.println(result.toString() + "\n");
		
		result = n.subtract(n);	//Subtract Method
		System.out.println(result.toString() + "\n");
		
		result = n.multiply(n); //Matrix multiplication
		System.out.println(result.toString() + "\n");
		
		result = n.multiply(2); //Scalar multiplication
		System.out.println(result.toString() + "\n");
		
		result = n.divide(n); //Matrix division
		System.out.println(result.toString() + "\n");
		
		System.out.println (n.determinant() + "\n"); //Calculates determinant
		
		result = n.inverse(); //Calculates inverse of matrix
		System.out.println(result.toString() + "\n");
		
		System.out.println(n.isSquare() + "\n"); //Checks if the matrix is square
		
		result = n.transpose(); //Transpose of matrix
		System.out.println(result.toString() + "\n");
		
		result = Matrix.identity(3); //Identity matrix
		System.out.println(result.toString() + "\n");
		
		n.print("output.txt"); //Writing the matrix to a text file
	}

}
