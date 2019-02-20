/*
 * Alec Michel
 * 31 January 2019
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import java.util.*;

public class ExcersizeSetsandStackQueue {
	static Stack cupA	= new Stack();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> hash_Set = new HashSet<Integer>(); 
		
			hash_Set.add(12); 
			hash_Set.add(17); 
	        hash_Set.add(7); 
	        hash_Set.add(8); 
	        hash_Set.add(3); 
	        hash_Set.add(20); 

	    LinkedHashSet hs = new LinkedHashSet(); 
	        
	        // add elements to the hash set 
	        hs.add(3); 
	        hs.add(1); 
	        hs.add(4); 
	        hs.add(7); 
	        hs.add(17); 
	        hs.add(5); 
	        
	        
        Iterator iterator = hs.iterator();
        System.out.println(" Common elements: ");
        while(iterator.hasNext()) {
        	int value = (int) iterator.next();
        	if(hash_Set.contains(value)) {
        		System.out.println(value);
        	}
        }	
        System.out.println("TWO STACKS, ONE QUEUE ");
        pushQueue(12);
        pushQueue(11);
        pushQueue(19);
        pushQueue(16);
        pushQueue(14);
       System.out.println("Pop: " + popQueue());
       System.out.println("Pop: " + popQueue());
       System.out.println("Pop: " + popQueue());
        
	}
	
	public static void pushQueue(int a) {		
		cupA.push(a);				
	}
	
	public static int popQueue() {
		Stack cupB = new Stack();	
		
		while(!cupA.isEmpty()) {
			cupB.push(cupA.pop());			
		}
		
		int popper = 0;
		if(!cupB.isEmpty()) {
			popper = (int) cupB.pop();
		}
		
		while(!cupB.isEmpty()) {

		cupA.push(cupB.pop());
		}
		return popper;
		
	}
	
}
