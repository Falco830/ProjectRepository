package com.ptg;

class Employee4{
	int employeeId;
	String employeeName;
	double salary;
	//default constructor or constructor without parameters
	Employee4(){
		employeeId=1028;
		employeeName = "Jerry";
		salary = 132000.00;
		
		
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Salary: " + salary);
		
		System.out.println("I am constructor");
	}
	
	//parameterized constructor
	Employee4(int eid, String ename, double esal){
		this.employeeId = eid;
		this.employeeName = ename;
		this.salary = esal;
		
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Salary: " + salary);
		
		System.out.println("I am constructor");				
	}
	
}

class Manager5 extends Employee4{
	int employeeId;
	String employeeName;
	double salary;
	
	Manager5(){
		employeeId=2323;
		employeeName = "Tom";
		salary = 10.00;
		
		
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Salary: " + salary);
		
		System.out.println("I am constructor");
		
	}
	
}



public class TestConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee4 e1 = new Employee4();
		Employee4 e2 = new Employee4();
		Employee4 e3 = new Employee4();
		Employee4 e4 = new Employee4(1022, "Bugs", 9999999999999.99);
		
				
		Employee4 em = new Manager5();
		
		
		Manager5 m1 = new Manager5();
		//Manager5 m2 = new Employee4(); <--- Compile Error
	}
	

}
