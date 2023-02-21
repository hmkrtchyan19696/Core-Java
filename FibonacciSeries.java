package Recursions;

import java.util.Random;

public class FibonacciSeries {

	private static long[] fibonacciCache;
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int n = random.nextInt(31) + 1;
		fibonacciCache = new long[n];
		
		long fibNumber = fibonacci(n);
		
		if (n == 1) {
			System.out.print(String.format("Fibonacci series up to %dst number: ", n));
			for (long x : fibonacciCache) {
					System.out.print(x + " ");					
			}
			System.out.println();
			System.out.println(String.format("So, the %dst number in fibonacci sequence is %d.", n, fibNumber));
		}
		else if (n == 2) {
			System.out.print(String.format("Fibonacci series up to %dnd number: ", n));
			for (long x : fibonacciCache) {
				System.out.print(x + " ");					
		}
			System.out.println();
			System.out.println(String.format("So,the %dnd number in fibonacci sequence is %d.", n, fibNumber));
		}
		else if (n == 3) {
			System.out.print(String.format("Fibonacci series up to %drd number: ", n));
			for (long x : fibonacciCache) {
				System.out.print(x + " ");					
		}
			System.out.println();
			System.out.println(String.format("So, the %drd number in fibonacci sequence is %d.", n, fibNumber));
		}
		else {
			System.out.print(String.format("Fibonacci series up to %dth number: ", n));
			for (long x : fibonacciCache) {
				System.out.print(x + " ");					
		}
			System.out.println();
			System.out.println(String.format("So, the %dth number in fibonacci sequence is %d.", n, fibNumber));
		}

	}

	private static long fibonacci(int n) {
		
		if (n <= 2) {
			fibonacciCache[n-1] = n-1;
			return n-1;
		}
		
		if (fibonacciCache[n-1] != 0) {
			return fibonacciCache[n-1];
		}
		
		long nthFibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2);
		fibonacciCache[n-1] = nthFibonacciNumber;
		return nthFibonacciNumber; 
	}

}
