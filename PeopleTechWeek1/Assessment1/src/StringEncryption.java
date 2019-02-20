/*
 * Alec Michel
 * 16/Jan/2019
 */

public class StringEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(StringEncryption.encryptString("adwxyzi"));
		
		
	}

	public static String encryptString(String enc) {
		
		String newString = "";
		char cHolder;
		
		for(int i = 0; i<enc.length(); i++ ) {
			cHolder = enc.charAt(i);
			int sdsd = cHolder;
			cHolder += 9;
			if(cHolder >= 122 ) {
				
				
				
				cHolder = (char) ((cHolder - 26));
				sdsd = cHolder;
			}
			newString += Character.toString(cHolder);
		}
		
		return newString;
	}
	
}
