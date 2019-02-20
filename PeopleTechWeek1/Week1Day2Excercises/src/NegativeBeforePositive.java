
public class NegativeBeforePositive {

	public static void main(String[] args) {
		
		
		int[] or =  {-4, 8, 6, -5, 6, -2, 1, 2, 3, -11};
		for(int i = 0; i < or.length; i++) {
			System.out.print(NegativeBeforePositive.neBePo(or)[i] + " , ");
		}

	}
	
	public static int[] neBePo(int[] or) {
		int a = 0;
		int b = 0;
		int j = 0;
		
		for(int i = 0; i < or.length; i++) {
			if(or[i] < 0) {
				 a = or[i];
				 b = or[j];
				 or[i] = b;
				 or[j] = a;
				j++;							
			}
		}
		return or;
	}
	
	
	
}

