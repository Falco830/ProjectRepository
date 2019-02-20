/*
 * Alec Michel
 * 19/Jan/2019
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ServiceLoader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Calculator extends JFrame {

    private JButton jbtNum1;
    private JButton jbtNum2;
    private JButton jbtNum3;
    private JButton jbtNum4;
    private JButton jbtNum5;
    private JButton jbtNum6;
    private JButton jbtNum7;
    private JButton jbtNum8;
    private JButton jbtNum9;
    private JButton jbtNum0;
    private JButton jbtEqual;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    private JButton jbtDivide;
    private JButton jbtSolve;
    private JButton jbtClear;
    private double TEMP;
    private double SolveTEMP;
    private JTextField jtfResult;

    Boolean addBool = false;
    Boolean subBool = false;
    Boolean divBool = false;
    Boolean mulBool = false;

    String display = "";

    public Calculator() {

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 3));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtClear = new JButton("C"));

        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(20));
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setEditable(false);

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(5, 1));
        p3.add(jbtAdd = new JButton("+"));
        p3.add(jbtSubtract = new JButton("-"));
        p3.add(jbtMultiply = new JButton("*"));
        p3.add(jbtDivide = new JButton("/"));
        p3.add(jbtSolve = new JButton("="));

        JPanel p = new JPanel();
        p.setLayout(new GridLayout());
        p.add(p2, BorderLayout.NORTH);
        p.add(p1, BorderLayout.SOUTH);
        p.add(p3, BorderLayout.EAST);

        add(p);

        jbtNum1.addActionListener(new ListenToOne());
        jbtNum2.addActionListener(new ListenToTwo());
        jbtNum3.addActionListener(new ListenToThree());
        jbtNum4.addActionListener(new ListenToFour());
        jbtNum5.addActionListener(new ListenToFive());
        jbtNum6.addActionListener(new ListenToSix());
        jbtNum7.addActionListener(new ListenToSeven());
        jbtNum8.addActionListener(new ListenToEight());
        jbtNum9.addActionListener(new ListenToNine());
        jbtNum0.addActionListener(new ListenToZero());

        jbtAdd.addActionListener(new ListenToAdd());
        jbtSubtract.addActionListener(new ListenToSubtract());
        jbtMultiply.addActionListener(new ListenToMultiply());
        jbtDivide.addActionListener(new ListenToDivide());
        jbtSolve.addActionListener(new ListenToSolve());
        jbtClear.addActionListener(new ListenToClear());
}
    class ListenToClear implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //display = jtfResult.getText();
            jtfResult.setText("");
            addBool = false;
            subBool = false;
            mulBool = false;
            divBool = false;

            TEMP = 0;
            SolveTEMP = 0;
        }
    }
	public static void main(String[] args)  throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		Calculator calc = new Calculator();
        calc.pack();
        calc.setLocationRelativeTo(null);
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Type in your Equation(separated by spaces): ");
		String equation = sc.nextLine();
		double totalValue = 0;
		/*
		 * double result = e;					//Input java code into this line.			
		 * System.out.println(equation);
		 */

		String svalue = equationCodeCreate(equation);
		System.out.println(svalue);
		double value = Double.parseDouble(svalue);
		totalValue = value;
		
		double memory = 0;
		System.out.print("Please type in next command: ");
        String nextAction = sc.nextLine();
        while(!nextAction.equals("exit")) {
        	switch(nextAction){
        		case "mc":
        			memory = 0;
        			break;
        		case "m+":
        			memory += totalValue;
        			break;
        		case "m-":
        			memory -= totalValue;
        			break;
        		case "c":
        			totalValue = 0;
        			value = 0;
        			break;
        		case "ce":
        			value = 0;
        			break;
        		default:
        			String[] noSpaces = nextAction.split("[ ]");
        			if(noSpaces[0].matches("[+-/*(]")) {
        			equation = totalValue + nextAction;
        			svalue = equationCodeCreate(equation);
        			value = Double.parseDouble(svalue);
        			totalValue = value;       
        			}else {
        				equation = nextAction;
            			svalue = equationCodeCreate(equation);
        				value = Double.parseDouble(svalue);
        				totalValue = value;   
        				
        			}
        			break;
        	}
        	System.out.println("Memory: " + memory);
        	System.out.println("Total Value: " + totalValue);
			System.out.println("Value: " + value);
			System.out.print("Please type in next command: ");
        	nextAction =  sc.nextLine();
        }
        System.out.println("Good Bye! ");
        
	}	
	
	
	public static String equationCodeCreate(String equation) throws IOException, InterruptedException {

		//Checking for Multiples 4( and )3
		String noSpaces = equation.replaceAll(" ", "");
		for(int i = 0; i < noSpaces.length(); i++) {
			char multiple = noSpaces.charAt(i);
			int numOfChar = multiple;
			System.out.println(Character.toString(noSpaces.charAt(i)) + " == "+ numOfChar);
			if(numOfChar == 40 && i != 0) {				
				if(Character.isDigit(noSpaces.charAt(i-1)) && '*' != noSpaces.charAt(i-1)) {
					System.out.println("Add(: ");
					noSpaces = noSpaces.substring(0,i) + "*" +noSpaces.substring(i,noSpaces.length());
				}
				
			}else if(numOfChar == 41 && i != noSpaces.length()-1) {	
				if(Character.isDigit(noSpaces.charAt(i+1)) && '*' != noSpaces.charAt(i+1)) {
					System.out.println("Add): ");
					noSpaces = noSpaces.substring(0,i+1) + "*" +noSpaces.substring(i+1,noSpaces.length());
				}
			}
		}
		System.out.println("New String With Mult: " + noSpaces);
		equation = noSpaces;
		
		String classStructureUpper = "\r\n" + 
				"public class Calculator {\r\n" + 
				"\r\n" + 
				"	public static void main(String[] args) {";
		
		String classStructureLower = "		\r\n" + 
				"	}\r\n" + 
				"\r\n" + 
				"} \r";
		
		String fileName = "Calculator.java";
		
		FileWriter fileWriter = new FileWriter(fileName);
	    PrintWriter printWriter = new PrintWriter(fileWriter); 
	    
	    printWriter.print(classStructureUpper);
	    printWriter.print("\r\n double result = " + equation + ";"  + "\r\n");
	    printWriter.printf("System.out.println(result);");
	    printWriter.print(classStructureLower);
	    printWriter.close();

        System.out.println("Compiling Code..." );

        System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_171");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        compiler.run(null, System.out, null, "D:\\Spring Samples\\PeopleTechWeek1\\CalculatorProject\\Calculator.java");
        System.out.println("Executed..." );

        System.out.println("Running Code..." );
        Runtime rt = Runtime.getRuntime();

        String[] commands = {"java" , "Calculator" };

        Process proc = rt.exec(commands);
        BufferedReader stdInput = new BufferedReader(new 
        	     InputStreamReader(proc.getInputStream()));
        String s = null;
        String res = null;
        while ((s = stdInput.readLine()) != null) {
            //System.out.println("Result: " + s);
            res = s;
        }
        return res;
	}
	class ListenToOne implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "1");
	    }
	}
	class ListenToTwo implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "2");
	    }
	}
	class ListenToThree implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "3");
	    }
	}
	class ListenToFour implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "4");
	    }
	}
	class ListenToFive implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "5");
	    }
	}
	class ListenToSix implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "6");
	    }
	}
	class ListenToSeven implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "7");
	    }
	}
	class ListenToEight implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "8");
	    }
	}
	class ListenToNine implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "9");
	    }
	}
	class ListenToZero implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "0");
	    }
	}

	class ListenToAdd implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        TEMP = Double.parseDouble(jtfResult.getText());
	                    jtfResult.setText("");

	    }
	}
	class ListenToSubtract implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "0");
	    }
	}
	class ListenToMultiply implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "0");
	    }
	}
	class ListenToDivide implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	        display = jtfResult.getText();
	        jtfResult.setText(display + "0");
	    }
	}
	 class ListenToSolve implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            SolveTEMP = Double.parseDouble(jtfResult.getText());
	            if (addBool == true)
	                SolveTEMP = SolveTEMP + TEMP;
	            else if ( subBool == true)
	                SolveTEMP = SolveTEMP - TEMP;
	            else if ( mulBool == true)
	                SolveTEMP = SolveTEMP * TEMP;
	            else if ( divBool == true)
	                            SolveTEMP = SolveTEMP / TEMP;
	            jtfResult.setText(  Double.toString(SolveTEMP));

	            addBool = false;
	            subBool = false;
	            mulBool = false;
	            divBool = false;
	        }
	    }
}
