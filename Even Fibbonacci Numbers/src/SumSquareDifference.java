
public class SumSquareDifference {
	
	static int num = 100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Square minus Sum: " + (Sum() -Square()));
	}

	static int Square() {
		
		int total = 0;
		int A = 0;
		for(int i = 0; i <= num; i++) {
			total += i*i;
		}
		System.out.println(total);
		return total;
	}
	
	static int Sum() {
		
		int total = 0;
		int B = 0;
		for(int i = 0; i <= num; i++) {
			total += i;
		}
		total = total * total;
		System.out.println(total);
		return total;
	}
}
