package Problems;

public class Problem2B {
	   	

    static int segregate (int arr[], int size) 
    { 
        int j = 0, i; 
        for(i = 0; i < size; i++) 
        { 
           if (arr[i] <= 0)   
           { 
               int temp; 
               temp = arr[i]; 
               arr[i] = arr[j]; 
               arr[j] = temp; 

               j++;   
           } 
        } 
       
        return j; 
    } 

    static int findMissingPositive(int arr[], int size) 
    { 
      int i; 

      for(i = 0; i < size; i++) 
      { 
        int x = Math.abs(arr[i]); 
        if(x - 1 < size && arr[x - 1] > 0) 
          arr[x - 1] = -arr[x - 1]; 
      } 
       
      for(i = 0; i < size; i++) 
        if (arr[i] > 0) 
          return i+1; 
       
      return size+1; 
    } 

    static int findMissing(int arr[], int size) 
    { 

       int shift = segregate (arr, size); 
       int arr2[] = new int[size-shift]; 
       int j=0; 
       for(int i=shift;i<size;i++) 
           { 
               arr2[j] = arr[i]; 
               j++; 
           }     

       return findMissingPositive(arr2, j); 
    } 

    public static void main (String[] args)  
    { 
        
    	int B[] = {-1, -2, -1, -1, 0}; 
    	int b_size = B.length;
		int C[] = {0, 1, 3, 4, 6}; 	
		int c_size = C.length;
		int D[] = {4, 2, 1, -1, 1}; 
		int d_size = D.length;
		System.out.println("THE LOWEST VALUE IS: " + findMissing(B,b_size));
		System.out.println("THE LOWEST VALUE IS: " + findMissing(C,c_size));
		System.out.println("THE LOWEST VALUE IS: " + findMissing(D,d_size));

    } 
}
