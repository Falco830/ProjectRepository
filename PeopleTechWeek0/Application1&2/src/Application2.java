/**
 * Alec Michel
 * 9/Jan/2019
 */


import java.util.HashMap;
import java.util.Map;

public class Application2 {

	public static void main(String[] args) {
		
		HashMap<Integer, Integer> students = new HashMap<Integer,Integer>();	
		
		for(int i = 1; i <= 100; i++) {
			students.put(i, (int) (Math.random() * 100));
			
		}
		System.out.println(students.toString());
		Application2 app2 = new Application2();
		
		System.out.println(app2.Medals(students).toString());
		
		
		
	}
	
	
	public HashMap<Integer, String> Medals(HashMap<Integer, Integer> students) {
		HashMap<Integer, String> elegibleStudents = new HashMap();
		String Medal = "No Medal";
		for(Map.Entry<Integer, Integer> entry : students.entrySet()) {
		

			int Marks = entry.getValue();
			
			if(Marks >= 90) {
				//System.out.println("Gold Medal");
				Medal = "Gold Medal";
				
			}else if(Marks >= 80 ) {
				//System.out.println("Silver Medal");
				Medal = "Silver Medal";
				
			}else if(Marks >= 70) {
				//System.out.println("Bronze Medal");
				Medal = "Bronze Medal";
			}
			elegibleStudents.put(entry.getKey(), Medal);
		}
		
		return elegibleStudents;
		
	}

}

