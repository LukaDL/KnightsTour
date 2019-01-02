package com.prog32758;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class NonIntelligent extends ChessBoard {
	
	// The static non intelligent method
	public static String runGame(int runTimes, int startX, int startY) throws IOException {
		
		// Adding string that will output the web page content
		String output = "";
		
		// Creating the file write
		File file = new File("D:\\School\\LekoLukaNonIntelligentMethod.txt");
		file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        
        // The loop for the amount of times to run the non-intelligent method
		for (int trial = 1; trial <= runTimes; trial++) {
		
			// Values for current place on the board
			int currentX = startX;
			int currentY = startY;
			
			// Creating move directions
			int[][] directions;
			
			// Setting spaces to default number
			int[][] spaces = blankBoard();
			
			boolean canGo = true;
			
			int i = 0;
			
			// Run unintelligent method
			while (i < 64 && canGo) {
				i++;
				spaces[currentY][currentX] = i;
				
				// Selecting next random first move and will increment from there if the move is not possible
				int randomMove = (int)(Math.random() * 8);
				
				// Checking the location of the next move
				for (int j = 0; j < 8; j++) {
					
					// Giving the directions multidimensional array move options
					directions = moveOptions();
					
					// Trying new locations to place the knight based on move
					int newX = directions[0][randomMove%8] + currentX;
					int newY = directions[1][randomMove%8] + currentY;
					randomMove++;
					
					// Checking to see if the move is on the board
					if (newX >= 0 && newY >= 0 && newX <= 7 && newY <= 7) {
						// Checking if the space has been landed on yet
						if (spaces[newY][newX] == 0) {
							currentX = newX;
							currentY = newY;
							break;
						}
					// If after all eight directions are checked and there is no available space, the trial is over.
					} else if (j == 7) {
							canGo = false;
							break;
					}
				}
			}
			
			// The text file is written to.
			writer.println("Trial " + trial + ": The knight was able to successfully touch " + i + " squares.");
			// The HTML content is stored in a String.
			output += "Trial " + trial + ": The knight was able to successfully touch " + i + " squares.<br>";
			// If there is only one trial, then the board is also displayed in both the text file and HTML
			if (runTimes == 1) {
				writer.printf(displayBoardValues(spaces));
				output += pageDisplayBoardValues(spaces);
			}
		}
		writer.close();
		return output;
	}	
}