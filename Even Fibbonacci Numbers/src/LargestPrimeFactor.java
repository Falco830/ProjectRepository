
import java.math.*; 
import java.math.BigInteger;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		long number = 600851475143L;
		BigInteger sum = new BigInteger("25195908475657893494027183240048398571429282126204032027777137836043662020707595556264018525880784406918290641249515082189298559149176184502808489120072844992687392807287776735971418347270261896375014971824691165077613379859095700097330459748808428401797429100642458691817195118746121515172654632282216869987549182422433637259085141865462043576798423387184774447920739934236584823824281198163815010674810451660377306056201619676256133844143603833904414952634432190114657544454178424020924616515723350778707749817125772467962926386356373289912154831438167899885040445364023527381951378636564391212010397122822120720357");
		String num = "600851475143";
		System.out.println("Sending...");
		System.out.println(primeFactor(sum));
	}
	
	
	static BigInteger primeFactor(BigInteger bigNum){
		BigInteger two = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		System.out.println("Calculating...");
		System.out.println("sqrt(bigNum)... " + sqrt(bigNum));
		BigInteger j = bigNum.divide(two);
		System.out.println("i.intValue()..." + j.intValue());
		
		for(BigInteger i = sqrt(bigNum); i.compareTo(zero) > 0; i = i.subtract(one)) {
			System.out.println("i: " + i);
			System.out.println("i.intValue() " + i.intValue());
			System.out.println("bigNum.mod(i).intValue() " + bigNum.mod(i).intValue());
			if(bigNum.mod(i).intValue() == 0) {
				//System.out.println("isAPrime " + isAPrime(i));
				if(isAPrime(i)) {
					
					System.out.println(i + " IS THE BIGGEST PRIME");
					return i;
				}				
			}
			
		}
		System.out.println("BigNumber: " + bigNum);
		return zero;
	}
	
	static boolean isAPrime(BigInteger possiblePrime) {
		BigInteger two = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		
		System.out.println("IS THIS A PRIME!? ");
		BigInteger j = new BigInteger("2");
		System.out.println("i.compareTo(possiblePrime.divide(two))... " + j.compareTo(possiblePrime.divide(two)));
		for(BigInteger i = new BigInteger("2");  i.compareTo(possiblePrime.divide(two)) < 1 /*i.intValue() <= possiblePrime.divide(two).intValue()*/; i = i.add(one)) {
			
			
			System.out.println("j: " + i);
			
			if(possiblePrime.mod(i).intValue() == 0) {
				System.out.println(possiblePrime + " IS NOT A PRIME ");
				return false;
			}
		}
		System.out.println(possiblePrime + " IS A PRIME ");
		return true;
	}
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
	
	
}
