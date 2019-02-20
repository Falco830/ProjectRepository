/*
 * Alec Michel
 * 17/Jan/2019
 */

package BigStringMain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Map;


public class BigStringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String content = "Unlike C and C++, there are no implementation-dependent aspects of the specification. The sizes of the primitive data types are specified, as is the behavior of arithmetic on them.\r\n" + 
				"\r\n" + 
				"For example, an int in Java is always a 32-bit integer. In C/C++, int can mean a 16-bit integer, a 32-bit integer, or any other size that the compiler vendor likes. The only restriction is that the int type must have at least as many bytes as a short int and cannot have more bytes than a long int.\r\n" + 
				"\r\n" + 
				"Having a fixed size for number types eliminates a major porting headache. Binary data is stored and transmitted in a fixed format, eliminating confusion about byte ordering. Strings are saved in a standard Unicode format.\r\n" + 
				"\r\n" + 
				"The libraries that are a part of the system define portable interfaces. For example, there is an abstract Window class and implementations of it for UNIX, Windows, and the Macintosh.";
		
		
		stringCharachteristics(content);
		capitalFirst(content);
		removeDuplicate(content);
		alphabeticalOrder(content);
		repeatableCharacters(content);
		
	}
	
	
	public static void stringCharachteristics(String content) {
		
		//repeated words
		String[] words = content.split("[ ,.-/]");
		
		Map<String, String> wordsMap = new HashMap<String, String>();
		Map<String, String> multipleWords = new HashMap<String, String>();
		Map<String, Integer> amountOfWords = new HashMap<String, Integer>();
		
		
		
		for(int i = 0; i < words.length; i++) {
			String lowerWord = words[i].toLowerCase();
			
			if(wordsMap.get(lowerWord) != null) {
				if(multipleWords.get(lowerWord) == null) {
					 System.out.println("Duplicated/Repeated word:"+lowerWord);
					multipleWords.put(lowerWord, lowerWord);
					amountOfWords.put(lowerWord, 2);
				}else if(amountOfWords.get(lowerWord) != null){
					int increaser = amountOfWords.get(lowerWord);
					increaser++;
					amountOfWords.replace(lowerWord, increaser);
				}
				
			}else {
				wordsMap.put(lowerWord,lowerWord);
			}
			
		}
		for(String key:amountOfWords.keySet()) {
			System.out.println("Word: " + key + " Number:  " + amountOfWords.get(key));
		}
	
		//length
		Map<Character, Character> specialChar = new HashMap<Character, Character>();
		
		System.out.println("Content length " + content.length());
		
		//special characters
		int amountOfSpecial = 0;
		for(int i = 0; i < content.length(); i++) {
			String special = content.substring(i, i+1);

			if(!special.matches("[A-z 0-9]")) {
				System.out.println("TEST: " + (specialChar.get(special.charAt(0)) == null));
				if(specialChar.get(special) == null) {
				specialChar.put(special.charAt(0),(special.charAt(0)));
				amountOfSpecial++;
				}
			}
		}
		
		for(Character map: specialChar.keySet()) {
			System.out.println("Special: " + specialChar.get(map));
		}
		System.out.println("Amount Of Special Characters: " + amountOfSpecial);
		
		//reverse of string
		StringBuilder sb = new StringBuilder(content);
		System.out.println(sb.reverse());
		
		//characters vertically
		for(int i = 0; i < content.length(); i++) {
			String special = content.substring(i, i+1);
			System.out.println(special);
		}
	}
	
	public static void capitalFirst(String content) {
		String[] words = content.split(" ");
		
		Map<String, String> wordsMap = new HashMap<String, String>();
		Map<String, String> multipleWords = new HashMap<String, String>();
		Map<String, Integer> amountOfWords = new HashMap<String, Integer>();
		
		String newContent = "";
		
		for(int i = 0; i < words.length; i++) {

			String lowerWord = words[i].toLowerCase();
					
			String capital = lowerWord.substring(0,1);
			String newWord = capital.toUpperCase() +lowerWord.substring(1,lowerWord.length());
			newContent = newContent + newWord + " ";								
		}
		System.out.println(newContent);
	}
	
	public static void removeDuplicate(String content) {
		//repeated words
		String[] words = content.split("[\n ,.-/]");
		String[] newWord = content.split("[\n \r]");
		
		System.out.println("REMOVE DUPLICATES");
		
		
		Map<String, String> wordsMap = new HashMap<String, String>();
		Map<String, String> multipleWords = new HashMap<String, String>();
		String newContent = "";
		for(int i = 0; i < newWord.length; i++) {
			System.out.println("New STuff: " + newWord[i].toLowerCase());
			String lowerWord = newWord[i].toLowerCase();
			//System.out.println(lowerWord + " " + i);
			String punctuation = "";
			if(newWord[i].length() > 1) {
				punctuation = lowerWord.substring(lowerWord.length()-1);
			}
			
			if(punctuation.matches("[.,-]")) {
				lowerWord =  newWord[i].toLowerCase().substring(0, newWord[i].length()-1);				
			}
			if(wordsMap.get(lowerWord) != null) {
				
			}else {
		
				 wordsMap.put(lowerWord,lowerWord);
				 newContent = newContent + newWord[i] + " ";
			}
			
			
		}
		/*
		for(int i = 0; i < words.length; i++) {
			String lowerWord = words[i].toLowerCase();
			System.out.println(lowerWord + " " + i);
			if(wordsMap.get(lowerWord) != null) {

				
			}else {
				 wordsMap.put(lowerWord,lowerWord);
				 newContent = newContent + words[i] + " ";
			}
			
			
		}*/
		System.out.println(newContent);
		
	}
	
	public static void alphabeticalOrder(String content) {
		
		char val = 'A';
		int num = 'A';
		
		int upperCase = 0;
		int lowerCase = 0;
		char originalValue = 0;
		System.out.println(num);
		
		ArrayList<String> alphOrCap = new ArrayList<String>();
		//ArrayList<String> alphOrLower = new ArrayList<String>();
		
		for(int i = 0; i < content.length(); i++) {
			originalValue = content.charAt(i);
			lowerCase = content.toLowerCase().charAt(i);
			int numVal = originalValue;
			
			if(lowerCase > 96) {
				alphOrCap.add(content.substring(i, i+1));
			}			
		}
		Collections.sort(alphOrCap, String.CASE_INSENSITIVE_ORDER);
		System.out.println(alphOrCap.toString());
	}
	
	public static void repeatableCharacters(String content) {
		
		Map<Character, Character> wordsMap = new HashMap<Character, Character>();
		Map<Character, Character> multipleWords = new HashMap<Character, Character>();
		Map<Character, Integer> amountOfWords = new HashMap<Character, Integer>();
		
		
		
		for(int i = 0; i < content.length(); i++) {

			char lowerWord = content.toLowerCase().charAt(i);
			
			if(wordsMap.get(lowerWord) != null) {
				if(multipleWords.get(lowerWord) == null) {
					multipleWords.put(lowerWord, lowerWord);
					amountOfWords.put(lowerWord, 2);
				}else if(amountOfWords.get(lowerWord) != null){
					int increaser = amountOfWords.get(lowerWord);
					increaser++;
					amountOfWords.replace(lowerWord, increaser);
				}
				
				
			}else {
				wordsMap.put(lowerWord,lowerWord);
			}
			
			
		}
		for(Character key:amountOfWords.keySet()) {
			System.out.println(/*"Words: " + multipleWords.toString() + */" Character: " + key + "  " + amountOfWords.get(key));
		}
	}
	

}
