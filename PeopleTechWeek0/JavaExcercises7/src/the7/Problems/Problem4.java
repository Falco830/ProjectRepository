package the7.Problems;

import java.util.Scanner;

public class Problem4 {
	
	public static void main(String[] args) {
		
		Scanner Keybord = new Scanner(System.in);		
		
		System.out.println("Number 1: ");
		
		int a = Keybord.nextInt();
		
		System.out.println("Number 2: ");
		
		int b = Keybord.nextInt();
		
		System.out.println("Number 3: ");
		
		int c = Keybord.nextInt();
		
		int average = ( a + b + c)/3;
		
		System.out.println("Average: " + average);
		
		Keybord.close();
		
	}
	

}
