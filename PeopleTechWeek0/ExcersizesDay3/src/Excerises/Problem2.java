/*
 * Alec Michel
 * 10/Jan/2019
 */

package Excerises;

public class Problem2 {

	public static void main(String[] args) {
		int increasingNumber = 12355889;
		System.out.println(isIncreasing(increasingNumber));
		int increasingNumber1 = 12354388;
		System.out.println(isIncreasing(increasingNumber1));
		
	}
	
	public static boolean isIncreasing(int increasingNumber){
		
		String transformer = Integer.toString(increasingNumber);
		//System.out.println("Transform A: " + transformer);
		StringBuilder strBuil = new StringBuilder(transformer);
		//System.out.println("Transform B:" + strBuil.toString());
		
		for(int i = 1; i < strBuil.length()-1; i++) {
			//System.out.println("i: " + i);
			int a = Integer.parseInt(strBuil.substring(i-1, i).toString());
			//System.out.println(a);
			int b = Integer.parseInt(strBuil.substring(i, i+1).toString());
			//System.out.println(b);
			
			if(a > b) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
}
