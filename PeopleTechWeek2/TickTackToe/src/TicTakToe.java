/*
 * Alec Michel
 * 29 January 2019
 */


import java.util.Scanner;

public class TicTakToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] placement;
		System.out.println(ticTacToeGrid());
	}
	
	public static String ticTacToeGrid(/*char[][] grid*/) {
		Scanner input = new Scanner(System.in);
		int x = 0;
		int o = 0;
		char[][] grid = new char[3][3];
		System.out.println(" ul|uc|ur"
				+ "\n ml|mc|mr"
				+ "\n bl|bc|br");
		for(int i = 0; i < 9; i++) {
			System.out.println("Players turn: ");
			
			System.out.println(grid[0][0] + "|" + grid[1][0] + "|" + grid[2][0]
					 /*"\n" +"_____________"*/
					+ "\n" + grid[0][1] + "|" + grid[1][1] + "|" + grid[2][1]
					 /*"\n" +"_____________"*/
					+ "\n"  + grid[0][2] + "|" + grid[1][2] + "|" + grid[2][2]);				
						
			String placement = input.nextLine();
			if(i%2 == 0) {
				grid = ticTacToe(grid, placement,'x');
				
				
			}else {
				grid = ticTacToe(grid, placement,'o');
			}

		
			if('x' >= 3) { //start checking
				if(checkWinner(grid)) {
					return "Winner!";
				}
			}
		}
		System.out.println(grid[0][0] + "|" + grid[1][0] + "|" + grid[2][0]
				 /*"\n" +"_____________"*/
				+ "\n" + grid[0][1] + "|" + grid[1][1] + "|" + grid[2][1]
				 /*"\n" +"_____________"*/
				+ "\n"  + grid[0][2] + "|" + grid[1][2] + "|" + grid[2][2]);	
		
		return "Cats Game";
	}
	
	public static boolean checkWinner(char[][] grid) {
		//check rows
		for(int i = 0; i < grid.length; i++) {			
			for(int j = 0; j < grid.length-1; j++) {
				System.out.println("i "+ i + " j " + j);
				if(grid[i][j] != grid[i][j+1] && (grid[i][j] != 'x' || grid[i][j] != 'o')) {
					System.out.println("broken ");
					break;
				}else if (j == grid.length - 2 && (grid[i][j] == 'x' || grid[i][j] == 'o')){
					System.out.println("trued ");
					return true;
				}				
			}			
		}
		System.out.println("checked rows ");
		//check columns
		for(int i = 0; i < grid.length; i++) {			
			for(int j = 0; j < grid.length-1; j++) {
				if(grid[j][i] != grid[j+1][i] && (grid[j][i] != 'x' || grid[j][i] != 'o')) {
					break;
				}else if (j == grid.length - 2 && (grid[j][i] == 'x' || grid[j][i] == 'o')){
					return true;
				}				
			}			
		}
		System.out.println("checked columns ");
		//check diaganols 
		char firstValue = grid[0][0];
		for(int i = 0; i < grid.length; i++) {			
			for(int j = 0; j < grid.length; j++) {
				if(i == j) {					
					if(grid[i][j] != grid[i][j] && (grid[i][j] != 'x' || grid[i][j] != 'o')) {
						break;
					}else if (firstValue == grid[i][j]){
						firstValue = grid[i][j];
						if(j == grid.length-1  && (grid[j][i] == 'x' || grid[j][i] == 'o')) {
						return true;
						}
					}		
				}
			}			
		}	
		System.out.println("checked diaganols ");
		return false;
	}
	
	
	public static char[][] ticTacToe(char[][] grid, String placement, char player){
		
		//char[][] grid = new char[3][3];
		
		switch(placement) {
		
		case "ul":
			grid[0][0] = player;
			return grid;
		case "uc":
			grid[1][0] = player;
			return grid;
		case "ur":
			grid[2][0] = player;
			return grid;
		case "ml":
			grid[0][1] = player;
			return grid;
		case "mc":
			grid[1][1] = player;
			return grid;
		case "mr":
			grid[2][1] = player;
			return grid;
		case "bl":
			grid[0][2] = player;
			return grid;
		case "bc":
			grid[1][2] = player;
			return grid;
		case "br":		
			grid[2][2] = player;
			return grid;	
			default:
				return grid;
		}
	}
	
	
}
