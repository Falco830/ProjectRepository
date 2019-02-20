import java.util.ArrayList;

public class CastleCountSketch {
	public static void main(String[] args) {
		
		System.out.println("Counting Castles: " + CastleCount(10,4));
	}
	
	
	public static int CastleCount(int h, int w) {
		
		
		ArrayList<BlockBox> blockBox = new ArrayList<BlockBox>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>(); 	//Represents the height
		ArrayList<Integer> inner = new ArrayList<Integer>();						//Represents the Width
		int maxBlocks = h * w;
		int items = 0;
		
		
		for(int blocks = 1; blocks <= maxBlocks; blocks++) {						//Start with one block, check all possibilities for that block, move on to more blocks.
			
			for(int i = blocks; i > 0; i--) {										//Put amount of blocks in block box.
				
				String blockName = "Block " + i;									//Number each block
				BlockBox block = new BlockBox(blockName, 1);						//BlockBox identifier, sets name and size of block
				blockBox.add(block);												//Put block into blockBox
			}
			
			BlockBox bottomBlock = new BlockBox("Block " + blocks, w);				//Create BottomBlock for block size = w (width)
			blockBox.set(blocks, bottomBlock);										//Set the last block of the BlockBox to be the BottomBlock
			int bcrease = 1;
			for(int i = 1; i < w; i++) {											//Combination from first block to last block
				for(int j = i; j <= w; j++) {										//Iteratively goes from i to end
					BlockBox blockSize = new BlockBox("Block " + j, bcrease);		//Sets all remaining blocks to selected size
					blockBox.set(j, blockSize);										//Sets size of blocks in BlockBox
				}
				
				for(int j = 1; j < blockBox.size(); j++) {
					for(int k = j; k <= blockBox.size(); k++) {
						
						
						
						
					}
					
					
				}
				
				
				
			}
		}
		
		for(int i = 0; i < w; i++) {
			inner.add(items);
		}
		System.out.println("Bottom Block size: " + inner.size());
		outer.add(inner);	//Add bottom block
		     
		
			for(int i = 0; i < inner.size(); i++) {
				inner.add(items);
				
			}
			outer.add(inner);
			inner = new ArrayList<Integer>();	
			
			
			
			
		inner.add(1);
		inner.add(1);
		outer.add(inner);
		 inner = new ArrayList<Integer>(inner); // create a new inner list that has the same content as  
         // the original inner list
		 outer.add(inner); // add second list

		 outer.get(0).add(300); // changes only the first inner list

		 System.out.println(outer);
		
		
		
		
		return w;
	}
	
	
	

}
