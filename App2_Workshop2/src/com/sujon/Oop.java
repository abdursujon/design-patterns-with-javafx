package com.sujon;

import java.util.ArrayList;
import java.util.Scanner;


public class Oop {
	ArrayList<Student> students = new ArrayList<Student>();
	
	public Oop() {
		System.out.println("This is a object oriented programming classe example");
		students.add(new Student("Sujon", 18, 89.5, "First"));
		students.add(new Student("Ryah", 18, 69.5, "2:1"));
		students.add(new Student("Milkie", 19, 89.5, "First"));
		students.add(new Student("Kirank", 36, 89.5, "First"));
		students.add(new BengaliStudent("Samim", 26, 55, "Speak Bengali and English"));
		System.out.println(students.get(0));
		
		// Average age of students and print each student name
		int sum = 0;
		for(Student s : students) {
				sum = sum + s.getAge();
				s.speak();
		}
		int mean = sum/students.size();
		System.out.println("Average student age is " + mean);
		
	}
	
	
	public static void main (String [] args) {
		new Oop();
		
		Scanner s = new Scanner(System.in);
		while(true) {
			String name;
			String language;
			int age;
			System.out.println("Name? ");
			name = s.nextLine(); // reads the entire line user input, and assign it to name variable
			System.out.println("Language? ");
			language = s.nextLine();
			System.out.println("Age? ");
			try {
				age=Integer.parseInt(s.nextLine());
			}
			catch(Exception ex)
			{
				System.out.println("Age must be an integer");
				continue;
			}
			System.out.println("Hello " + name + ". You speak " + language + ". You are " + age + " old.");
		}
		

	}

}
