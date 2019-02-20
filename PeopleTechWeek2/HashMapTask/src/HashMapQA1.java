/*
 * Alec Michel
 * 28, January 2019
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapQA1 {

	public static void main(String[] args) {
		//Student st = new Student();
		//st.StudentName
		HashMap<String,Integer> student = new HashMap<String, Integer>();
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
		
		int lowestValue = student.get("Ron");
		String currentName = "";
		//student.get("Jinny");
		Set<Map.Entry<String, Integer>> mapset = student.entrySet();
		for(Map.Entry<String, Integer> key: mapset) {
			if(key.getValue()  < lowestValue) {
				lowestValue = key.getValue();
				currentName = key.getKey();
			}
			//System.out.println(key.getKey() + " is the youngest student of our class and she is " + key.getValue() + "years old");
		}
		System.out.println(currentName + " is the youngest student of our class and she is " + lowestValue + " years old");
		System.out.println("Size: " + student.size());
		
		student.clear();
		student.put("Cedric",19);
		student.put("Percy",20);
		student.put("Wood",22);
		student.put("Marcus",21);
		student.put("Gregory",18);
		student.put("Dobby",200);
		student.put("Collin",14);
		student.put("Fred",18);
		student.put("Sussie",19);
		student.put("Katie", 18);
		mapset = student.entrySet();
		 lowestValue = student.get("Sussie");
		 currentName = "";
		//student.get("Jinny");
		 mapset = student.entrySet();
		for(Map.Entry<String, Integer> key: mapset) {
			if(key.getValue()  < lowestValue) {
				lowestValue = key.getValue();
				currentName = key.getKey();
			}
			//System.out.println(key.getKey() + " is the youngest student of our class and she is " + key.getValue() + "years old");
		}
		
		System.out.println(currentName + " is the youngest student of our class and he is " + lowestValue + " years old");

		
		for(String key: student.keySet()) {
			System.out.println(key);
		}
		
		for (Integer s : new HashSet<>(student.values())) {
		        System.out.println(s);            
		 }
		/*
		for(Integer val: student.values()) {
			System.out.println(val);
		}*/
		student.remove("Katie");		
		for(String key: student.keySet()) {
			System.out.println(key);
		}
		
	}
}
