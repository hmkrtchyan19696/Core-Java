package main.java.Mark_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	
	private static Random random = new Random();
	private static Scanner scanner = new Scanner(System.in);  
	
	public static void main(String[] args) {
		
		// generates random integer from 1 to 100 inclusive
		int randomInteger = random.nextInt(100) + 1;
		
		while (true) {
			System.out.print("Enter your guess (integer 1-100 inclusive): ");
						
			try {
				int playerGuess = scanner.nextInt();
				
				if (playerGuess < 1 || playerGuess > 100) {
					System.out.println("\nThe integer must be 1 - 100!\n");
					continue;
				}
				
				boolean condition = checkValue(playerGuess, randomInteger);
				if (condition) {
					break;
				}
				
			} catch (InputMismatchException ime) {
				System.out.println("\nYour input is not an integer.\n");
				scanner.nextLine();
			}
			
		}		
		
		scanner.close();
	}
	
	private static boolean checkValue(int playerGuess, int randomInteger) {
		boolean playerWon = false;
		
		if (playerGuess == randomInteger) {
			System.out.println(String.format("\nCongrats, you win! You have guessed the right number (%d)!!!", playerGuess));
			playerWon = true;
		} else if (playerGuess > randomInteger) { 
			System.out.println(String.format("Nope, the number is smaller than %d. Guess again.", playerGuess));
		}
		else {
			System.out.println(String.format("Nope, the number is bigger than %d. Guess again.", playerGuess));
		}
		
		return playerWon;
	}

}
