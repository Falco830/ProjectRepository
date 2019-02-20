package the7.Problems;

import java.util.Scanner;

public class Problem2 {
	
	public static void main(String[] args) {
		
		
		Scanner Keybord = new Scanner(System.in);
		
		
		System.out.println("Number 1: ");
		int b = Keybord.nextInt();
		System.out.println("Number 2: ");
		int i = Keybord.nextInt();
		
		int bi = b * i;
		
		System.out.println("Number 1 * Number 2 = " + bi);
		
	}

}
