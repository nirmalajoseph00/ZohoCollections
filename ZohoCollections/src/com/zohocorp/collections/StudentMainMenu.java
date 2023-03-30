package com.zohocorp.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StudentMainMenu {
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		Student actionObject=new Student();
		char ch='Y';
		int choice;
		String admissionNumber,name,grade;
		int age;
		
		do
		{
			System.out.println("\n Main Menu \n 1.Insert Student \n 2.Modify Student "
					+ "\n 3.Display"+ "\n 4.Delete Student \n 5.Quit");
			System.out.println("Enter your choice: ");
			choice=in.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter admission number");
				admissionNumber=reader.readLine();
				System.out.println("Enter name");
				name=reader.readLine();
				System.out.println("Enter age");
				age=Integer.parseInt(reader.readLine());
				System.out.println("Enter grade");
				grade=reader.readLine();
				actionObject.insertPerson(admissionNumber,name,age,grade);
				break;
				
			case 2:
				String admNoModify;
				System.out.println("Enter the admission number of student to be modified");
				admNoModify=reader.readLine();
				System.out.println("Enter modified name");
				name=reader.readLine();
				System.out.println("Enter modified age");
				age=Integer.parseInt(reader.readLine());
				System.out.println("Enter modified grade");
				grade=reader.readLine();
				actionObject.modifyPerson(admNoModify,name, age, grade);
				break;
			case 3:
				actionObject.display();
				break;
			case 4:
				String admNoDelete;
				System.out.println("Enter the admission number of student to be deleted");
				admNoDelete=reader.readLine();
				actionObject.delete(admNoDelete);
				break;
			case 5:
				System.out.println("Do you want to continue(Y/N): ");
				ch=in.next().charAt(0);
				break;
			default:
				System.out.println("Wrong choice");
					
			}	
		}while (ch=='Y');
		System.out.println("Goodbye");
		in.close();
	}
}