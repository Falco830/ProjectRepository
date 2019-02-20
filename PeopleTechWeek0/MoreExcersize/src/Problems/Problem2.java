package Problems;

public class Problem2 {
	public static void main(String[] args) {
		int A[] = {-1, -2, -1, -1, -1}; 
		System.out.println("THE LOWEST VALUE IS: " + lowestPositiveInteger(A));
		int B[] = {0, 1, 3, 4, 6}; 
		System.out.println("THE LOWEST VALUE IS: " + lowestPositiveInteger(B));
		int C[] = {4, 2, 1, 1, 1}; 
		System.out.println("THE LOWEST VALUE IS: " + lowestPositiveInteger(C));
	}
	
	
	public static int lowestPositiveInteger(int[] group) {
		
		int lowerBound = group[0]-1;
		int upperBound = group[0]+1;
		int tempUpperBound = 0;
		int tempLowerBound = 0;
		int base = 0;
		boolean oneCheck = false;
		
		for(int i = 0; i < group.length; i++) {
			lowerBound=0;
			if(i == base) {
				if(group[i] < 1) {
					base = i+1;
					continue;
				}				
			lowerBound = group[i]-1;
			upperBound = group[i]+1;
		
						
			continue;
			}
			
			tempLowerBound = group[i]-1;
			tempUpperBound = group[i]+1;
			
			System.out.println("i: " + i);
			System.out.println("group: " + group[i]);
			System.out.println("lowerBoundA " + lowerBound);
			System.out.println("upperBoundA " + upperBound);
						
			if(group[i] < 0) {
				//base = i+1;
				continue;
			}
			if(group[i] == lowerBound) {				
				System.out.println("i: " + i);
				if(group[i] == 0) {
					lowerBound = 1;
					if(upperBound < 2) {
					upperBound = 2;
					}
					continue;
				}
				System.out.println("lowerBoundL: " + lowerBound);
				if(lowerBound <= 0) {
					System.out.println("lowerBoundLL: " + lowerBound);
					return upperBound;
				}								
				lowerBound--;
				
			}else if(group[i] == upperBound) {
				if(group[i] == 0) {
					lowerBound = 0;
					if(upperBound < 2) {
						upperBound = 2;
						}
					continue;
				}
				upperBound++;	
				System.out.println("lowerBoundU: " + lowerBound);
				if(lowerBound <= 0) {
					System.out.println("lowerBoundUU: " + lowerBound);
					return upperBound;
				}	
				
			}else {
				
				System.out.println("lowerBoundA " + lowerBound);
				System.out.println("upperBoundA " + upperBound);
				System.out.println("tempLowerBound " + tempLowerBound);
				System.out.println("tempUpperBound " + tempUpperBound);
				if(lowerBound > tempLowerBound) {
					if(group[i] == 0) {
						lowerBound = 0;
						if(upperBound < 2) {
							upperBound = 2;
							}
						continue;
					}
					lowerBound = tempLowerBound;
					upperBound = tempUpperBound;
					if(lowerBound <= 0) {
						System.out.println("upperBoundL: " + upperBound);
						return upperBound;
					}
					
				}
				if(upperBound < tempUpperBound) {
					if(group[i] == 0) {
						lowerBound = 0;
						if(upperBound < 2) {
							upperBound = 2;
							}
						continue;
					}
					System.out.println("tempUpperBound: " + tempUpperBound);
					lowerBound = tempLowerBound;
					upperBound = tempUpperBound;
					if(lowerBound <= 0) {
						System.out.println("upperBoundU: " + upperBound);
						return upperBound;
					}
					
				}								
			}			
		}
		System.out.println("return upperBound: " + upperBound);
		return upperBound;
		
	}
	
	
}
