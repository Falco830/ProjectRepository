package com.ptg;





class Employee1
{
	int employeeId;
	String employeeName;
	double salary;
	long mobileNumber;
	
	public void employeeInfo(int employeeId, String employeeName, double salary, long mobileNumber) 
	{		
		/*employeeId = x;
		employeeName =y;
		salary = z;
		mobileNumber = m;*/
		
		System.out.println("Employee Id: " + employeeId);
		System.out.println("Empoyee Name: " + employeeName);
		System.out.println("Salary: " + salary);
		System.out.println("Mobile Number: " + mobileNumber);
		
	}
	
}

public class TestMethodWithParameters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee1 e1 = new Employee1();
		System.out.println("----------First Employee Details--------------");
		e1.employeeInfo(830, "Falco830", 5, 5099629324L);
		System.out.println("----------Second Employee Details--------------");
		e1.employeeInfo(2, "Igor", 126000.00, 9776543210L);
		
		System.out.println("----------Third Employee Details--------------");
		e1.employeeInfo(3, "Jimbo", 126000.00, 9776540); //implicit (automatic casting)
		
		System.out.println("----------Fourth Employee Details--------------");
		e1.employeeInfo((int) 9776543210L, "Bob", 126000.00, 9776543210L); //Explicit (programmer casting)
		
		
		
		
		
		
		
	
	}

}
