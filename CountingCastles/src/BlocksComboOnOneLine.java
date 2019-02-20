import java.util.ArrayList;

public class BlocksComboOnOneLine {

	public static void main(String[] args) {
		
		int AL = 3; 		//Area Length
		int AB = 2;			//Amount of Blocks
		int SB = 1;			//Size of Block
		
		ArrayList BlockRow = new ArrayList();
		
		int BA = 0; 		//Block area
		for(int i = 0; i < AB; i++) {
			for(int j = 0; j < AL-AB)
			BlockRow.add(SB,i);
		}
		
		for(int i = 0; i < AL; i++) {
			
			BlockRow.add
		}	
	}
}



//First Number and Position, then Length, lastly shift and restart.