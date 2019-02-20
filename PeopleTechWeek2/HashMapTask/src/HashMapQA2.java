/*
 * Alec Michel
 * 28, January 2019
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapQA2 {

	public static void main(String[] args) {
		int[] a = {1,3,3,2,1,4,3,1,4};
		int[] b = {2,2,1};
		int[] c = {1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,4,3,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,9,9};
		
		//specialNum(a);
	
		/*System.out.println("Special Number: " + hashMapVersion(a));
		System.out.println("Special Number: " + hashMapVersion(b));
		System.out.println("Special Number: " + hashMapVersion(c));
		System.out.println();
		*/
		System.out.println("Special Number: " + specialNum(a));
		System.out.println("Special Number: " + specialNum(b));
		System.out.println("Special Number: " + specialNum(c));
		
	}
	
	public static int specialNum(int[] a) {
		int specialNumber = a.length; 
		
		for(int i = 0; i < a.length-1; i++) {
			if(/*(i == a.length -2) && */specialNumber == i) {
				i++;
			}
			
			for(int j = i; j < a.length; j++) {
				if(a[i] == a[j]) {
					specialNumber = j;										
					break;
				}else if(j == a.length-1 && i == a.length-2 && a[i] != a[j]) {
					return a[j];
				}else if(j == a.length-1 && a[i] != a[j]) {
					return specialNumber = a[i];
				}				
			}
		}
		return a[a.length-1];
	}
	

	public static int hashMapVersion(int[]a) {
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		

		for(int i  = 0 ; i < a.length; i++) {
			
			if(hm.containsKey(a[i])){
				int value = hm.get(a[i]) + 1;
				hm.put(a[i], value);
			}else {
				hm.put(a[i],0);
			}
		}

		Set<Map.Entry<Integer, Integer>> mapset = hm.entrySet();
		for(Map.Entry<Integer, Integer> key: mapset) {
			if(key.getValue()  == 0) {
				//lowestValue = key.getValue();
				return key.getKey();
			}
			//System.out.println(key.getKey() + " is the youngest student of our class and she is " + key.getValue() + "years old");
		}
		/*for(Integer key: hm.keySet()) {
			System.out.println(key);
			if(key.intValue() == 0) {
				return key;
			}
		}*/
		//hm.containsValue(0);
		return 0;
	}
	
}
