/****************************************************************************
 *
 * Created by: Matthew lourenco
 * Created on: May 2018
 * This program finds all possible magic squares that add up to 15
 *
 * This source was used as a guide to approach the problem:
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-
 * 			permutations-of-a-given-string/
 *
 ****************************************************************************/

public class MagicSquare {
	
	public boolean isMagic(Integer[] square) {
		//Check if the inputted suqare is magic and adds up to 15
		
		if(square.length != 9) {
			return false;
		}
		
		if(square[0] + square[1] + square[2] != 15) {
			return false;
		} else if(square[3] + square[4] + square[5] != 15) {
			return false;
		} else if(square[6] + square[7] + square[8] != 15) {
			return false;
		} else if(square[0] + square[3] + square[6] != 15) {
			return false;
		} else if(square[1] + square[4] + square[7] != 15) {
			return false;
		} else if(square[2] + square[5] + square[8] != 15) {
			return false;
		} else if(square[0] + square[4] + square[8] != 15) {
			return false;
		} else if(square[2] + square[4] + square[6] != 15) {
			return false;
		} else {
			return true;
		}
	}
	
	private void printSquare(Integer[] square) {
		//Prints the square to the console
		
		if(square.length == 9) {
			System.out.println(square[0] + " " + square[1] + " " + square[2]
					+ "\n" + square[3] + " " + square[4] + " " + square[5]
					+ "\n" + square[6] + " " + square[7] + " " + square[8]
					+ "\n- - -");
		}
	}
	
	private Integer[] swap(Integer[] square, int index1, int index2) {
		//Swaps the numbers at the inputted indexes
		
		Integer tempValue = square[index1];
		square[index1] = square[index2];
		square[index2] = tempValue;
		
		return square;
	}
	
	public void mutate(Integer[] square, int startIndex, int endIndex) {
		//Mutates the square to all posibilities using recursion
		
		if(startIndex == endIndex && isMagic(square)) {
			printSquare(square);
		} else {
			for(int index = startIndex; index <= endIndex; index++) {
				
				square = swap(square, startIndex, index);
				mutate(square, startIndex + 1, endIndex);
				square = swap(square, startIndex, index);
			}
		}
	}
	
	public static void main(String[] args) {
		//run the mutate procedure
		
		MagicSquare mutator = new MagicSquare();
		mutator.mutate(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 8);
	}
}