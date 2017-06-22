/*
 	Class: Assn1_15ay3
 	Name: Andus Yu
 	Student Number: 10192081
 	Net ID: 15ay3
 	Submission Date: January 27, 2017
 	Program Desription: The program simulates the game of pig between a user and a computer. The first
 		player to score 100 points wins. The human will always have the first turn. 
 		Rules for rolling the dice are as follows:
 			- If both dice are ones, then your turn is over and your accumulated score is set to zero.
			- If one dice is one, then your turn is over and your turn score is set to zero.
			- If both dice match then you must roll again.
			- For any other dice combination, you just add the dice total to your turn score and you have the choice of rolling again.
 */

import java.util.*;
import java.math.*;

public class Assn1_15ay3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		//Constants
		final int NUM_DICE = 2;//Number of dice rolled
		final int PLAYER_TURN = 0;//Variable for player turn
		final int COMP_TURN = 1;//Variable for computer turn
		final int NUM_PLAYERS = 2;//Number of players in the game
		final String PLAYER = "Player";//String for player
		final String COMP = "Computer";//String for computer
		
		//Variable Declaration
		int dice [] = new int[NUM_DICE];//The number rolled on the dice as an array of strings
		int score [] = new int[NUM_PLAYERS];//Scores of the player and computer
		int turn_score[] = new int [1];//Turn Score as an array to be passed by reference
		boolean game_over = false;//Variable to check if the game is over
		int turn = PLAYER_TURN;//Sets the first turn to be the player's turn
		boolean roll_again = true;//Variable to see if the player wants to roll again
		char input;//Player input of y or n
		
		//Runs the game while there are no scores greater than or equal to 100
		while (game_over == false){
			turn %= NUM_PLAYERS;//Sets the turn count to the either 0 or 1
			//Checks if it is the player's or the computer's turn
			if (turn == PLAYER_TURN){//Player's turn
				System.out.println("Player's turn:");
				//Continues rolling the dice until player enters 'n' or rolls a one
				while (roll_again == true){
				roll_Dice(dice, PLAYER);
					if (dice[0] == 1 && dice[1] == 1){//If both rolled dice are 1
						roll_again = false;
						score[PLAYER_TURN] = 0;//Sets score to 0
						System.out.println("TURN OVER!");
					} else if (dice[0] == 1 || dice[1] == 1){//If one of the rolled dice are 1
						roll_again = false;
						score[PLAYER_TURN] -= turn_score[0];
						System.out.println("TURN OVER! Turn sum is zero!");
					} else if (dice[0] == dice[1]){//If the dice are the same number
						add_points(dice, turn_score);
						score[PLAYER_TURN] += dice[0] + dice[1];//Adds the rolled dice to the game score
					} else {
						add_points(dice, turn_score);
						score[PLAYER_TURN] += dice[0] + dice[1];//Adds the rolled dice to the game score
						System.out.println("Player's turn sum is: " + turn_score[0] + " and game sum is " + score[PLAYER_TURN]);
						//Prompts the user to enter y or n
						System.out.print("Roll again? (Enter 'y' or 'n'): ");
						input = sc.nextLine().charAt(0);
						
						//Checks if the player would like to roll again
						if (input == 'n'){
							roll_again = false;
						}
					}
				}
			} else {//Computer's turn
				System.out.println("Computer's turn:");
				//Rolls the dice for the computer until it rolls a one or has a turn score of over 40
				while (roll_again == true){
					roll_Dice(dice, COMP);
					if (dice[0] == 1 && dice[1] == 1){//If both rolled dice are 1
						roll_again = false;
						score[COMP_TURN] = 0;//Sets the computer's score to 0
						System.out.println("TURN OVER!");
					} else if (dice[0] == 1 || dice[1] == 1){ //If the computer rolls one 1
						roll_again = false;
						score[COMP_TURN] -= turn_score[0];
						System.out.println("TURN OVER! Turn sum is zero");
					} else if (dice[0] == dice[1]){//If the two dice rolled are the same number
						add_points(dice, turn_score);//Changes the value of the turn score
						score[COMP_TURN] += dice[0] + dice[1];//Adds the rolled dice to the game score
					} else {
						add_points(dice, turn_score);
						score[COMP_TURN] += dice[0] + dice[1];//Adds the rolled dice to the game score
						System.out.println("Computer's turn sum is: " + turn_score[0] + " and game sum is " + score[COMP_TURN]);
						
						//Computer checks if it wants to roll again
						if (score[COMP_TURN] >= 100){//At this point the computer has already won and will hold
							roll_again = false;
						} else if (turn_score[0] >= 40){
							roll_again = false;
						}
					}		
				}	
			}
			
			//Outputs the player score and computer score
			System.out.println();
			System.out.println("Player's sum is : " + score[PLAYER_TURN] + ", Computer's sum is: " + score[COMP_TURN] +".");
			System.out.println();
			
			turn++;//Increments the turn
			roll_again = true; //resets roll_again to true
			turn_score[0] = 0;
			
			//Checks if the game is over
			if (score[0] >= 100 || score[1] >= 100){
				game_over = true;
			}
		}
	}

	//Method that generates a random number between 1 and 6 and prints a statement showing what numbers 
	//were rolled for each player
	public static void roll_Dice(int dice[], String user){ 
		int roll;
		
		System.out.print(user + " rolled ");
		for (int i = 0; i < dice.length; i++){
			roll = 1 + (int)(Math.random() * 6);//Generates a random number from 1 to 6
			dice[i] = roll;//Sets the number on the dice to the rolled value
			//Prints the number rolled
			if (roll == 1){
				System.out.print("one ");
			} else if (roll == 2){
				System.out.print("two ");
			} else if (roll == 3){
				System.out.print("three ");
			} else if (roll == 4){
				System.out.print("four ");
			} else if (roll == 5){
				System.out.print("five ");
			} else {
				System.out.print("six ");
			}
			
			//Prints a plus sign
			if (i < dice.length - 1){
				System.out.print("+ ");
			}
		}
			System.out.println();
	}
	
	//Adds the points to the turn score
	public static void add_points(int dice[], int score[]){
		for (int i = 0; i < dice.length; i++){
			score[0] += dice[i];
		}
	}
}