/*
 * Alec Michel
 * 29 January 2019
 */


import java.util.ArrayList;

public class ArrayListStackQueue {

	static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = {3, 5, 3, 2, 4, 1,2};
		
		int[] am = stackMimic(ar);
		
		for(int i = 0; i < am.length; i++) {
			System.out.println(am[i]);
		}
		
	}

	
	public static int[] stackMimic(int[] ar) {
		
		//give
		for(int i = 0; i <ar.length; i++) {
			System.out.println("add: " + ar[i]);
			al.add(0, ar[i]);
		}	
		
		System.out.println("size: " + al.size());
		
		int[] stackResult = new int[al.size()];
		System.out.println("length: " + stackResult.length);
		//take
		for(int i = 0; i < stackResult.length;i++) {
			//System.out.println("Get: " + al.get(0));
			stackResult[i] = (int) al.get(0);
			//al.remove(0);
			System.out.println(al.remove(0));
		}		
		System.out.println("----");
		return stackResult;		
	}
	
}
