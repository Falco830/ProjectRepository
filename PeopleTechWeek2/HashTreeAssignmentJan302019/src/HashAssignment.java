/*
* Alec Michel
* 30 January 2019
*/

import java.util.HashMap;

public class HashAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Integer> pokedex = new HashMap<String,Integer>();
		
		pokedex.put("JigglyPuff", 23);
		pokedex.put("Lucario", 27);
		pokedex.put("Ivesaur", 24);
		
		System.out.println(pokedex.size());
		
		HashMap<String, Integer> pokedexNewGen = new HashMap<String,Integer>();
		pokedexNewGen.putAll(pokedex);
		
		pokedex.entrySet();
		
		pokedex.clone();
		
		pokedex.values();
		
		
		
	}

}
