/*
 * Alec Michel
 * 28, January 2019
 */

import java.util.*;

public class TreeMapdDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap student = new TreeMap();
		student.put("Harry",16);
		student.put("Ron",17);
		student.put("Hermione",17);
		student.put("Neville",16);
		student.put("Luna",17);
		student.put("Draco",17);
		student.put("George",18);
		student.put("Fred",18);
		student.put("Jinny",15);
		student.put("Katie", 18);

		Set set = student.entrySet();
		
		Iterator i = set.iterator();
		String currentName = "";
		Set<Map.Entry<String, Integer>> mapset = student.entrySet();
	
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.println(me.getKey() + ".");
			System.out.println(me.getValue());
		}
		System.out.println();
		
		int age = ((Integer)student.get("Jinny")).intValue();
		student.put("Jinny", (age+3));
		System.out.println("Jinny's new age: " + student.get("Jinny"));
		
		
		TreeMap<Integer, String> students = new TreeMap<Integer, String> (new Comparator<Integer>(){
			public int compare(Integer s1, Integer s2) {
				return s2.compareTo(s1);
			}
		});
		students.put(18,"George");
		students.put(18,"Fred");
		students.put(15,"Jinny");
		students.put(18,"Katie");
		System.out.println(students);
		
		
	}

}
