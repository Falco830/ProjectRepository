
public class EvenFib {

	static int evens = 2;
	
	public static void main(String[] args) {
		System.out.println(Fibo(33));
		
		System.out.println("EVENS " + evens);
	}
	
	static int Fibo(int terms) {
		int starting = 2;
		
		
		int A = 1;
		int B = 2;
		int C = A + B;
		
		while(C < terms) {
			
			C = A + B;
			A = B;
			B = C;
			//System.out.println("A: " + A + " B: " + B);
			//System.out.println("C: " + C);
			if(C%2 == 0) {
				System.out.println("EVEN " + C);
				evens += C;
			}
			
			starting++;
		}
		return C;
	}
	
	
	
}
