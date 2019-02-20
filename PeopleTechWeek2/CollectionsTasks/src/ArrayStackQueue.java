/*
 * Alec Michel
 * 29 January 2019
 */


import java.util.Queue;

public class ArrayStackQueue {
	static int[] arrayS = new int[10];
	static int[] arrayQ = new int[10];
	
	ArrayStackQueue() {
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Queue qsample = new Queue();
		//qsample.
		
		for(int i = 0; i < arrayS.length; i++) {
			arrayS[i] = -1;
		}	
		for(int i = 0; i < arrayQ.length; i++) {
			arrayQ[i] = -1;
		}	
		
		//arrayS[0] =  -1;
		//System.out.println(arrayS[0]);
		
		
		//System.out.println(arrayS[1]);
		int element = 5;
		stackPush(element);
		stackPush(3);
		stackPush(4);
		stackPush(2);
		System.out.println(stackPop());
		System.out.println(stackPop());
		System.out.println(stackPop());
	
		int elementq = 3;
		queueAdd(elementq);
		queueAdd(6);
		queueAdd(8);
		queueAdd(9);
		System.out.println(queueRemove());
		System.out.println(queueRemove());
		System.out.println(queueRemove());
		System.out.println(queueRemove());
		
	}
	
	public static int[] stackPush(int element) {
		if(arrayS[arrayS.length-1] != -1) {
			int[] biggerArray = new int[arrayS.length];
			System.out.println("Array Old size: " + arrayS.length);
			biggerArray = arrayS;
			arrayS = new int[arrayS.length*2];
			arrayS = biggerArray;
			System.out.println("Array New size: " + arrayS.length);
		}
		for(int i = 0; i<arrayS.length; i++) {
			if(arrayS[i] == -1) {				
				arrayS[i] = element;
				break;
			}
		}
		return arrayS;		
	}
	
	public static int stackPop() {
		
		for(int i = 0; i < arrayS.length; i++) {
			if(arrayS[i] == -1) {
				int result = arrayS[i-1];
				arrayS[i-1] = -1;
				return result;
			}
			if((arrayS.length-1) == i) {
				int result = arrayS[i-1];
				arrayS[i] = -1;
				return result;
			}
		}
		return -1;
	}
	public static int[] queueAdd(int element) {
		if(arrayQ[arrayQ.length-1] != -1) {
			int[] biggerArray = new int[arrayQ.length];
			System.out.println("Array Old size: " + arrayQ.length);
			biggerArray = arrayQ;
			arrayQ = new int[arrayQ.length*2];
			arrayQ = biggerArray;
			System.out.println("Array New size: " + arrayQ.length);
		}
		
		for(int i = 0; i<arrayQ.length; i++) {
			if(arrayQ[i] == -1) {				
				arrayQ[i] = element;
				break;
			}
		}
		return arrayQ;		
	}
	
	public static int queueRemove() {
		
		for(int i = 0; i < arrayQ.length; i++) {
			if(arrayQ[i] != -1) {
				int result = arrayQ[i];
				arrayQ[i] = -1;
				return result;
			}
			if((arrayQ.length-1) == i) {
				int result = arrayQ[i];
				arrayQ[i] = -1;
				return result;
			}
		}
		return -1;
	}
}
