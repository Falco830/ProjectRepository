package the7.Problems;

import java.util.Scanner;

public class Problem3 {

	
	public static void main(String[] args) {		
		
		Scanner Keybord = new Scanner(System.in);		
		
		System.out.println("Number to be multiplied: ");
		
		int b = Keybord.nextInt();
		
		for(int i = 1; i <= 10; i++) {
			
			int bi = b * i;
			
			System.out.println(b + "x" + i + "=" + bi);
			
			
			
		}
		
	}
}
