import java.util.List;
import java.util.*;



// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Destination {
    
    public static void main(String args[]){
    List<List<Integer>> allLocations = new ArrayList<>();
    List<List<Integer>> allBLocations = new ArrayList<>();
    
    List<Integer> locA = new ArrayList<>();
    locA.add(1);
    locA.add(-3);
     List<Integer> locB = new ArrayList<>();
    locB.add(1);
    locB.add(2);
     List<Integer> locC = new ArrayList<>();
    locC.add(3);
    locC.add(4);
    
    allLocations.add(locA);                   //[1,-3],[1,2],[3,4]
    allLocations.add(locB);
    allLocations.add(locC);
    System.out.println(allLocations);
    
    List<Integer> locAA = new ArrayList<>();
    locAA.add(3);
    locAA.add(-4);
     List<Integer> locBB = new ArrayList<>();
    locBB.add(2);
    locBB.add(4);
     List<Integer> locCC = new ArrayList<>();
    locCC.add(5);
    locCC.add(6);
    List<Integer> locD = new ArrayList<>();
    locD.add(-3);
    locD.add(8);
     List<Integer> locE = new ArrayList<>();
    locE.add(2);
    locE.add(7);
     List<Integer> locF = new ArrayList<>();
    locF.add(3);
    locF.add(-6);
    
    allBLocations.add(locAA);                   
    allBLocations.add(locBB);
    allBLocations.add(locCC);
    allBLocations.add(locD);                   
    allBLocations.add(locE);
    allBLocations.add(locF);
    System.out.println(allBLocations);
    
    System.out.println("Solution 1: " + ClosestXdestinations(3, allLocations,1));
    System.out.println("Solution 2: " + ClosestXdestinations(6, allBLocations,3));
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> ClosestXdestinations(int numDestinations, 
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
	{
	    List<List<Integer>> closestDestinations = new ArrayList<>();
	    
        // WRITE YOUR CODE HERE
        
        for(int i = 0; i<numDestinations; i++){
            for(int j = i+1; j<numDestinations; j++){
                if(Distance(allLocations.get(i).get(0), 
                allLocations.get(i).get(1)) > Distance(allLocations.get(j).get(0),
                allLocations.get(j).get(1))){
                    Collections.swap(allLocations, i, j);
                }
            }
        }
        
        for(int i = 0; i < numDeliveries; i++){
            
            closestDestinations.add(allLocations.get(i));
        }
       return closestDestinations;
	}
	
	static double Distance(int A, int B){
	    double C = Math.sqrt((A*A)+(B*B));
	   // Logging to confirm solution
	   // System.out.println("A is: " + A +" B is: " + B);
	   // System.out.println("C is: " + C);
	    return C;
	}
}

