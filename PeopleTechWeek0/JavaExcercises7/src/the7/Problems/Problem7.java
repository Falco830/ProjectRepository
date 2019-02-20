package the7.Problems;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {
		
		int[] array = {1, 4, 17, 7, 25, 3, 100};
		
		
		Scanner Keybord = new Scanner(System.in);		
		
		System.out.println("Number of largest elements: ");
		
		int k = Keybord.nextInt();
		
		if(k > array.length-1) {
			System.out.println("Invalid Number, Oversized ");
			return;
		}
		ArrayList largeElements = new ArrayList();
		
		//largeElements.size(a);
		int a = 0;
		int b = 0;
		int c = 0;
		
		
		for(int i = 0; i < array.length-1; i++) {
			
			for(int j = 0; j < array.length-1; j++) {
				
				if(array[j] < array[j+1]) {
					
					a = array[j];
					b = array[j+1];
					array[j] = b;
					array[j+1] = a; 
					
				}
								
			}						
						
		}
		System.out.println("Highest To ");
		for(int i = 0; i < k; i++) {
			
			System.out.println("Number " + (1+i) + " is: " + array[i]);
			
		}
		System.out.println("Lowest ");
		
		
		
	}
}
