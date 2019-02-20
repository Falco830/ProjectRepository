/*
 * Alec Michel
 * 16/Jan/2019
 */
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Fibonacci fb = new Fibonacci();
		
		int b = 0;
		int c = 1;
		int d = 2;
		int e = 3;
		int f = 4;
		int a = 5; // 0 is first 1 is second 1 is third 2 is fourth etc
		
		for(int i = 0; i < 7; i++) {
			System.out.println("The Final Sum is: " + fb.sumOfFactorial(i));
		}
		
	}
	
	public int sumOfFactorial(int l) {
		
		if(l == 0) {
			System.out.print("Fib: " + 0 + ", ");
			return 1;
		}else if(l == 1) {
			System.out.print("Fib: " + 1 + ", ");
			return 1;
		}
		else if(l == 2) {
			System.out.print("Fib: " + 1 + ", ");
			return 2;
		}
		l = l-1;
		
		int m = 0; //m = m*m-1*m-2
		int i = 0;		
		int a = 0;
		int b = 1;
		int c = a + b;
		
		int facA = 0;
		int facB = 0;
		
		int fib = a + b; //first find fib numbers
		int fac = 0; //second find factorial of each number
		int sum = 0; //lastly find sum
		
		while(i < l) {
			 if( l == 1) {
				System.out.println("Fib: " + 1);
				return 1;
			}else {			
								
				fib = a + b;
				a = b;
				b = fib;
				System.out.print("Fib: " + fib + ", ");
				fac = fib;
				for(int j = 1; j < fib; j++) {
					
					if(fib == 1) {
						fac = fib;
					}else if(fib == 2) {
						fac = fib;
					}else {
						fac = fac * (fib - j);
					}					
					
				}
				sum += fac;
				fac = 0;				
				i++;
			}
		}				
		return sum + 2; //Factorial of 0 and 1 which are part of the Fibonacci sequence
	}
}
