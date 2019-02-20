/*
 * Alec Michel
 * 29 January 2019
 */


import java.util.*;

public class DequeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> deque = new LinkedList<String>();
		
		Queue qm = new LinkedList();

		//We can add elements to hte queue is various ways
		deque.add("Element 1 (Tail)");
		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)");
		deque.push("Element 4 (Head)");
		deque.offer("Element 5 (Tail)");
		deque.offerFirst("Element 6 (Head)");
		deque.offerLast("Element 7 (Tail)");
		
		System.out.println(deque + "\n");
		
		System.out.println("Standard Iterator");

		Iterator iterator = deque.iterator();
		
		while(iterator.hasNext()) 
			System.out.println("\t" + iterator.next());

		// Reverse order iterator  
        Iterator reverse = deque.descendingIterator();  
        System.out.println("Reverse Iterator");  
        while (reverse.hasNext())  
            System.out.println("\t" + reverse.next());  
   
        // Peek returns the head, without deleting  
        // it from the deque  
        System.out.println("Peek " + deque.peek());  
        System.out.println("After peek: " + deque);  
  
        // Pop returns the head, and removes it from  
        // the deque  
        System.out.println("Pop " + deque.pop());  
        System.out.println("After pop: " + deque);  
   
        // We can check if a specific element exists  
        // in the deque  
        System.out.println("Contains element 3: " +  
                        deque.contains("Element 3 (Tail)"));  
   
        // We can remove the first / last element.  
        deque.removeFirst();  
        deque.removeLast();  
        System.out.println("Deque after removing " +  
                            "first and last: " + deque);  
   
    }   

}
