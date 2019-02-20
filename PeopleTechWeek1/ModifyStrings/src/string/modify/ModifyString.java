/*
 * Alec Michel
 * 14/Jan/2019
 */

package string.modify;

import java.util.ArrayList;

public class ModifyString {
	
	static ModifyString ms = new ModifyString();
	
	public static void main(String[] args) {
		
		String S1 = "JAVAJAVA";
		String S2 = "VA";	
		ms.groupOfStrings(S1, S2);
		ArrayList ar = ms.groupOfStrings(S1, S2);
		
		for(int i = 0; i < ar.size(); i++) {
			System.out.println("Problem " + (i+1) + ": " + ar.get(i));
		}
		
	}
	
	public ArrayList<String> groupOfStrings(String s1, String s2) {
		
		
		ArrayList<String> ar = new ArrayList<String>();
		
		ar.add(ms.alternateReplacement(s1, s2));
		ar.add(ms.replaceLastOccurance(s1, s2));
		ar.add(ms.deleteFirstOccurance(s1, s2));
		ar.add(ms.divideAndPlace(s1, s2));
		ar.add(ms.changeSameCharToStar(s1, s2));
		
		
		return ar;
		
		
		
	}
	
	public String alternateReplacement(String s1, String s2) {
		
		String s3 = "";
		
		for(int i = 0; i < s1.length(); i++) {
			if(i%2 == 0) {
				s3 = s3 + s2;
			}else {
				s3 = s3 + s1.charAt(i);
				
			}
			
		}				
		return s3;
	}
	
	public String replaceLastOccurance(String s1, String s2) {
		
		String s3 = "";
		for(int i = (s1.length()-1) - (s2.length()-1); i>0; i--) {
			if(s1.substring(i, (i+s2.length())).equals(s2)) {
				StringBuilder sb = new StringBuilder(s2);
				s3 = s1.substring(0,i) + sb.reverse();
				//System.out.println(s3);
				return s3;
			}
		}
		if(s3.equals("")) {
			return s1 + s2;
		}else {
			return s3;
		}
		
	}
	
	public String deleteFirstOccurance(String s1, String s2) {
		
		String s3 = "";
		int greaterThan = 0;
		for(int i = 0; i<(s1.length() - (s2.length()-1)) ; i++) {
	
			if(s1.substring(i, (i+s2.length())).equals(s2)) {
				greaterThan++;
				if(greaterThan != 2) {
					s3 = s1.substring(0,i) + s1.substring((i+s2.length()), s1.length());
				}
			}
		}
		if(greaterThan == 2) {
			return s3;
		}else {
			return s1;
		}
		
	}		
	
	public String divideAndPlace(String s1, String s2) {
		String s3 = "";
		String ls2 = "";
		String rs2 = "";
		int half = s2.length()/2;
		
		if(s2.length()%2 == 0) {
			s3 = s2.substring(0, half) + s1 + s2.substring(half,s2.length());
		}else {
			s3 = s2.substring(0, half+1) + s1 + s2.substring(half+1,s2.length());
		}
			
			
		return s3;

		
		
		
	}
	
	public String changeSameCharToStar(String s1, String s2) {
		
		String s3 = "";
		String s4 = "";
		String s5 = "";
		
		String radix = "[";
		for(int i = 0; i < s2.length(); i++) {
			radix += s2.substring(i, i+1);
		}
		radix += "]";
		s5 = s1.replaceAll(radix, "*");

		return s5;
		
	}
	
	
}
