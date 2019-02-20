package com.ptg;

class Employee6{
	int employeeId;
	String employeeName;
	double salary;
	long mobileNumber;

	Employee6(){
		System.out.println("---I am default constructor---");
	}
	Employee6(int employeeId, String employeeName, double salary, long mobileNumber){
		
		this();
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.mobileNumber = mobileNumber;
		
		
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Salary: " + salary);
		System.out.println("Mobile Number: " + mobileNumber);
		
	}
	Employee6(String st){
		this(12, "hello", 12.01, 1234L);
		System.out.println("Address: " + st);
	}
	
}


public class TestthisKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Employee6 e1 = new Employee6();
		//Employee6 e2 = new Employee6(1020, "Elmer", 2000.00, 10010111L);
		Employee6 e3 = new Employee6("India");
		
		
	}

}
