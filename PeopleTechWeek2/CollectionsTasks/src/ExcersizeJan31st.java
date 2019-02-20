/*
 * Alec Michel
 * 31 January 2019
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ExcersizeJan31st {
	static ArrayList<Integer> ar = new ArrayList<Integer>();
	static LinkedList<Integer> lr = new LinkedList<Integer>();
	public static void main(String[] args) {
	
		int x = 3;
		addElementX(5);
		addElementX(2);
		addElementX(4);
		addElementX(1);
		addElementX(6);
		addElementX(3);
		
		sortDescending();
		reverseArray();
		
		addElementXL(5);
		addElementXL(2);
		addElementXL(4);
		addElementXL(1);
		addElementXL(6);
		addElementXL(3); 
		reverseArrayL();
		
		System.out.println(sum());
		
		
		
	}
	
	public static ArrayList addElementX(int x) {
		
		ar.add(x);
		return ar;
	}
	
	public static ArrayList sortDescending() {
		Collections.sort(ar, Collections.reverseOrder());
		//Collections.reverseOrder();
		System.out.println(ar);
		return ar;		
	}
	
	public static ArrayList reverseArray() {
		
		Collections.reverse(ar);
		System.out.println(ar);
		return ar;		
	}
	
	public static int sizeOfArray() {
		
		return ar.size();
	}
	
	public static LinkedList addElementXL(int x) {
		
		lr.add(x);
		return lr;
	}
	
	public static LinkedList sortDescendingL() {
		Collections.sort(ar, Collections.reverseOrder());	
		//Collections.reverseOrder();
		return lr;
		
	}
	
	public static LinkedList reverseArrayL() {
		//List llr = lr;
		lr.sort(new Comparator<Integer>() {
			public int compare(Integer s1, Integer s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println(lr);
		return lr;
		
	}
	
	public static int sizeOfArrayL() {
		
		return lr.size();
	}
	
	public static LinkedList addElementLastAndFirst(int first, int last) {
		
		lr.addLast(last);
		lr.addFirst(first);
		return lr;		
	}
	
	public static int maxElement() {
		
		Collections.sort(lr, Collections.reverseOrder());
		return lr.getFirst();
	}
	public static int minElement() {
		
		Collections.sort(lr, Collections.reverseOrder());
		return lr.getLast();
	}
public static int sum() {
	int sum = 0;
	Collections.sort(lr, Collections.reverseOrder());
		for(int i = 0; i<lr.size(); i++) {
			sum += lr.get(i);
		}
		//sum = sum/lr.size();
		
		return sum;
	}
	
	
}
