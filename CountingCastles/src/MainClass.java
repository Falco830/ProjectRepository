import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Castle Structure
		 * 
		 * Width and Height
		 * 
		 * 
		 */
		
		int W = 0;		//Castle Width
		int H = 0;		//Castle Height
		
		int WIA = 0;	//Castle Width Indicator A
		int WIB = WIA+1;//Castle Width Indicator B Always has to be greater than Indicator A;
		
		int BL = WIB - WIA;//Block Length
		
		ArrayList<Integer> HI = new ArrayList<Integer>();//Castle Height Indicator
		
		int BB = W;		//Bottom Block is equal to Castle Width.
		
		int B = 0;		//Amount of Blocks
		int P = 0;		//Possibilities for castle Structure
		
		int MB = W*H;	//Maximum number of Blocks
		int AB = 0;		//Amount of blocks being Used
		
		int CB = 0;		//Current Block (might not use)
		int SB = 0;		//Size of block
				
		/*
		 * Castle Rules:
		 * 1) Blocks can be placed on top of other 
		 * blocks as long as nothing sticks out past 
		 * the edges or hangs out over open space.
		 * 
		 * 2) All blocks are aligned/snapped to the grid.
		 * 
		 * 3) Any two neighboring blocks on the same row 
		 * have at least one unit of space between them.
		 * 
		 * 4) The bottom row is occupied by a block of length w.
		 * 
		 * 5) The maximum achieved height of the entire castle is exactly h.
		 * 
		 * 6) The castle is made from an even number of blocks.
		 */
		while(MB >= AB)	{								//Amount of Blocks being used up to Max Block
			B=0;
			while(AB >= B) {							//Calculate until Blocks caps at Amount of Blocks
				for(int i = 0; i < H; i++) {			//Number of Rows(H) to Count
					if(i == 0) {						//If on bottom Block, always 
						WIA = 0;						//add solid block.
						WIB = W;
						BL = WIB;
						HI.add(BL);
						if(AB == 0) {				//if there are no blocks then skip 										
							AB++;					//and go to 1 block
						}
						B++;						//Always add bottom block
						continue;
					}
					while(SB <= W) {					//Size of block is less than or equal to width
						for(int j = 0; j < W-1; j++) {		//Number of Columns(W) to Count															
							for(int k = j+1; k < W; k++) {
								WIA = j;
								WIB = WIA + k;
								BL = WIB - WIA;	
								SB = BL;
								if(HI.get(i-1) > BL) {	//Checking to see what ever is below this block is viable to support the width
									HI.add(BL);
									B++;
									continue;						
								}
							}
						}	
					}
				}
			}
		}
	}
}
