package com.sujon;


public class BengaliStudent extends Student{

	public BengaliStudent(String name, int age, double mark, String grade) {
		super(name, age, mark, grade);
	}
	
	@Override
	public void speak() {
		super.speak();
		System.out.println("I am " + name + " I speak both English and Bengali");
	}

	public static void main(String[] args) {

	}

}
