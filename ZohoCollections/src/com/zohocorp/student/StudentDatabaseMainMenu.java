package com.zohocorp.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class StudentDatabaseMainMenu {
	private static Scanner in = new Scanner(System.in);
	private static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	private static StudentDatabaseInterface studentAction=new StudentDatabaseActions();
	public static void main(String[] args)throws IOException
	{
		char ch='Y';
		int choice;

		do
		{
			System.out.println("\n Main Menu \n 1.Insert Student \n 2.Modify Student "
					+ "\n 3.Display Database \n 4.Delete Student \n 5.Display Student \n 6.Quit");
			System.out.println("Enter your choice: ");
			choice=Integer.parseInt(reader.readLine());
			switch(choice)
			{
			case 1:
				addStudent();
				break;
				
			case 2:
				modifyStudent();
				break;
			case 3:
				displayDatabase();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				System.out.println("Enter admission number");
				String admissionNumber=reader.readLine();
				displayStudent(admissionNumber);
				break;
			case 6:
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
	
	public static void displayStudent(String admNo) 
	{
		try
		{
			Student studentObject=studentAction.displayStudentDetails(admNo);
			System.out.printf("Admission No: "+ admNo +"\t");
            System.out.printf("Name: "+ studentObject.getName()+"\t");
            System.out.printf("Age: "+ studentObject.getAge()+"\t");
            System.out.printf("Grade: "+ studentObject.getGrade()+"\n");
		}
		catch (Exception e) {
			System.out.println("Student Not Found!!!!");
		}
	}

	public static void addStudent() throws IOException
	{
		System.out.println("Enter admission number");
		String admissionNumber=reader.readLine();
		System.out.println("Enter name");
		String name=reader.readLine();
		System.out.println("Enter age");
		int age=Integer.parseInt(reader.readLine());
		System.out.println("Enter grade");
		String grade=reader.readLine();
		if (studentAction.insertPerson(admissionNumber,name,age,grade))
		{
			System.out.println("Student Added");
			displayStudent(admissionNumber);
		}
		else
			System.out.println("Admission No. already present");
	}
	public static void modifyStudent() throws IOException
	{
		System.out.println("Enter the admission number of student to be modified");
		String admNoModify=reader.readLine();
		System.out.println("Enter modified name");
		String name=reader.readLine();
		System.out.println("Enter modified age");
		int age=Integer.parseInt(reader.readLine());
		System.out.println("Enter modified grade");
		String grade=reader.readLine();
		if (studentAction.modifyPerson(admNoModify,name, age, grade))
		{
			System.out.println("Student Modified");
			displayStudent(admNoModify);
		}
		else
			System.out.println("Admission No. not present");
			
	}
	public static void deleteStudent() throws IOException
	{
		System.out.println("Enter the admission number of student to be deleted");
		String admNoDelete=reader.readLine();
		if (studentAction.delete(admNoDelete))
			System.out.println("Deleted "+ admNoDelete);
		else
			System.out.println("Admission No. not present");
	}
	public static void displayDatabase()
	{
		Map<String,Student> studentDB=studentAction.display();
		if (studentDB.size()==0)
			System.out.println("No data");
		else
		{
			studentDB.forEach((k, v) -> {
				System.out.printf("Admission No: "+ k +"\t");
	            System.out.printf("Name: "+ v.getName()+"\t");
	            System.out.printf("Age: "+ v.getAge()+"\t");
	            System.out.printf("Grade: "+ v.getGrade()+"\n");
			});
		}
	}
}