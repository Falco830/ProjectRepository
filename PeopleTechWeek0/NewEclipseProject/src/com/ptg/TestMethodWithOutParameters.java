package com.ptg;


class Employee{
	
	byte roomNumber;
	short systemNumber;
	char employeeId;
	
	byte mRoomNum() {
		return roomNumber;
	}
	
	short mSysNum() {
		return systemNumber;
	}
	
	
}

public class TestMethodWithOutParameters {

	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		
		e1.roomNumber = 100;
		e1.systemNumber = 200;
		
		System.out.println("room number "+ e1.roomNumber);
		System.out.println("system number "+ e1.systemNumber);
	}
}
