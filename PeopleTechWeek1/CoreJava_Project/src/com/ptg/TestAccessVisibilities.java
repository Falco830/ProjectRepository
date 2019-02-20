package com.ptg;

class Employee7{
	private int employeeId;
	String employeeName;
	protected double salary;
	public long mobileNumber;
	
}


public class TestAccessVisibilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee7 e1 = new Employee7();
		Employee7 e2 = new Employee7();
		
		
		
		e1.employeeId = 1020;
		e1.employeeName = "Taz";
		
		e2 = null;
		
		
		
	}

}
