package main.java.Mark_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman{
	
	private static List<String> words = new ArrayList<>();
	private static Scanner userInput = new Scanner(System.in);
	private static Random random = new Random();
	private static HashSet<Character> playerGuesses = new HashSet<>();
	private static List<String> praises = new ArrayList<>(Arrays.asList("Correct!", "Superb!", "Outstanding!!", "Nice!",
			"That's right! Keep Going!"));
	private static int maxCorrect;
	private static int incorrect;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String word = getRandomWord();
		
		while (true) {
			printHangman();
			
			System.out.println("Lives remaining: " + (6 - incorrect));
			if (incorrect == 6) {
				System.out.println("You have lost!");
				System.out.println("The correct word was: " + word);
				break;
			}
			
			getPlayerGuess(word);	
			
			if(printWordState(word, playerGuesses)) {
				System.out.println("You Win!");
				System.out.println("The correct word was: " + word);
				break;
			}
		}
		
	}

	/**
	 * prints the Hangman
	 * for each wrong answer, additional parts of hangman will be printed
	 * for each right one, the parts will be undone.
	 */
	private static void printHangman() {
		System.out.println();
		System.out.println(" -------");
		System.out.println(" |     |");
		if (incorrect >= 1) {
			System.out.println(" O");
		}
		if (incorrect >= 2) {
			System.out.print("\\");
			if (incorrect >= 3) {
				System.out.println(" /");
			}
		}
		if (incorrect >= 4) {
			System.out.println(" |");
		}
		if (incorrect >= 5) {
			System.out.print("/");
			if (incorrect == 6) {
				System.out.println(" \\");
			}
		}
		System.out.println();
	}

	/**
	 * @return random word from list of words read from a file
	 * @throws FileNotFoundException
	 */
	private static String getRandomWord() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:/Users/hmkrt/Desktop/Programming/Java/projects/Hovo_Experiments/Hangman/Hangman_Words.txt"));
		
		while (scanner.hasNext()) {
			words.add(scanner.nextLine());
		}	
		
		String word = words.get(random.nextInt(words.size()));
		
		//System.out.println(word);
		
		return word;
	}

	/**
	 * @param word
	 * prints the filled and unfilled characters of the word
	 */
	private static void getCurrentState(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (playerGuesses.contains(word.charAt(i))) {
				System.out.print(word.charAt(i));
			}
			else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	/**
	 * @param word that the player has to guess
	 */
	private static void getPlayerGuess(String word) {
		getCurrentState(word);
		System.out.print("Please enter your guess (a letter): ");
		String letterGuess = userInput.nextLine().strip();
		playerGuesses.add(letterGuess.charAt(0));
		
	}

	/**
	 * @param word that the player has to guess
	 * @param playerGuesses2 - the list of characters that the player has guessed
	 * @return whether the player guessed the word
	 */
	private static boolean printWordState(String word, HashSet<Character> playerGuesses) {
		int correctCount = 0;
		for (int i = 0; i < word.length(); i++) {
			if (playerGuesses.contains(word.charAt(i))) {
				correctCount++;
			}
		}
		if (correctCount > maxCorrect) {
			System.out.println(praises.get(random.nextInt(praises.size())));
			maxCorrect = correctCount;
			if (incorrect > 0) {
				incorrect--;				
			}
		}
		else {
			incorrect++;
		}
		
		System.out.println("Characters used this far: " + playerGuesses);
		
		return correctCount == word.length();
	}
	

}
