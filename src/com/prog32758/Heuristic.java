package com.prog32758;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;

public class Heuristic extends ChessBoard {
	
	// Giving the board spaces the values for the heuristic method
	public static int[][] heuristicBoard() {
		int[][] spaces = new int[8][8];
		
		for (int i = 0; i < 8; i+=7) {
			spaces[i][0] = 2;
			spaces[i][1] = 3;
			spaces[i][2] = 4;
			spaces[i][3] = 4;
			spaces[i][4] = 4;
			spaces[i][5] = 4;
			spaces[i][6] = 3;
			spaces[i][7] = 2;
		}
		
		for (int i = 1; i < 7; i+=5) {
			spaces[i][0] = 3;
			spaces[i][1] = 4;
			spaces[i][2] = 6;
			spaces[i][3] = 6;
			spaces[i][4] = 6;
			spaces[i][5] = 6;
			spaces[i][6] = 4;
			spaces[i][7] = 3;
		}
		
		for (int i = 2; i < 6; i++) {
			spaces[i][0] = 4;
			spaces[i][1] = 6;
			spaces[i][2] = 8;
			spaces[i][3] = 8;
			spaces[i][4] = 8;
			spaces[i][5] = 8;
			spaces[i][6] = 6;
			spaces[i][7] = 4;
		}
		
		return spaces;
	}	
	
	
	// The static heuristic method
	public static String runGame(int runTimes, int startX, int startY, String path) throws IOException {
		// Adding string that will output the web page content
		String output = "";
		
		// Creating the file to write to
		
		File file = new File(path + "/LekoLukaHeuristictMethod.txt");
		file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
		        
		for (int trial = 1; trial <= runTimes; trial++) {
		
			// Values for current place on the board
			int currentX = startX;
			int currentY = startY;
			
			// Counter to display how many moves have been made
			int moves = 0;
			
			// Creating move directions
			int[][] directions = moveOptions();
			
			// Setting spaces to default number
			int[][] spaces = blankBoard();
			
			// Setting up values of the heuristic board
			int[][] heuristicBoard = heuristicBoard();
			
			boolean canGo = true;
			
			// Run heuristic method
			for (int i = 1; i < 65 && canGo; i++) {
				spaces[currentY][currentX] = i;
				
				// Selecting next random first move and will increment from there if the move is not possible
				int randomMove = (int)(Math.random() * 8);
				
				// Creating best move default value
				int bestMove = 10;
				
				// Creating best move index value
				int bestIndex = 0;
				
				// A check for individual moves
				boolean check = false;
				
				// Checking the location of the next move
				for (int j = 0; j < 8; j++) {
					
					int newX = directions[0][randomMove%8] + currentX;
					int newY = directions[1][randomMove%8] + currentY;
					
					// Check to see if the move is in bounds of the board
					if (newX >= 0 && newY >= 0 && newX <= 7 && newY <= 7) {
						
						// If the move is in bounds, check the current spaces heuristic value is less than previous one.
						// If so, it will keep the heuristic value and the index of that value. 
						if (heuristicBoard[newY][newX] < bestMove && spaces[newY][newX] == 0) {
							bestMove = heuristicBoard[newY][newX];
							bestIndex = randomMove%8;
							check = true;
						}
					}
					randomMove++;
				}
				
				// Checking to see if a move was available
				if (check) {
					moves++;
				} else {
					canGo = false;
				}
				// Moving the knight to the best spot
				currentX += directions[0][bestIndex];
				currentY += directions[1][bestIndex];
				
			}
			
			// Writing to the file and adding to the html string
			writer.println("Trial " + trial + ": The knight was able to successfully touch " + (moves+1) + " squares.");
			output += "Trial " + trial + ": The knight was able to successfully touch " + (moves+1) + " squares.<br>";
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