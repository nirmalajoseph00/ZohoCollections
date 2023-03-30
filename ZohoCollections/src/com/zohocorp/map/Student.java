package com.zohocorp.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Person
{
	private String admissionNumber;
	private String name;
	private int age;
	private String grade;
	Person(String admissionNumber,String name,int age,String grade)
	{
		this.admissionNumber=admissionNumber;
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setGrade(String grade)
	{
		this.grade=grade;
	}
	public String getAdmissionNumber()
	{
		return admissionNumber;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getGrade()
	{
		return grade;
	}
}

class Action
{
	private static Map<String,Person> student=new TreeMap<String,Person>();
	
	public void insertPerson(String admissionNumber,String name,int age,String grade)
	{
		Person personObject=new Person(admissionNumber,name, age, grade);
		student.put(admissionNumber, personObject);
	}
	public void modifyPerson(String admNoKey,String name,int age,String grade)
	{
		Person personObjectModify=student.get(admNoKey);
		personObjectModify.setName(name);
		personObjectModify.setAge(age);
		personObjectModify.setGrade(grade);
	}
	public void display()
	{
		student.forEach((k, v) -> {
			System.out.printf("Admission No: "+ k +"\t");
            System.out.printf("Name: "+ v.getName()+"\t");
            System.out.printf("Age: "+ v.getAge()+"\t");
            System.out.printf("Grade: "+ v.getGrade()+"\n");
        });
	}
	public void delete(String admNoDelete)
	{
		if (student.containsKey(admNoDelete)) 
	    {
			student.remove(admNoDelete);
			System.out.println("Deleted "+ admNoDelete);
	    }
		else
			System.out.println("Admission No. not present");
	}
}

public class Student {
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		Action actionObject=new Action();
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
	}
}
