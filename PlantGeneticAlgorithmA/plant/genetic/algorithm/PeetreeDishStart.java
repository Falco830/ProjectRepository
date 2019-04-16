package plant.genetic.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class PeetreeDishStart {

	int numberOfSeeds;
	int seedPositions;
	
	static ArrayList<Seed> seedList;
	
	static int generation;
	
	static int topScore = 0;
	
	int peetreeDishSize;
	int obstacles;
	int peetreeDishShape;
	
	static Representation2D peetreeDish;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		generation = 1;
		peetreeDish = new Representation2D();
		
		
		//Begin Generation 		
		//Create new seeds
		Seed seed;
		SeedDNA seedDNA = new SeedDNA();
		
		seedList = new ArrayList<Seed>();
		peetreeDish.createJFrame();
		peetreeDish.positions = peetreeDish.returnPositions();
		while(peetreeDish.positions == null) {	
			System.out.print("");
		}

		for(int i = 0; i < peetreeDish.positions.length; i++) {
			seed = seedDNA.seedCreation(peetreeDish.positions[i].x, peetreeDish.positions[i].y,peetreeDish);//new Seed(null, peetreeDish.positions[i].x, peetreeDish.positions[i].y, RandomExpression.getRandomExpression(5), RandomExpression.getRandomExpression(5));
			seedList.add(seed);
		}
		//NOW ROUND ROBIN	
		for(int i = 0 ; i<300000; i++) {
			RoundRobin();
			
		}		
	}
	
	
	public synchronized static void RoundRobin() {
		
		SeedDNA sdna = new SeedDNA();
		System.out.println("Round Robining");
		while(peetreeDish.petreeDish == null) {	
			System.out.print("null");
		}
		for(int i = 0; i < (10 * (generation/10)); i++) {
			int snum = 1;
			for(Seed sd : seedList){
				//System.out.println("_____________ SEED " + snum++ +" ____________");
				sdna.seedGrowth(snum,sd,peetreeDish);
				snum++;
				//peetreeDish.leafGrowth(sd, sdna);
				//peetreeDish.applet.repaint();
			
			//	peetreeDish.applet.repaint();
				
			}
			snum = 1;
					
		}
		
		
		System.out.println("end");
		peetreeDish.applet.repaint();
		
		if(generation % 100 == 0) {
			Scanner next = new Scanner(System.in);
			System.out.println("next?: ");
			String yesNext = next.nextLine();
			/*peetreeDish.applet.revalidate();
			peetreeDish.applet.repaint();*/					
		}
		
		//if(yesNext.equals("y")) {
		generation++;
		System.out.println("generation " + generation);
		System.out.println("TopScore: " + topScore);
		for(Seed sd : seedList) {
			if(sd.getLineList().size() < 600) {				
				
				if(topScore < sd.getLineList().size()) {
					topScore = sd.getLineList().size();
				}
				peetreeDish.applet.repaint();
				continue;		
			}else {
				System.out.println("done");
				//peetreeDish.applet.repaint();
				System.out.println("Seed EXPRESSIONS: ");
				int seedNum = 1;
				for(int i = seedList.size(); i > 0 ; i--) {
					System.out.println("Seed " + (i) + " score is: " + seedList.get(i-1).getLineList().size());
				}
				for(Seed list : seedList) {
					System.out.println("SEED: " + seedNum + " Expressions: ");
					System.out.println("Choice: " + list.rootChoiceExpression);
					System.out.println("Direction: " + list.rootDirectionExpression);
					seedNum++;
				}
				System.exit(0);
				//System.;
			}
		}
		scoreSeeds();
		
	}
	
	public synchronized static void scoreSeeds() {
		System.out.println("SCORING");
		
		Seed chose = null;
		Seed unlucky = null;
		int indx = 0;
		
		for(int i = seedList.size(); i > 0 ; i--) {
			System.out.println("Seed " + (i) + " score is: " + seedList.get(i-1).getLineList().size());
		}
		
		//First gets 50
		//Second gets 25
		//etc
		ArrayList<Seed> rankingList = new ArrayList<Seed>();
		ArrayList<Seed> unorderdList = new ArrayList<Seed>();
		for(int i = 0; i < seedList.size(); i++) {

			unorderdList.add(seedList.get(i));
		}
				
		int snum = 1;
		while(!unorderdList.isEmpty()) {
			
			for(int i = 0; i < unorderdList.size(); i++) {
			//for(Seed sd : unorderdList){
				//System.out.println("_____________ SEED " + snum++ +" ____________");
				if (unorderdList.get(0).getLineList().size() < unorderdList.get(i).getLineList().size()) {
					unorderdList.add(0, unorderdList.remove(i));
				}else if(i == unorderdList.size()-1) {
					unorderdList.add(0, unorderdList.remove(0));
				}
			}
			snum = 1;
			rankingList.add(0,unorderdList.remove(0));
			//System.out.println("UNORDERDLIST SIZE " + unorderdList.size());
			//unorderdList.remove(0);
		}
		//System.out.println("RANKING LIST: ");
		//for(Seed rl : rankingList) {
			//System.out.println("LINE LIST: " + rl.getLineList().size());
		//}
		
		int randomChosen = (int) (Math.random() * 100);
		int firstSmall = 15;
		int smallpercent = 75;
		boolean foundChosen = false;
		while(!foundChosen) {
			//System.out.println("searching for chosen ");
			int seedRank = 1;
			for(int i = rankingList.size()-1; i > 0; i--) {
			//for(Seed rl : rankingList) {
				//System.out.println("Ranked Seed" + seedRank);
				seedRank++;
				//System.out.println("randomChosen: " + randomChosen + " smallPercent " + smallpercent + " firstSmall " + firstSmall);
				if(randomChosen < smallpercent) {
					//System.out.println("WORST SEED " + seedList.contains(rankingList.get(rankingList.size()-1)));
					
					
					int indexOfSeedList = 0;
					for(Seed sl : seedList) {	
						//System.out.println("searching...");
						if(rankingList.get(0).initialx == sl.initialx && rankingList.get(0).initialy == sl.initialy) {
							break;
						}
						indexOfSeedList++;
					}
					//System.out.println("found index " + indexOfSeedList);
					//System.out.println("WORST RANKING VALUE " + rankingList.get(0).getLineList().size());
					//System.out.println("CHOSEN SEED " + rankingList.get(i));
					chose =rankingList.get(i);
					unlucky = rankingList.get(0);
					indx = indexOfSeedList;
					
					foundChosen = true;
					break;
					//return;		
				}
				
				firstSmall = (firstSmall/4);
				if(firstSmall == 0) firstSmall = 1 ;
				smallpercent += (firstSmall);
				
			}	
			
			seedRank = 1;
		}
		firstSmall = 50;
		smallpercent = 50;
		
		theChosenOne(chose, unlucky, indx);

	}
	
	public synchronized static void theChosenOne(Seed theChosenOne, Seed theUnluckyOne, int index) {
		//Create NEW SEED
		//System.out.println("should be here");
		SeedDNA sdna = new SeedDNA();
		//System.out.println("shold be here next");
		//for(int i = 0; i < peetreeDish.positions.length; i++) {
			theUnluckyOne = sdna.mutateSeed(theChosenOne, theUnluckyOne, peetreeDish); //new Seed(null, peetreeDish.positions[i].x, peetreeDish.positions[i].y, RandomExpression.getRandomExpression(5), RandomExpression.getRandomExpression(5));
			//System.out.println("Index: " + index);
			//System.out.println("SeedList: " + seedList.size());
			System.out.println("CHANGING SEED " + index);
			seedList.set(index, theUnluckyOne);
		//}
			nextGeneration();
			
		
	}
	
	public synchronized static void nextGeneration() {
		for(Seed sd : seedList){
			sd.getLineList().clear();
			//sd.rootNode = sd.;
			ArrayList<BranchNode> arb = new ArrayList<BranchNode>();
			sd.rootNode.nodes = arb;
			sd.currentNode = sd.rootNode;
		
			sd.ageOfSeedBranch = 10;
			
			//sd.currentNode.nodes = arb;
			
		}
		for(ArrayList<BranchNode> bn:Representation2D.gradiant.values()) {
			bn.clear();
		}
		
		
			//RoundRobin();	
	}
	
	

}
