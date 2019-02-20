package com.ptg;


class Test{
	
	private int x;
	private int y;
	
	public Test(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public void addInfo() {
		int z = x + y;
		System.out.println("Addition of two number: " + z);
	}
	public void subInfo() {
		int sub=x-y;
		System.out.println("Sub: " + sub);
	}
	public void multiInfo() {
		int mult=x*y;
		System.out.println("Mult: " + mult);
	}
	public Test divInfo() {
		int div=x/y;
		System.out.println("Div: " + div);
		Test many = new Test(x,y);
		return many;
	}
}




public class TestConstructorMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test add = new Test(100, 200);
		Test sub = new Test(50,30);
		Test mult = new Test(40,70);
		
		Test div = new Test(20,5);
		
		div.divInfo().multiInfo();
		
		add.addInfo();
		sub.subInfo();
		mult.multiInfo();
		
		
		
	}

}
