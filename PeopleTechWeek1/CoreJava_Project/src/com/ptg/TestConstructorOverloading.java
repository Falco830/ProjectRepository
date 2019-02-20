package com.ptg;

class Employee5{
	Employee5(int employeeId, String employeeName){
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		
		
	}
	Employee5(double salary, long mobileNumber){
		System.out.println("Salary: " + salary);
		System.out.println("Mobile Number: " + mobileNumber);
		
	}
}

public class TestConstructorOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee5 e1 = new Employee5(1020, "Daffy");
		Employee5 e2 = new Employee5(1300000.00, 123456789L);
	}

}
