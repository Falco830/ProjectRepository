package plant.genetic.algorithm;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class BranchNode { 
	  
    double value;
    BranchNode left, right;
    int distanceFromRoot;
    int ageOfRoot;
    String gradiantValue;
    
    
    ArrayList<BranchNode> nodes;
    
    public int x;	//current position for x
	public int y;	//current position for y
	
	 BranchNode(double evaluation, ArrayList<BranchNode> nodes, int x, int y, int ageOfRoot, String gradiantValue) {   	
        value = evaluation;
        this.ageOfRoot = ageOfRoot;
        this.nodes = nodes;
        if(this.nodes != null) {
        	allNodesAreNull(this.nodes);
        }
        this.x = x;
        this.y = y;

        this.gradiantValue = gradiantValue;
        
        distanceFromRoot = 0;
        
        left = right = null;
    } 
    BranchNode(BranchNode rootNode, double evaluation, ArrayList<BranchNode> nodes, int x, int y, int ageOfRoot, String gradiantValue) {   	
        value = evaluation;
        this.ageOfRoot = ageOfRoot;
        this.nodes = nodes;
        if(this.nodes != null) {
        	allNodesAreNull(this.nodes);
        }
        this.x = x;
        this.y = y;
        
        this.gradiantValue = gradiantValue;
        
        distanceFromRoot = findDistance(rootNode, x, y);
        
        left = right = null;
    } 
    
    public void allNodesAreNull(ArrayList<BranchNode> nodes) {
    	if(!nodes.isEmpty()) {
	    	for(BranchNode bn: nodes) {
	    		bn = null;
	    	}
    	}
    }
    public int findDistance(BranchNode root, int x, int y) 
    { 
      
        // base case 
        if (root == null) { 
            return -1; 
        } 
      
        // If the key is present at root, 
        // distance is zero 
        if ((root.x == x) && (root.y == y)) {
            return 0; 
        }
      
        // Iterating through tree using BFS 
        Queue<BranchNode> q = new LinkedList<BranchNode>(); 
      
        // pushing root to the queue 
        ((LinkedList<BranchNode>) q).push(root); 
      
        // pushing marker to the queue 
        ((LinkedList<BranchNode>) q).push(null); 
      
        // Variable to store count of level 
        int levelCount = 0;     	
        while (!q.isEmpty()) { 
        	
            BranchNode temp = q.poll();
            
            // if node is marker, push marker to queue 
            // else, push left and right (if exists) 
            if (temp == null && !q.isEmpty()) { 
                ((LinkedList<BranchNode>) q).add(null); 

                // Increment levelCount, while moving 
                // to new level 
                levelCount++; 
            }else if (temp != null) {             
                // If node at current level is Key, 
                // return levelCount 
                if (temp.x == x && temp.y == y) { 
                    return levelCount; 
                }
      
                for(int i = 0; i<temp.nodes.size(); i++){	            	
                	if (temp.nodes.get(i).x == x && temp.nodes.get(i).y == y) {
                		if(temp.nodes.get(i) != null) {
                			((LinkedList<BranchNode>) q).push(temp.nodes.get(i));
                		}
                	}
                }
            } 
        } 
      
        // If key is not found 
        return -1; 
    } 
} 

public class Seed {
	
	
	//public Node expressionTreeDNA;
	public final BranchNode rootNode;
	public static BranchNode newBranchNode;
	public BranchNode currentNode;
	public BranchNode previousNode;
	public String rootChoiceExpression;
	public String rootDirectionExpression;
	public int ageOfSeedBranch;
	
	public int initialx;
	public int initialy;
	
	private ArrayList<Line2D> lineList;
	
	public Seed(BranchNode branchNode, int initialx, int initialy, String rootChoiceExpression, String rootDirectionExpression) {
			
		this.rootChoiceExpression = rootChoiceExpression;
		this.rootDirectionExpression = rootDirectionExpression;
		this.rootNode = branchNode;
		
		this.currentNode = this.rootNode;
		this.previousNode = currentNode;
		
		this.initialx = initialx;
		this.initialy = initialy;
		
		
		lineList = new ArrayList<Line2D>();		
		this.ageOfSeedBranch = 10;
	}
	
	public void addToLineList(Line2D newLine) {
		lineList.add(newLine);
	}
	
	public ArrayList<Line2D> getLineList(){
		return lineList; 
	}
	
	public String getDirectionExpression() {
		return rootDirectionExpression;
	}
	BranchNode newBranch; 
	public void addBranch(BranchNode selectedNode, double evaluation, ArrayList<BranchNode> nodes, int x, int y, String newGradValue) {
		//ageOfSeedBranch++;
		//newBranch = new BranchNode(rootNode,evaluation,nodes,x,y,ageOfSeedBranch, newGradValue);
		//if(ageOfSeedBranch == 10)ageOfSeedBranch = 9;
		previousNode = currentNode;
		System.out.println("SELECT NODE V " + selectedNode.value);
		currentNode = selectedNode;
		//Representation2D rep2D = new Representation2D();
		
		//rep2D.leafGrowth(this, sd);
		currentNode.nodes.add(new BranchNode(rootNode,evaluation,nodes,x,y,ageOfSeedBranch, newGradValue));//newBranch);
		
		for(int i = 0; i < currentNode.nodes.size(); i++) {
			System.out.println("Branch: " + currentNode.nodes.get(i).value);
		}
		
		if(currentNode.nodes.size() > 1 && rootNode.x != selectedNode.x && selectedNode.y != y) {
			System.out.println("OVER " + currentNode.nodes.size() + " rootx: " + rootNode.x + " x " + selectedNode.x + " rooty: " + rootNode.y + " y " + selectedNode.y);
			System.out.println(currentNode.nodes.get(0));
	
		}
		newBranchNode = newBranch;

		
	}
	
	public void printLevelOrder(){ 
	        Queue<BranchNode> queue = new LinkedList<BranchNode>(); 
	        queue.add(rootNode); 
	        while (!queue.isEmpty())  
	        { 
	  
	            /* poll() removes the present head. 
	            For more information on poll() visit  
	            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
	        	BranchNode tempNode = queue.poll(); 
	            //System.out.print(tempNode.value + " "); 
	  
	            for(int i = 0; i<tempNode.nodes.size(); i++){	            	
	            	if(tempNode.nodes.get(i) != null) {
	            		queue.add(tempNode.nodes.get(i));
	            		break;
            	}
            }
        } 
    } 
	
	public void evaluateEveryRecentNode(){ 
        Queue<BranchNode> queue = new LinkedList<BranchNode>(); 
        queue.add(rootNode); 
        while (!queue.isEmpty())  
        { 
  
            /* poll() removes the present head. 
            For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
        	BranchNode tempNode = queue.poll(); 
        	//if(tempNode.ageOfRoot > 0) {
        		tempNode.value = RandomExpression.evaluate(rootChoiceExpression,this);
        	//}      	
           // System.out.println("NodeEvaluate: x" + tempNode.x + " y" + tempNode.y + " V" + tempNode.value + " "); 
            if(tempNode.nodes == null) {
            	return;
            }
            for(int i = 0; i<tempNode.nodes.size(); i++){	            	
            	if(tempNode.nodes.get(i) != null) {
            		queue.add(tempNode.nodes.get(i));
            	}
            }
        } 
	} 
	public void ageTree(){ 
        Queue<BranchNode> queue = new LinkedList<BranchNode>(); 
        queue.add(rootNode); 
        while (!queue.isEmpty())  
        { 
  
            /* poll() removes the present head. 
            For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
        	BranchNode tempNode = queue.poll(); 
        	//tempNode.value = RandomExpression.evaluate(rootChoiceExpression,this);
            //System.out.println("Node Value: " + tempNode.value + " "); 
        	if(tempNode.ageOfRoot != 0) {
        		tempNode.ageOfRoot = tempNode.ageOfRoot--;
        	}
        	
            if(tempNode.nodes == null) {
            	return;
            }
            for(int i = 0; i<tempNode.nodes.size(); i++){	            	
            	if(tempNode.nodes.get(i) != null) {
            		queue.add(tempNode.nodes.get(i));
            	}
            }
        } 
	} 
	
	public BranchNode resolveMaxNode(){
		BranchNode maxNode;
		double maxValue;
		
        Queue<BranchNode> queue = new LinkedList<BranchNode>();
        maxNode = rootNode;
        maxValue = rootNode.value;
        queue.add(rootNode); 
        while (!queue.isEmpty())  
        {
        	BranchNode tempNode = queue.poll(); 
            //System.out.print(tempNode.value + " "); 
        	
        		//tempNode.value = RandomExpression.evaluate(rootChoiceExpression,this);
        	
            if(maxValue < tempNode.value) {
            	if(tempNode.ageOfRoot > 0) {
	            	maxNode = tempNode;
	            	maxValue = tempNode.value;
            	}
            }
            if(tempNode.nodes == null) {
            	return null;
            }
            for(int i = 0; i<tempNode.nodes.size(); i++){
            	if(tempNode.nodes.get(i) != null) {
            		queue.add(tempNode.nodes.get(i));
	        	}
	        }
	    }
        System.out.println("MaxNode: x" + maxNode.x + " y" + maxNode.y + " V" + maxNode.value);
        return maxNode;
	}
}


