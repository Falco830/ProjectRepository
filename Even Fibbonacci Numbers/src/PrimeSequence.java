
public class PrimeSequence {
	public static void main(String[] args) {
		
		System.out.println("PrimeNum: " + primeNum(10001));
	}
	
	
	static int primeNum(int pm) {
		
		int num = 3;
		int primeNum = 2;
		boolean foundPM = false;
		while(!foundPM) {			
				
			for(int i = 2; i <= num/2; i++) {	
				
				if(num%i == 0) {
					System.out.println("NUM: " + num);
					//System.out.println("NUM: " + num + " Break: " + i);
					break;
				}else if(i == num/2 && num%i != 0){
					System.out.println("Found PM! " + num + " PRIME NUMBERS: " + primeNum);
					primeNum++;
					if(primeNum == pm) {
						return num;
						}
				}else {
						//System.out.println("BREAK" + num);
						
				}
			}
			num++;
			num++;
		}
		return 0;
	}

}
