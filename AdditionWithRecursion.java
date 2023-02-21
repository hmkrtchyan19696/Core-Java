package Recursions;

import java.util.Scanner;

public class AdditionWithRecursion {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		while (true) {

			try {
				System.out.println("Please enter an integer");
				int num = scanner.nextInt();

				if (num < 0) {
					System.out.println("The input must be an integer that is greater than or equal to zero (>=0).");
					scanner.nextLine();
					continue;
				}
				scanner.close();

				int sumOFNums = sumOfFirstNaturalNumbers(num);
				System.out.println(sumOFNums);
				break;
			} catch (Exception e) {
				System.out.println("The input must be an integer that is greater than or equal to zero (>=0).");
				scanner.nextLine();
			}

		}

	}

	private static int sumOfFirstNaturalNumbers(int n) {

		if (n <= 1) {
			return n;
		}

		return n + sumOfFirstNaturalNumbers(n - 1);
	}

}
