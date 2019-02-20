package Problems;

public class Problem2C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2, 1, 4, 0}; 
		System.out.println(lowestMissInt(A));
	
	
	}

	public static int lowestMissInt(int[] numbers)
	{
		int upperBound = numbers[0]+1;
		int lowerBound = numbers[0]-1;
		int tempUpperBound = 0;
		int tempLowerBound = 0;
		boolean oneCheck = false;
		for(int idx = 1; idx < numbers.length; idx++)
		{
			if(numbers[idx] == 1)
				oneCheck = true;
			if(numbers[idx] < 0)
				continue;
			else if(numbers[idx] == upperBound)
			{
				upperBound++;
				continue;
			}
			else if(numbers[idx] == lowerBound)
			{
				lowerBound--;
				continue;
			}
			else
			{
				tempUpperBound = numbers[idx] + 1;
				tempLowerBound = numbers[idx] - 1;
				if(upperBound > tempUpperBound)
					upperBound = tempUpperBound;
				if(lowerBound > tempLowerBound)
					lowerBound = tempLowerBound;
			}
		}
		if(oneCheck == false)
			return 1;
		if(lowerBound > 0)
			return lowerBound;
		else
			return upperBound;
	}
}
