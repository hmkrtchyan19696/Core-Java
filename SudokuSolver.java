package main.java.Mark_1;

import main.java.base.Base;

public class SudokuSolver extends Base{
	
	private static int GRID_SIZE = 9;
	
	
	public static void main(String[] args) {
		
		int[][] sudokuBoard = {
				{0, 1, 0, 3, 0, 0, 2, 6, 0},
				{0, 6, 0, 0, 0, 9, 0, 0, 0},
				{0, 0, 0, 5, 0, 0, 0, 7, 0},
				{0, 0, 7, 0, 0, 0, 0, 0, 4},
				{0, 0, 0, 0, 4, 0, 0, 1, 0},
				{0, 8, 0, 0, 0, 6, 3, 0, 0},
				{0, 0, 0, 0, 0, 0, 7, 2, 0},
				{0, 3, 0, 0, 5, 0, 0, 0, 0},
				{0, 0, 2, 9, 0, 0, 0, 0, 5},
				};
		
		System.out.println("Before\n ");
		print2DArray(sudokuBoard);
		
		System.out.println();
		
		if (solve(sudokuBoard) && isSolved(sudokuBoard)) {
			System.out.println("Solved Successfully\n");
			print2DArray(sudokuBoard);
		}
		else {
			System.out.println("Cannot solve the board.");
		}
		
		
	}
	
	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[row][i] == number) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (board[i][column] == number) {
				return true;
			}
		}
		
		return false;
	}
	
	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row - row % 3;
		int localBoxColumn = column - column % 3;
		
		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for (int j = localBoxColumn; j < localBoxColumn + 3; j++) {
				if (board[i][j] == number) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean isValidMove(int[][] board, int number, int row, int column) {
		return !isNumberInBox(board, number, row, column) &&
				!isNumberInRow(board, number, row) &&
				!isNumberInColumn(board, number, column);
	}
	
	
	
	private static boolean solve(int[][] board) {
		for (int r = 0; r < GRID_SIZE; r++) {
			for (int c = 0; c < GRID_SIZE; c++) {
				if (board[r][c] == 0) {
					for (int x = 1; x <= GRID_SIZE; x++) {
						if (isValidMove(board, x, r, c)) {
							board[r][c] = x;
							
							if (solve(board)) {
								return true;
							}
							else {
								board[r][c] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isSolved (int[][] board) {
		for (int i = 0; i < GRID_SIZE; i++) {
			int rowSum = 0;
			for (int j = 0; j < GRID_SIZE; j++) {
				rowSum += board[i][j];
			}
			if (rowSum != 45) {
				return false;
			}
		}
		return true;
	}

}
