package com.sujon;

import java.util.Scanner;

public class App1 {
	public static void main (String [] args) {
		System.out.println("This is a JavaFx App1");
		
		System.out.println("What is your name?");
		Scanner scannerIn = new Scanner(System.in);
		String name = scannerIn.nextLine();
		System.out.println("What is your favourite Number");
		String myString = scannerIn.nextLine();
		int number = Integer.parseInt(myString);
	
		System.out.println("Welcome to JavaFX App1 dear " + name +". You love the number " + number + " don't you!");
		System.out.println("What's your age");
		int age = 10;
		try {
			String ageString = scannerIn.nextLine();
			age = Integer.parseInt(ageString);
		}
		catch(Exception e)
		{
			System.out.println("Must be a number");
			return;	
		}
		System.out.println("Age " + age);
		if(age>36)
			System.out.println("you are old");
		else
			System.out.println("you are young");

		do {
			int option=0;
			System.out.println("Choose an option 1, 2, or 3?");
			try {
				String optionStr = scannerIn.nextLine();
				option = Integer.parseInt(optionStr);
			}
			catch(Exception e)
			{
				System.out.println("Must be a number");
				continue;
			}
			switch(option)
			{
			case 1:
				System.out.println("Good choice: Here is a famous quote by Einstein just for you.");
				System.out.print("""
						“Imagination is more important than knowledge
						Knowledge is limited. Imagination encircles the world.” — Albert Einstein"
						""");
				break;
			case 2:
				System.out.println("Option 2 was the best choice, cause you get to read William Shakspeare");
				System.out.println("""
						
					    Sonnet 18 — William Shakespeare

					    Shall I compare thee to a summer’s day?
					    Thou art more lovely and more temperate:
					    Rough winds do shake the darling buds of May,
					    And summer’s lease hath all too short a date;
					    Sometime too hot the eye of heaven shines,
					    And often is his gold complexion dimm'd;
					    And every fair from fair sometime declines,
					    By chance or nature’s changing course untrimm'd;
					    But thy eternal summer shall not fade,
					    Nor lose possession of that fair thou ow’st;
					    Nor shall Death brag thou wander’st in his shade,
					    When in eternal lines to time thou grow’st:
					    So long as men can breathe or eyes can see,
					    So long lives this, and this gives life to thee.
					    """);
				break;
			case 3:
				System.out.println("Are you clever like Oscar Wilde? ");
				System.out.print("“I am so clever that sometimes I don’t understand a single word of what I am saying.” — Oscar Wilde");

				break;
			case 0:
				System.out.println("bye");
				return;
			default:
				System.out.println("Unknown option");
			}
		} while(true);

	}

}
