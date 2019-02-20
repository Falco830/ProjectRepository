
public class SmallestMultiple {

	public static void main(String[] args) {
		
		System.out.println("SmallMult: " + smallMult(20));
	}
	
	
	public static int smallMult(int num) {
		
		boolean sM = true;
		int bigNum = num +1;
		while(sM) {						
			for(int i = 1; i <= num; i++) {
				
				if(bigNum%i != 0) {
					break;
				}else if(i == num){
					return bigNum;
				}
			}
			bigNum++;
		}
		
		return bigNum;
	}
}
