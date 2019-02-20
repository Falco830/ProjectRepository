import java.util.Stack;

public class HistogramA {
	
	public static void main(String[] args) {
		
		int[] bars = { 6, 2, 5, 4, 5, 1, 6 };
		HistogramA hA = new HistogramA();
		System.out.println(HistogramA.Histogram(bars));

	}	
	
	
	
	public static int Histogram(int[] bars) {
		
		
		Stack<Integer> hisStack = new Stack<Integer>();
		int tp;
		int area_with_top;
		int max_area = 0;
		int i = 0;

		while(i<bars.length) {
			
			if(hisStack.empty() || bars[i] >= bars[hisStack.peek()]) {
				//System.out.println("StepA: " + i);
				hisStack.push(i++);
			}else {
				//System.out.println("StepB: " + i);
				tp = hisStack.peek();
				hisStack.pop();
				
				area_with_top = bars[tp] * (hisStack.empty() ? i: i - hisStack.peek() -1);
				if(max_area < area_with_top) {
					max_area = area_with_top;
				}
			}
		}
		//System.out.println(i);
		while(!hisStack.isEmpty()) {
			tp = hisStack.peek();
			hisStack.pop();
			
			area_with_top = bars[tp] * (hisStack.empty() ? i: i - hisStack.peek() -1);
			if(max_area < area_with_top) {
				max_area = area_with_top;
			}
		}
		
		return max_area;
	}
	
	
}
