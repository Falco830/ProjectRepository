
import java.math.*; 


public class LargestPalindrome {

	public static void main(String[] args) {
		
		
		
		
		System.out.println("LARGEST PALINDROME with x-digit numbers: " + LargestPalindromeDigit(4));
	}
	
	public static int LargestPalindromeDigit(int digits) {
		
		
		int numA = (int) (Math.pow(10, digits)) - 1;
		int numB = (int) (Math.pow(10, digits)) - 1;
		int prod;
		
		int largestPal = 0;
		int bigA = 0;
		int bigB = 0;
				
		System.out.println("numA: " + numA);
		System.out.println("numA: " + numB);
		
		System.out.println("numA - Math.sqrt(numA) " + (numA - Math.sqrt(numA)));
		System.out.println("numB - Math.sqrt(numB)" + (numB - Math.sqrt(numB)));
		
		for(int i = numA; i > (numA - (numA/2)); i-- ) {
			for(int j = numB; j > (numB - (numB/2)); j-- ) {
				System.out.println("A: " + i + " B: " + j);
				prod = i * j;
				System.out.println("PROD: " + prod);
				if(isPalindrome(prod)) {
					System.out.println("A: " + i + " B: " + j);
					if(largestPal < prod) {
						largestPal = prod;
						 bigA = i;
						 bigB = j;
					}					
				}				
			}
		}
		
		System.out.println("numA - Math.sqrt(numA) " + (numA - Math.sqrt(numA)));
		System.out.println("numB - Math.sqrt(numB)" + (numB - Math.sqrt(numB)));
		System.out.println("BIG A: " + bigA + " BIG B: " + bigB);
		return largestPal;
	}
	
	
	public static boolean isPalindrome(int num){
		
		String SNum = Integer.toString(num);
		
		for(int i = 0; i < SNum.length()/2; i++) {
			
			if(SNum.charAt(i) == SNum.charAt(SNum.length()-i - 1)) {
				System.out.println("A: " + SNum.charAt(i)+ " == " + " B: " + SNum.charAt(SNum.length()-i - 1));
				
			}else {
				return false;
			}
			
		}
		
		
		return true;
	}
}
