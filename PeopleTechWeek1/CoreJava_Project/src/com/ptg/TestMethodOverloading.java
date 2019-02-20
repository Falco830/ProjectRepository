package com.ptg;

class Employee2 {
	
	void employeeInfo() {
		System.out.println("method overloading");
	}
	
	int employeeInfo(int employeeId) {
		System.out.println("Employee Id: " + employeeId);
		return 0;
	}
	
	int employeeInfo(String employeeName) {
		System.out.println("Employee Name: " + employeeName);
		return 0;
	}
	
	void employeeInfo(double salary, String stuff) {
		System.out.println("Salary: " + salary);
	}
	
	void employeeInfo(long mobileNumber) {
		System.out.println("Mobile Number: " + mobileNumber);
	}
	
	void employeeInfo(String y, double x) {
		
		System.out.println("X value: " + x);
		System.out.println("Y value: " + y);
	}
	
}




public class TestMethodOverloading {

	public static void main(String[] args) {
		
		Employee2 e1 = new Employee2();
		e1.employeeInfo();
		e1.employeeInfo(1020);
		e1.employeeInfo("Steve Jobs");
		e1.employeeInfo(12500000.00, "Stuff");
		e1.employeeInfo(5098993400L);
		e1.employeeInfo("120-123-4544", 233-223-4233L);
		
	}
}

