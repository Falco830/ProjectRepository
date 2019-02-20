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
		
	public Seed seedCreation(int initialx, int initialy) {		
		//int randomSeedNodes = (int) (Math.random() * 3);
		int randomDepth = (int) (Math.random() * 3);
		//ExpressionTree expressionTree = new ExpressionTree();
		String randomChoiceDNA = RandomExpression.getRandomExpression(randomDepth);
		String randomDirectionDNA = RandomExpression.getRandomExpression(randomDepth);
		
		//char[] treeDNA = randomChoiceDNA.toCharArray();
		 ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
		BranchNode bn = new BranchNode(0,arb,initialx,initialy,10);
		
		Seed seed = new Seed(bn,initialx,initialy,randomChoiceDNA,randomDirectionDNA);
		return seed;
						
	}
	
	//ON ACTIVATION
		//Compare each tree leaf with other tree leaves to determine order
		//in which each leaf should activate;
		//Next perform expression tree to determine direction, speed and behavior	
		//to which branch should travel;
	
	
	public void seedGrowth(Seed seed, Representation2D rep) {
		//direction, constant distance //speed
		//Find Maximum Tree Node
		seed.evaluateEveryRecentNode();
		currentBranchNode = seed.resolveMaxNode();
		seed.currentNode = currentBranchNode;
		//seed.currentNode.y = currentBranchNode.y;
		//System.out.println("Branch Value " + currentBranchNode.value);
		double direction = Math.toDegrees(RandomExpression.evaluate(seed.getDirectionExpression(), seed));
		//System.out.println("Direction Value: " + direction);
		//System.out.println("Math Cos " + (5*Math.cos(direction)));
		//System.out.println("Math Sin " + (5*Math.sin(direction)));
		//CONSTANT DISTANCE;
		int distance = 5;	
		int x = (int) (Math.round(seed.currentNode.x+(20*Math.cos(direction))));
		int y = (int) (Math.round(seed.currentNode.y+(20*Math.sin(direction))));
		
		nextx = x;
		
		nexty = y;
		
		//Check if breaks law
		
		PeetreeLaws pl = new PeetreeLaws(seed.currentNode.x, seed.currentNode.y, nextx, nexty);
		if(pl.breaksLaw(rep)) {
			//System.out.println("Broke Law");
			return;
		}else {		
			 ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
			//System.out.println("CurrentX " + seed.currentNode.x + " CurrentY " + seed.currentNode.y);
			//System.out.println(/*"CurrentBranch " + currentBranchNode + */" nx: " + nextx + " ny: " + nexty);
			seed.addBranch(currentBranchNode, 0, arb, nextx, nexty);			
			rep.leafGrowth(seed, this);
			seed.ageTree();
			//System.out.println("LEAF GREW ");
			
		}

	}
	
	public Seed mutateSeed(Seed toMutate, Seed toReplace) {
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
				
				
				if(addOrSubtract <= 1 ) {
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
				BranchNode bn = new BranchNode(0,arb,toReplace.initialx,toReplace.initialy,10);
				
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
