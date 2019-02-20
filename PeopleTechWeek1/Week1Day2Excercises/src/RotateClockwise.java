
public class RotateClockwise {
	
	public static void main(String[] args) {
		int[] or =  {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
		int[] or1 = {10, 20, 30, 40, 50, 60};
		//int [] ot = RotateClockwise.roClo(or);
		//int [] ot1 = RotateClockwise.roClo(or1);
		System.out.println("A: ");
		for(int i = 0; i < or.length; i++) {
			System.out.print(or[i] + " , ");
		}
		System.out.println();
		int [] ot = RotateClockwise.roClo(or);
		for(int i = 0; i < ot.length; i++) {
			System.out.print(ot[i] + " , ");
		}
		System.out.println();
		System.out.println("B: ");
		for(int i = 0; i < or1.length; i++) {
		System.out.print(or1[i] + " , " );
		}
		int [] ot1 = RotateClockwise.roClo(or1);
		System.out.println();
		for(int i = 0; i < ot1.length; i++) {
			System.out.print(ot1[i] + " , ");
		}
	}
	
	public static int[] roClo(int[] or) {
		
		int a = 0;
		int b = 0;
		int c = b;
		int j = 0;
		int end = or.length-1;
		
		
		for(int i = 0; i < or.length; i++) {
			j = i+1;
			if(i == 0) {
				a = or[0];
				b = or[j];
				c = b;				
				or[j] = a;
			}else if(i == end) {
				or[0]= c;
			}else {	
				a = c;
				b = or[j];
				c = b;
				or[j] = a;
			}
		}
		return or;
		
	}

}
