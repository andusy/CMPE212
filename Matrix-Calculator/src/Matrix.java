/*
 Name:	Andus Yu
 Student Number:	10192081
 NetID:	15ay3
 Professor:	Hesham Farahat
 Course:	CMPE212
 Date:	February 13,2017
 Title:	Matrix.java
 Program Description:	Matrix class that contains methods that perform matrix operations
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Matrix {
	private int m; //Number of rows in matrix
	private int n; //Number of columns in matrix
	private double mtx [][];//The 2D array of size mxn that holds decimal numbers

	//Constructors
	public Matrix (int m, int n){ //Creates a matrix given m and n
		this.m = m;
		this.n = n;
		mtx = new double [m][n];
	}
	
	public Matrix (){ //Reads a matrix from a user using terminal or popups
		int row,col;
		Scanner sc = new Scanner (System.in);
		
		//Prompts user to enter rows and columns
		System.out.print("Enter the number of rows: ");
		row = sc.nextInt();
		System.out.print("Enter the number of columns: ");
		col = sc.nextInt();
		
		//Initializes the rows and columns
		this.m = row;
		this.n = col;
		mtx = new double[m][n];
		
		for (int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				System.out.print("Enter value of matrix for row " + i + " column " + j + ": ");
				this.mtx[i][j] = sc.nextDouble();
			}
		}
		sc.close();
	}
	
	public Matrix (String fileName){ //Reads matrix from csv file
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String dim[];
			String str = "";
			String values[];
			
			dim = in.readLine().split(",");
			
			//Sets the number of rows and columns
			m = Integer.parseInt(dim[0]);
			n = Integer.parseInt(dim[1]);
			
			//Reads in all the values and places them into a string
			for (int i = 0; i < m; i++){
				str += in.readLine();
				str += ",";//Added so the next line will be split
			}
			
			//Splits the values from the commas
			values = str.split(",");
			
			//Initializing the matrix
			mtx = new double[m][n];
			
			int index = 0;
			
			//Sets the matrix
			for (int i = 0; i < m; i ++){
				for (int j = 0; j < n; j++){
					mtx[i][j] = Double.parseDouble(values[index]);
					index ++;
				}
			}
			in.close();
		} catch (Exception e){
			System.out.println("File not found");
		}

	}
	
	//Accessors
	public int getN(){ //Gets the value of n
		return n;
	}
	
	public int getM(){ //Gets the value of m
		return m;
	}
	
	public double get(int i, int j){ //Returns the value stored at row i column j of the matrix
		return mtx[i][j];
	}
	
	//Mutator
	public void set(int i, int j, double num){//Sets a matrix coordinate to the specified number
		mtx[i][j] = num;
	}
	
	//Methods
	public Matrix add (Matrix m){ //Adds this matrix to matrix m and returns the result
		Matrix result = new Matrix (this.m, this.n);//New matrix that holds the value of the sum
		
		for (int i = 0; i < this.m; i++){
			for (int j = 0; j < this.n; j++){
				result.mtx[i][j] = this.mtx[i][j] + m.mtx[i][j];
			}			
		}
		return result;
	}
	
	public Matrix subtract (Matrix m){ //Subtract matrix m from this matrix and returns the result
		Matrix result = new Matrix (this.m, this.n);
		
		for (int i = 0; i < this.m; i++){
			for (int j = 0; j < this.n; j++){
				result.mtx[i][j] = this.mtx[i][j] - m.mtx[i][j];
			}
		}
		return result;
	}
	
	public Matrix multiply (Matrix m){ //Matrix multiplication between this matrix and matrix m
		Matrix result = new Matrix (this.m, m.n);
		
		//Initialized the matrix to be all zeros
		for (int i = 0; i < this.m; i++){
			for (int j = 0; j < this.n; j++){
				result.mtx[i][j] = 0;				
			}
		}
		
		//Performs matrix multiplication
		for (int i = 0; i < this.m; i++){
			for (int j = 0; j < m.n; j++){
				for (int k = 0; k < this.n; k++){
					result.mtx[i][j] += this.mtx[i][k] * m.mtx[k][j];
				}
			}			
		}
		return result;
	}
	
	public Matrix multiply (double x){ //Scalar multiplaction of this matrix and x
		Matrix result = new Matrix (this.m, this.n);
		
		//Performs the scalar multiplication
		for (int i = 0; i < this.m; i ++){
			for (int j = 0; j < this.n; j++){
				result.mtx[i][j] = this.mtx[i][j] * x;
			}
		}
		return result;
	}
	
	public Matrix divide (Matrix m){ //Matrix division of this on matrix m
		Matrix inv = m.inverse();//Inverse of m
		
		Matrix result = this.multiply(inv);//performs matrix multiplication of inverse of m by this matrix
		return result; //Returns the result
	}
	
	public double determinant (){ //Calculates and returns the determinant of the matrix
		double det = 0;
		if (this.isSquare()){ //Checks if the matrix is a square matrix
			if (this.m == 1){ //1x1 matrix
				det = this.mtx[0][0];
			} else if(this.m == 2){ //2x2 matrix
				det = (this.mtx[0][0] * this.mtx[1][1]) - (this.mtx[0][1] * this.mtx[1][0]);//ad - bc
			} else if(this.m == 3){ //3x3 matrix
				det = (this.mtx[0][0] * this.mtx[1][1] * this.mtx[2][2]) + (this.mtx[0][1] * this.mtx[1][2] * this.mtx[2][0]) + (this.mtx[0][2] * this.mtx[1][0] * this.mtx[2][1]) - (this.mtx[0][2] * this.mtx[1][1] * this.mtx[2][0]) - (this.mtx[0][1] * this.mtx[1][0] * this.mtx[2][2]) - (this.mtx[0][0] * this.mtx[1][2] * this.mtx[2][1]);//Calculation of 3x3 determinant
			}
		} else { //If the matrix is not square
			System.out.println("Cannot calculate determinant of a non square matrix");
		}

		return det;
	}
	
	public Matrix inverse (){ //Returns the inverse matrix of this matrix
		Matrix result = new Matrix(this.m, this.n);
		
		if (this.isSquare()){ //Checks if the matrix is a square matrix
			if (this.m == 1){ //1x1 matrix
				result.mtx[0][0] = 1/this.mtx[0][0];
			} else if (this.m == 2){ //2x2 matrix
				double det = this.determinant();//Calculates the determinant
				
				//Initializing the values of the result
				result.mtx[0][0] = this.mtx[1][1]; //Switch a and d
				result.mtx[0][1] = this.mtx[0][1];
				result.mtx[1][0] = this.mtx[1][0];
				result.mtx[1][1] = this.mtx[0][0];
				
				//Calculates the inverse by doing scalar multiplication of the new matrix and the determinant
				result = result.multiply(det);	
			} else if (this.m == 3){ //3x3 matrix
				//Matrix of minors
				Matrix minor = new Matrix (2,2);
				
				for (int i = 0; i < this.m; i++){
					for (int j = 0; j < this.m; j++){
						//Sets the minor matrix
						minor.mtx[0][0] = this.mtx[(i+1) % 3][(j+1) % 3];
						minor.mtx[0][1] = this.mtx[(i+2) % 3][(j+1) % 3];
						minor.mtx[1][0] = this.mtx[(i+1) % 3][(j+2) % 3];
						minor.mtx[1][1] = this.mtx[(i+2) % 3][(j+2) % 3];
						
						result.mtx[i][j] = minor.determinant();
					}
				}
				
				//Adjugate
				result = result.transpose();
				
				//Multiply by 1/determinate
				double det = this.determinant();
				result = result.multiply(1/det);
			}
		} else { //If the matrix is not square
			System.out.println("Cannot calculate inverse of a non square matrix");
			result = this;
		}
		return result; //Returns the inverse or the same matrix if matrix was not square
	}
	
	public boolean isSquare(){ //Returns true if matrix is square
		if (this.m == this.n){
			return true; //Matrix is square
		} else {
			return false; //Matrix is not square
		}
	}
	
	public Matrix transpose (){ //Returns the transpose of the current matrix
		Matrix result = new Matrix (this.n, this.m);
		
		for (int i = 0; i < this.n; i++){
			for (int j = 0; j < this.m; j++){
				result.mtx[i][j] = this.mtx[j][i];				
			}
		}
		return result;
	}
	
	public String toString (){//Returns string representation of matrix
		String result = this.m + "," + this.n + "\n";//Prints the rows and columns of the matrix
		
		
		for (int i = 0; i < this.m; i++){
			for (int j = 0; j < this.n; j++){
				result += this.mtx[i][j];
				if (j < 2){
					result += ", ";//Adds a comma after the matrix values in column 0 and 1
				}
			}
			result += "\n";
		}
		return result;
	}
	
	public void print (String filename){ //Creates a file and writes the matrix in it
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter (filename));
			out.write(this.toString()); //Prints out the String returned by toString
			out.flush();
			out.close(); 
		} catch (Exception ex){ //Exception handling
			System.out.println("Error");
		}
		
	}
	
	public static Matrix identity (int size){ //creates identity matrix of defined size
		Matrix iden = new Matrix (size, size);
		
		//Initializes the matrix to 0
		for (int i = 0; i < size; i ++){
			for (int j = 0; j < size; j++){
				iden.mtx[i][j] = 0;
			}		
		}
		
		//Creates identity matrix
		for (int i = 0; i < size; i++){
			iden.mtx[i][i] = 1;
		}
		
		return iden; //Returns the identity matrix
	}
	
	
}
