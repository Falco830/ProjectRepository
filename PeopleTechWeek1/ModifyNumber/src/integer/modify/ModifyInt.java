/*
 * Alec Michel
 * 15/Jan/2019
 */


package integer.modify;

public class ModifyInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int input = 45862;
		System.out.println("a: " + input + " is: " + transformDifference(input));
		int input1 = 233249165;
		System.out.println("b: " + input1 + " is: " + transformDifference(input1));
		
	}
	
	public static int transformDifference(int number) {
		
		int output = 0;
		StringBuffer tracker = new StringBuffer();
		   
		String intToString = Integer.toString(number);
		for(int i = 0; i < intToString.length(); i++) {
			int a = (int) Character.getNumericValue(intToString.charAt(i));
			char c = intToString.charAt(i);
			//System.out.println(i + " : " + " c " + " : " + c + " : "+ a);
			if(i+1 == intToString.length()) {
				//System.out.println("Brea king: ");
				tracker.append(a);
				break;
			}
			int b = (int) Character.getNumericValue(intToString.charAt(i+1));
			if(a > b) {
				tracker.append(a-b);
			}else {
				tracker.append(b-a);
			}
			
		}
		output = Integer.parseInt(tracker.toString());
		
		
		
		return output;
	}

}
