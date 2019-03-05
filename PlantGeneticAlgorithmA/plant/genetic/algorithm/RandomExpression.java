package plant.genetic.algorithm;

import java.util.Stack;

public class RandomExpression {

  /**
   * Uses CFG to construct a random postfix string
   *
   * @param minLength
   *          minimum length of postfix expression
   * @return a postfix expression
   */
  public static String getRandomExpression(int minLength) {
    String[] RULES = { "EE+", "EE-", "EE*", "EE/" };
    String[] TERMINALS = { /*"1", "2", "3", "4", "5", "6", "7", "8", "9",*/ "A", "C", "D" , "B", "P", "R"}; //, "B", "P"

    String expression = "E";
    int timer = minLength;
    
    do {
      StringBuilder sb = new StringBuilder();
      for (char ch : expression.toCharArray()) {
        if (ch != 'E') {
        	sb.append(ch);
        } else {
          if (Math.random() < 0.1) {
            String selectedTerminal = TERMINALS[(int) (Math.random() * TERMINALS.length)];
            sb.append(selectedTerminal);
        
          } else {
            String selectedRule = RULES[(int) (Math.random() * RULES.length)];
            sb.append(selectedRule);
          }
        }
      }
      //System.out.println(expression);    
      expression = sb.toString();      
      if(timer <=0) {
    	  break;
      }
      timer--;
    } while (expression.length() < minLength);

    StringBuilder sb = new StringBuilder();

    for (char ch : expression.toCharArray()) {
      if (ch != 'E') {
    		  sb.append(ch);
      } else {  	 
        String selectedTerminal = TERMINALS[(int) (Math.random() * TERMINALS.length)];
        //System.out.println(selectedTerminal);
        
        sb.append(selectedTerminal); 	  	      
      }
    }
    expression = sb.toString();
    /*
  	 char distance =  (char) ((int) Math.random() * 10); 
  	 System.out.println("distance: " + distance);
  	 expression = expression.replace('N', distance);
    */
    System.out.println("EXPRESSION: " + expression);
    return expression;
  }

  /**
   *
   * Stack-evaluates a postfix expression
   * @param expression
   *          postfix expression string
   * @return double result
   */
  public static double evaluate(String expression, Seed seed) {
	  

    Stack<Double> stack = new Stack<Double>();
   // System.out.println("Current " + expression);
    expression = expression.replaceAll("\\s+", "");
    for (char ch : expression.toCharArray()) {
      if (Character.isDigit(ch)) {
        stack.push((double) Character.getNumericValue(ch));
      }else if (ch == 'B') {
    	  
    	  double distance = Math.sqrt(Math.pow((seed.currentNode.x - seed.rootNode.x), 2) + (Math.pow((seed.currentNode.y - seed.rootNode.y), 2)));   	
    	  //System.out.println("B: " + distance);
    	  if(distance == 0) {
    		  distance = (Math.random() * 10);
    	  }
          stack.push(/*Branch distance*/ distance/*(double) Math.random() * 10*/);
      }else if (ch == 'P') {
     	 
     	 double distance = Math.sqrt(Math.pow((seed.currentNode.x - Representation2D.petreeDish.width), 2) + (Math.pow((seed.currentNode.y - Representation2D.petreeDish.height), 2)));  
        // System.out.println("P: " + distance);
     	 
     	 stack.push(/*Petree distance*/ distance);
      }else if (ch == 'R') {
      	 
      	 double distance = seed.currentNode.distanceFromRoot;  
         // System.out.println("P: " + distance);
      	 
      	 stack.push(/*Petree distance*/ distance);
       }else if (ch == 'N') {
      	 if(expression.length() > 4) {
      		 expression = expression.substring(0,expression.length()/2);
      	 }
      	 char distance =  (char) (Math.random() * 10);  
      	// char chaar = (int) distance;
      	 expression = expression.replace('N', distance);
      	 //expression = expression.replaceAll("[N]", distance+"");
         // System.out.println("P: " + distance);
      	 
      	 stack.push(/*Petree distance*/ (double) distance);
      }else if (ch == 'A' || ch == 'C' || ch == 'D') {
    	  double rand = 4;
       	 if( ch == 'A') {
       		 rand = (Math.random() * 3);
       	 }else if( ch == 'C') {
      		 rand =  (Math.random() * 13);
      	 }else if( ch == 'D') {
      		//distance to closest branch
      	 }
       	 
       	 stack.push(/*Petree distance*/ rand);
      }else {

        double right = stack.pop();
        double left = stack.pop();

        if (ch == '+') {
          stack.push(left + right);
        } else if (ch == '-') {
          stack.push(left - right);
        } else if (ch == '/') {
          stack.push(left / right);
        } else {
          stack.push(left * right);
        }
      }
    }

    return stack.pop();
  }

  public static void main(String[] args) {
      String expression = getRandomExpression(3);
      System.out.println(expression);
     // System.out.println("Evaluation: " + evaluate(expression));

  }

}
