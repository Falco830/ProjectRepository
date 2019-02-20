/*
 * Alec Michel
 * 10/Jan/2019
 */

package Excerises;

public class Problem1 {

	public static void main(String[] args) {
		
			String word = "supercalafredgulisticexpealadotious";
			String word1 = "racecar";
			String word2 = "uoy evol I";
			System.out.println(word + "|" + reverse(word));
			System.out.println(word1 + "|" + reverse(word1));
			System.out.println(word2 + "|" + reverse(word2));
		
	}
	
	public static String reverse(String word) {
		
		StringBuffer flip = new StringBuffer(word);
		String result = flip.reverse().toString();
		return result;
		
	}
}
