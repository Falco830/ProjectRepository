/**
 * Alec Michel
 * 9/Jan/2019
 */

public class Application1 {

	public static void main(String[] args) {
		
		
		Application1 ap1 = new Application1();
		
		System.out.println(ap1.PowerOfTwo(8));
		System.out.println(ap1.PowerOfTwo(6));
		System.out.println(ap1.PowerOfTwo(4));
		
	}
	
	
	
	
	public boolean PowerOfTwo(int num) {
		
		int val = 1;
		while(num > val) {
			val = val * 2;
			if(num == val) {
				return true;
			}
		}
		if(val == 1)
		{
			return true;			
		}
		return false;
		
		
	}
	
}
