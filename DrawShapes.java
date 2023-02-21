package PrintingShapes;

public class DrawShapes {

	public static void main(String[] args) {
		
		printSquare(5, "#");
		
		System.out.println();
		
		printIRightTriangle(5, "$");
		
		System.out.println();
		
		printDRightTriangle(5, "*");
		
		System.out.println();
		
		printEquilaterialTriangle(5, "$");

	}

	
	private static void printSquare(int length, String param) {
		for (int i = 1; i < length + 1; i++) {
			for ( int j = 1; j < length + 1; j++) {
				System.out.print(param + " ");
			}
			System.out.println();
		}
	}
	
	private static void printIRightTriangle(int leg, String param) {
		for (int i = 1; i <= leg; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(param + " ");
			}
			
			System.out.println();
		}
	}
	
	private static void printDRightTriangle(int leg, String param) {
		for (int i = leg; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(param + " ");
			}
			System.out.println();
		}
	}
	
	private static void printEquilaterialTriangle(int size, String param) {
		for (int i = size; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= size; j++) {
				System.out.print(param + " ");
			}
			System.out.println();
		}
	}

}
