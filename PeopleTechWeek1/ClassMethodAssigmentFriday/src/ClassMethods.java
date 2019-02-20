/*
 * Alec Michel
 * 21/Jan/2019
 * 
 */


import java.util.Collection;
import java.util.LinkedList;

class Cube{
	public Cube(int size) {
		System.out.println("This Cube is " + size + " by " + size + " by " + size);
	}
	
}
class Cuboid{
	public Cuboid(int x, int y, int z) {
		System.out.println("This Cuboid is " + x + " by " + y + " by " + z);
	}
	
}



class Radius{
	double r;
	public Radius(double area, double circumference, double diameter) {
		
		if(area != 0) {
			r = Math.sqrt(area/Math.PI);
			System.out.println("Radius is: " + r);
		}else if(circumference != 0) {
			r = circumference/(2*(Math.PI));
			System.out.println("Radius is: " + r);
		}else if(diameter != 0) {
			r = diameter/2;
			System.out.println("Radius is: " + r);
			
		}
		
		
	}
	
}

class OddNum{
	public OddNum(int num) {
		for(int i = 0; i <= num; i++ ) {
			if(i%2 != 0) {
				System.out.println("Odd Num: " + i);
			}
		}
		
	}
}
class EvenNum{
	public EvenNum(int num) {
		for(int i = 0; i <= num; i++ ) {
			if(i%2 == 0) {
				System.out.println("Even Num: " + i);
			}
		}
		
	}
	
}
class MultTable{
	public MultTable(int num) {
		int pair = 1;
		for(int i = 1; i <= num; i++ ) {
			if(num%i == 0) {
				System.out.println("Pair Num " + pair + ": " +  i + ", " + (num/i));
				pair++;
			}
				
		}
		
	}
	
}
class PrimeNum{
	public PrimeNum(int num) {
		for(int j = 2; j <= num/2; j++ ) {
			if(num%j == 0) {
				System.out.println(num + " is Not a prime number. ");
				break;
			}else if(num%j != 0 && j == (num/2)) {
				System.out.println(num + " is a prime number! ");
			}
				
		}
	}
	
}
class PrimeNums{
	int numOfPrimes;
	int amountOfPrimes = 3;
	int initialValue;
	int countValue;
	boolean foundGoal = true;
	
	LinkedList<Integer> primeHolder = new LinkedList<Integer> ();
	
	public PrimeNums(int num, boolean too) {
		int i = 1;
		int j = 1;
		primeHolder.add(1);
		primeHolder.add(2);
		primeHolder.add(3);
		
		if(too) {
			initialValue = num;
		}else {
			System.out.println("False");
			initialValue = i/2;
		}
		
		while(foundGoal) {
			while(j < initialValue) {
				//System.out.println("i%j: " + (i%j));
				if((i%j) == 0) {
					break;
				}else if(j == (i/2)) {
					//System.out.println("This ones a prime: " + i);
					primeHolder.add(i);
					amountOfPrimes++;
				}			
				j++;
			}
			if(too) {					
				if(i == num) {
					foundGoal = false;
				}					
			}else {					
				if(amountOfPrimes == num) {
					foundGoal = false;
				}
			}
			j=2;
			initialValue++;
			i++;
		}	
		//System.out.println("FOUND GOAL: " + foundGoal);
		if(too) {
			System.out.println(num + " has " + amountOfPrimes + " primes below it: ");
		}else {
			System.out.println("These are the first " + num + " primes: ");
		}
		for(Integer in: primeHolder) {
			System.out.println(in);
		}
	}
}	

class TwinPrime{
	LinkedList<LinkedList<Integer>> twinPrimes = new LinkedList<LinkedList<Integer>>();
	LinkedList<Integer> primeHolder = new LinkedList<Integer> ();
	int valA = 0;
	int valB = 0;
	public TwinPrime(int number) {
		int i = 3;
		int j = 2;
		primeHolder.add(3);
		primeHolder.add(2);
		while(i<number) {
			while(j <= (i/2)) { 
				//System.out.println("i: " + i + " j: " + j);
				//System.out.println("i%j: " + (i%j));
				if((i%j) == 0) {
					break;
				}else if(j == (i/2)) {
					//System.out.println("This ones a prime: " + i);
					
					//System.out.println(twinPrimes);
					primeHolder.set(1, i);
					//System.out.println(i + " " + primeHolder.get(0) + " " + (i - primeHolder.get(0)));

					if((i - primeHolder.get(0)) == 2) {
						System.out.println(twinPrimes);
						//primeHolder.add(i);
						//System.out.println("Twin PRIME!!!");
						//System.out.println(primeHolder);
						twinPrimes.push(primeHolder);	
						//System.out.println("Twin PRIME22!!!");
						valA = primeHolder.get(1);
						primeHolder = new LinkedList<Integer> ();
						primeHolder.add(valA);
						primeHolder.add(i);
						primeHolder
						
					}else {
					primeHolder.set(0, primeHolder.get(1));
					}
				}			
				j++;
			}
			j=2;
			i++;
		}
		System.out.println("Twin Primes: ");
		System.out.println(twinPrimes.size());
		System.out.println(twinPrimes);
		//for(int k = 0; k < twinPrimes.size(); k++) {
			//System.out.println("print ");
			//System.out.println(twinPrimes.toString());
		//}

		
	}
	
	
	
}

class Fib{
	LinkedList<Integer> fibs = new LinkedList<Integer>();
	int sequenceLevel = 3;
	int valA = 1;
	int valB = 1;
	int temp = valA + valB;
	public Fib(int sequence) {
		if(sequence == 0) {
			fibs.add(0);
			System.out.println("Fib Sequence is: ");
			for(Integer n: fibs) {
				System.out.print(n + ", ");
			}
		}else if(sequence == 1) {
			fibs.add(0);
			fibs.add(1);			
			System.out.println("Fib Sequence is: ");
			for(Integer n: fibs) {
				System.out.print(n + ", ");
			}
		}else if(sequence == 2) {
			fibs.add(0);
			fibs.add(1);
			fibs.add(1);
			System.out.println("Fib Sequence is: ");
			for(Integer n: fibs) {
				System.out.print(n + ", ");
			}
		}
		fibs.add(0);
		fibs.add(1);
		fibs.add(1);
		while(sequenceLevel < sequence) {
			
			temp = valA + valB;
			valA = valB;
			valB = temp;
			fibs.add(temp);
			sequenceLevel++;
		}
		System.out.println("The Fib Sequence of " + sequence + " is: ");
		for(Integer n: fibs) {
			System.out.print(n + ", ");
		}
		
	}
	
	
}
class Fac{
	
	LinkedList<Integer> facHolder = new LinkedList<Integer>();
	int factorial = 0;
	public Fac(int fac) {
		factorial = fac;
		System.out.println();
		if(fac == 0) {
			System.out.println("Factorial is: " + 1);
		}else if(fac == 1) {
			fac = 1 * 1;
			System.out.println("Factorial is: " + fac);
			
			
		}else if(fac == 2) {
			fac = 2 * 1 * 1;
			System.out.println("Factorial is: " + fac);
		}
		
		for(int i = 1; i < factorial; i++) {
			System.out.println("Fac: " + fac + " " + (factorial - i));
			fac = fac * (factorial - i);
		}
		System.out.println("The Factorial of " + factorial + " is: ");
			System.out.print(fac);
	}
	
}



public class ClassMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cube c = new Cube(1);
		Cuboid cb = new Cuboid(1,2,3);
		Radius rd1 = new Radius(12.57,0,0);
		Radius rd2 = new Radius(0,12.57,0);
		Radius rd3 = new Radius(0,0,12.57);
		
		OddNum od = new OddNum(5);
		OddNum od1 = new OddNum(6);
		EvenNum en = new EvenNum(5);
		EvenNum en1 = new EvenNum(6);
		
		MultTable mt = new MultTable(100);
		PrimeNum pn = new PrimeNum(11);
		PrimeNum pn1 = new PrimeNum(20);
		
		
		PrimeNums pnsA = new PrimeNums(100, true);
		PrimeNums pnsB = new PrimeNums(100, false);
		
		TwinPrime twp = new TwinPrime(100);
		
		Fib fi = new Fib(5);
		Fac fa = new Fac(6);
		
	}

}
