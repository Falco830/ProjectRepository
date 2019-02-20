package Problems;

import java.util.ArrayList;

public class Problem1 {
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 2, 3, 4, 5};
		int[] numbers1= {3,2,1};
		int[] solution = arrayMult(numbers);
		int[] solution1 = arrayMult(numbers1);
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("Solutions1: " + solution[i]);
		}
		for(int i = 0; i < numbers1.length; i++) {
			System.out.println("Solutions2: " + solution1[i]);
		}
		
	}

	
	public static int[] arrayMult(int[] first) {
		
		int[] second = new int[first.length];
		int multiplyer = 1;
		
		for(int i = 0; i < first.length; i++) {
			for(int j = 0; j < first.length; j++) {
						
				if(j == i) {
					continue;
				}
				multiplyer = first[j] * multiplyer;
			}
			second[i] = multiplyer;
			multiplyer = 1;
		}	
		return second;
	}
	
	
	
}
