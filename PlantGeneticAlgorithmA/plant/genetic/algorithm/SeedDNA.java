package plant.genetic.algorithm;

import java.awt.Point;
import java.util.ArrayList;

public class SeedDNA {
	BranchNode currentBranchNode;
	int nextx;
	int nexty;
	
	//ON FIRST CREATION
		//Generate Random depth of expression tree for each seed 1-3;
		//Generate Random operations for each expression in Tree;
		//-------- THIS IS WRONG NODES ARE DETERMINED BY DIRECTION Generate Random amount of branches 1-3 for each seed;
		//LOCATION IS PREDEFINED
		
	public Seed seedCreation(int initialx, int initialy, Representation2D rep) {		
		//int randomSeedNodes = (int) (Math.random() * 3);
		int randomDepth = (int) (Math.random() * 3);
		//ExpressionTree expressionTree = new ExpressionTree();
		String randomChoiceDNA = RandomExpression.getRandomExpression(randomDepth);
		String randomDirectionDNA = RandomExpression.getRandomExpression(randomDepth);
		
		//char[] treeDNA = randomChoiceDNA.toCharArray();
		 ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
		 String gradKey = findWidthGrad(initialx, rep) + ", " + findHeightGrad(initialy, rep);
		BranchNode bn = new BranchNode(0,arb,initialx,initialy,10, gradKey);
		
		Seed seed = new Seed(bn,initialx,initialy,randomChoiceDNA,randomDirectionDNA);
		return seed;
						
	}
	
	//ON ACTIVATION
		//Compare each tree leaf with other tree leaves to determine order
		//in which each leaf should activate;
		//Next perform expression tree to determine direction, speed and behavior	
		//to which branch should travel;
	
	
	public void seedGrowth(int seedNum, Seed seed, Representation2D rep) {
		//direction, constant distance //speed
		//Find Maximum Tree Node
		seed.evaluateEveryRecentNode();
		currentBranchNode = seed.resolveMaxNode();
		seed.currentNode = currentBranchNode;
		//seed.currentNode.y = currentBranchNode.y;
		System.out.println("Branch Value " + currentBranchNode.value + " Branch X: " + currentBranchNode.x + " Branch Y: " + currentBranchNode.y);
		double direction = Math.toDegrees(RandomExpression.evaluate(seed.getDirectionExpression(), seed));
		System.out.println("Direction Value: " + direction);
		//System.out.println("Math Cos " + (5*Math.cos(direction)));
		//System.out.println("Math Sin " + (5*Math.sin(direction)));
		//CONSTANT DISTANCE;
		//int distance = 5;
		double nan = 0;
		if(String.valueOf(direction+"").equals("NaN") || String.valueOf(direction+"").equals("Infinity")) {
			nan = Double.valueOf(direction+"");
			System.out.println("Is an NaN " + nan);
			direction = 5;
		}
		System.out.println("Is not an NaN " + Double.valueOf(direction+""));
		int x = (int) (Math.round(seed.currentNode.x+(30*Math.cos(direction))));
		int y = (int) (Math.round(seed.currentNode.y+(30*Math.sin(direction))));
		
		nextx = x;
		
		nexty = y;
		
		String gradKey = findWidthGrad(nextx, rep) + ", " + findHeightGrad(nexty, rep);
		boolean notSameGrad = false;
		for(int i = 0; i < seed.currentNode.nodes.size(); i++) {
			System.out.println(seed.currentNode.nodes.get(i).gradiantValue);
			if(seed.currentNode.nodes.get(i).gradiantValue.equals(gradKey)) {
				notSameGrad = true;
				//System.out.println("SAME PARENT BRANCH HAS A CHILD BRANCH IN SAME GRID SECTOR ");
				//System.exit(0);
				break;
			}
		}
		
		//Check if breaks law
		System.out.println("SEED NUM: " + seedNum + " current pos: " + seed.currentNode.x + ", " + seed.currentNode.y + " next pos: " + nextx + ", " + nexty);
		PeetreeLaws pl = new PeetreeLaws(seed.currentNode.x, seed.currentNode.y, nextx, nexty);
		boolean breakLaw = pl.breaksLaw(rep);
		if(breakLaw || notSameGrad || !Representation2D.gradiant.containsKey(gradKey)) {
			System.out.println("Broke Law");
			System.out.println("Break Law? " + breakLaw );
			System.out.println("Same Grad? " + notSameGrad);
		
		}else {	
			 ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
			//System.out.println("CurrentX " + seed.currentNode.x + " CurrentY " + seed.currentNode.y);
			//System.out.println(/*"CurrentBranch " + currentBranchNode + */" nx: " + nextx + " ny: " + nexty);
			seed.addBranch(currentBranchNode, 0, arb, nextx, nexty,gradKey);
			
			//rep.gradiant.put(key, value)
			System.out.println("gradKey: " + gradKey);
			System.out.println("exists: " + Representation2D.gradiant.containsKey(gradKey));
			//if(Representation2D.gradiant.get(gradKey))
			  
			Representation2D.gradiant.get(gradKey).add(Seed.newBranchNode);
			System.out.println("REP: " + seed.previousNode.x + ", " + seed.previousNode.y + " : " + nextx + ", " + nexty);
			seed.addToLineList(rep.leafGrowth(seed.previousNode.x, seed.previousNode.y, nextx, nexty));
	    	
			System.out.println("Seed current " + seed.currentNode.value);
			System.out.println("Seed size " + seed.getLineList().size());
			
			Representation2D.lineListSize = seed.getLineList().size();
			seed.ageTree();
			//System.out.println("LEAF GREW ");
			
		}
	}
	
	public static int findHeightGrad(int y, Representation2D rep) {
		int startingHeightGrad = 30;
		int yStart = 0;
		while(yStart < 534) {
			if(yStart > y) {
				return yStart;
			}
			yStart += startingHeightGrad;
		}
		System.out.println("ERRORRRRRRRRRRRRRRRRRR");
		System.out.println("REP HEIGHT: " + 534);
		System.out.println("YSTART: "  + yStart);
		System.out.println("Y: "  + y);
		
		return 0;
	}
	
	public int findWidthGrad(int x, Representation2D rep) {
		int startingWidthGrad = 30;
		int xStart = 0;
		while(xStart < 511) {
			if(xStart > x) {
				return xStart;
			}
			xStart += startingWidthGrad;
		}
		System.out.println("ERRORRRRRRRRRRRRRRRRRR");
		System.out.println("REP WIDTH: " + 511);
		System.out.println("XSTART: "  + xStart);
		System.out.println("X: "  + x);
		
		return 0;
	}
	
	public Seed mutateSeed(Seed toMutate, Seed toReplace, Representation2D rep) {
				int randomCDepthToAddOrSubract = (int) (Math.random() * toMutate.rootChoiceExpression.length());
				int randomDDepthToAddOrSubract = (int) (Math.random() * toMutate.rootDirectionExpression.length());
				
				int addOrSubtract = (int) (Math.random() * 10);
				String randomChoiceDNAToAdd = "";
				String randomDirectionDNAToAdd = "";
				//= 100;
				int generation = PeetreeDishStart.generation;
				// = 10;
				int expressionLength = toMutate.getLineList().size()/2;
				//int byHundred = 100;
				//if(generation % 100 == 0) {
				//	expressionLength = generation/100;
					//byHundred += 100;
				//}
				
				
				if(addOrSubtract <= 12 ) {
					randomChoiceDNAToAdd = RandomExpression.getRandomExpression(randomCDepthToAddOrSubract) + toMutate.rootChoiceExpression;
					randomDirectionDNAToAdd = RandomExpression.getRandomExpression(randomDDepthToAddOrSubract) + toMutate.rootDirectionExpression;
				}else if(addOrSubtract <= 2){
					randomChoiceDNAToAdd = toMutate.rootChoiceExpression;
					randomDirectionDNAToAdd = toMutate.rootDirectionExpression;
				}else {
					randomChoiceDNAToAdd = toMutate.rootChoiceExpression + RandomExpression.getRandomExpression(randomCDepthToAddOrSubract);
					randomDirectionDNAToAdd = toMutate.rootDirectionExpression + RandomExpression.getRandomExpression(randomDDepthToAddOrSubract);
				}
				
				if(randomChoiceDNAToAdd.length() > expressionLength) {
						randomChoiceDNAToAdd = randomChoiceDNAToAdd.substring(0,randomChoiceDNAToAdd.length()/2);
					}
				if(randomDirectionDNAToAdd.length() > expressionLength) {
						randomDirectionDNAToAdd = randomDirectionDNAToAdd.substring(0,randomDirectionDNAToAdd.length()/2);
					}
					
				/*}/*else {
					randomChoiceDNAToAdd = toMutate.rootChoiceExpression.substring(0, randomCDepthToAddOrSubract);
					randomDirectionDNAToAdd = toMutate.rootDirectionExpression.substring(0, randomDDepthToAddOrSubract);
					
				}*/
				//char[] treeDNA = randomChoiceDNAToAdd.toCharArray();
					
					
				ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
				
				String gradKey = findWidthGrad(toReplace.initialx, rep) + ", " + findHeightGrad(toReplace.initialy, rep);
				
				BranchNode bn = new BranchNode(0,arb,toReplace.initialx,toReplace.initialy,10, gradKey);
				
				Seed seed = new Seed(bn,toReplace.initialx,toReplace.initialy,randomChoiceDNAToAdd,randomDirectionDNAToAdd);
				System.out.println("mutated farther");
				System.out.println("NEW EXPRESSIONS: ");
				System.out.println(randomChoiceDNAToAdd);
				System.out.println(randomDirectionDNAToAdd);
				return seed;
		
	}
	
	
	//Are seeds growing in real time? or do they take turns?
	//Can leafs grow at the same time?
	
	
}
