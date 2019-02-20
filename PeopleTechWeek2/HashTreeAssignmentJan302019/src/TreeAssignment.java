
/*
 * Alec Michel
 * 30 January 2019
 * 
 */

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TreeAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap tm = new TreeMap();
		
		tm.put("Pikatchu", 24);
		tm.put("Charmander",13);
		tm.put("Hawlucha", 27);
		tm.put("Torterra", 40);
		tm.put("Noctowl", 35);
		tm.put("Greninja", 61);
		tm.put("Infernape", 61);
		tm.put("Sceptile", 61);
		
		addValue(tm,"Mewtwo",70);
		
		System.out.println("Value by Key: " + findValueByKey(tm,"Pikatchu"));
				
		System.out.println("Key by Value: ");
		for(String n:findKeyByValues(tm,61)) {
			if(n!= null) {
			System.out.println(n);
			}
		}
		System.out.println("Navigable Set: ");
		getNavigableSet(tm);
		
		
		TreeMap<String, Integer> nm = new TreeMap<String, Integer> (new Comparator<String>(){
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		
		System.out.println(leastKey(tm, "Greninja"));	
		System.out.println(tm);
		
	}
	
	public static TreeMap addValue(TreeMap tm, String name, int level) {
		tm.put(name, level);
		
		return tm;
	}
	
	
	public static int findValueByKey(TreeMap tm, String name) {
		int level = (int) tm.get(name);
		return level;
		
	}
	
	public static String[] findKeyByValues(TreeMap tm, int level) {
		String[] pokemonNames = new String[tm.size()];
		
		Set<Map.Entry<String, Integer>> sm = tm.entrySet();
		int pr = 0;
		Iterable itr = tm.keySet();	
		for(Map.Entry<String, Integer> me:sm) {
			int cl = (int) tm.get(me.getKey());
			if(cl == level) {
				pokemonNames[pr] = me.getKey();
				pr++;
			}
		}	
		return pokemonNames;		
	}
	
	public static NavigableSet getNavigableSet(TreeMap tm) {
		
		System.out.println(tm.descendingKeySet());
		return tm.descendingKeySet();
	}
	
	public static NavigableSet getReverse(TreeMap tm) {
		
		System.out.println(tm.descendingKeySet());
		return tm.descendingKeySet();
	}
	
	public static String leastKey(TreeMap tm, String aft) {
	
		if(tm.higherKey(aft) != null) {
			return tm.higherKey(aft).toString();
		}
		return  null;
		
	}
	
	public static TreeMap removeGreatestEntry(TreeMap tm) {
		tm.pollLastEntry();
		return tm;
	}

}