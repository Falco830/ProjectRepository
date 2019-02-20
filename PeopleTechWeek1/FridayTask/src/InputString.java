import java.util.Stack;

public class InputString {

	public static void main(String[] args) {
		String inputString = "";
		System.out.println(isValidString("{[()]}"));
	}
	
	
	public static boolean isValidString(String input) {
		Stack<Character> brackets = new Stack<Character>();
		if(input.equals("")) {
			return true;
		}
		for(int i = 0; i<input.length(); i++) {
			if(Character.toString(input.charAt(i)).matches("[\\(\\[\\{]")) {
				System.out.println(input.charAt(i));
				switch(input.charAt(i)) {
				case'(':
					brackets.push(')');
					break;
				case'[':
					brackets.push(']');
					break;
				case'{':
					brackets.push('}');
					break;
					default:
						System.out.println("Not one ");
						break;
				}
				
			}else if (Character.toString(input.charAt(i)).matches("[\\)\\]\\}]")){
				System.out.println(input.charAt(i));
				if(brackets.pop() != (input.charAt(i))) {
					return false;
				}
			}				
		}
		if(!brackets.isEmpty()) {
			return false;
		}
		return true;
		
	}
	
	
	
}
