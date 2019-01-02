package com.prog32758;

import javax.xml.ws.Response;

public class ChessBoard {
	
	// Generates a blank board
	public static int[][] blankBoard() {
		int[][] spaces = new int[8][8];
		
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces[i].length; j++) {
				spaces[i][j] = 0;
			}
		}
		return spaces;
	}
	
	// Properly formatted board values
	public static String displayBoardValues(int[][] board) {
		String output = "";
		for (int i=0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				output += String.format("%2d ", board[i][j]);
			}
			output += "%n";
		}
		return output;
	}
	
	// Properly formatted board values for HTML
	public static String pageDisplayBoardValues(int[][] board) {
		String output = "<table>";
		for (int i=0; i < board.length; i++) {
			output += "<tr>";
			for (int j = 0; j < board[i].length; j++) {
				output += "<td>" + board[i][j] + "</td>";
			}
			output += "</tr>";
		}
		output += "</table>";
		return output;
	}
	
	// Creating an array of move options.
	public static int[][] moveOptions(){
		// Creating move directions
		int[][] directions = new int[2][8];
		// X directions
		directions[0][0] = 2;
		directions[0][1] = 1;
		directions[0][2] = -1;
		directions[0][3] = -2;
		directions[0][4] = -2;
		directions[0][5] = -1;
		directions[0][6] = 1;
		directions[0][7] = 2;
		// Y directions
		directions[1][0] = -1;
		directions[1][1] = -2;
		directions[1][2] = -2;
		directions[1][3] = -1;
		directions[1][4] = 1;
		directions[1][5] = 2;
		directions[1][6] = 2;
		directions[1][7] = 1;
		
		return directions;
	}
	
	
}