package com.zohocorp.collections;

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
	private String name;
	private int age;
	private String grade;
	Person(String name,int age,String grade)
	{
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
	
	public void insertPerson(String name,int age,String grade)
	{
		Person personObject=new Person(name, age, grade);
		student.put(name, personObject);
	}
	public void modifyPerson(String nameKey,String name,int age,String grade)
	{
		Person personObjectModify=student.get(nameKey);
		personObjectModify.setName(name);
		personObjectModify.setAge(age);
		personObjectModify.setGrade(grade);
	}
	public void display()
	{
		student.forEach((k, v) -> {
            System.out.printf("Name: "+ v.getName()+"\t");
            System.out.printf("Age: "+ v.getAge()+"\t");
            System.out.printf("Grade: "+ v.getGrade()+"\n");
        });
	}
	public void delete(String nameDelete)
	{
		student.remove(nameDelete);
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
		String name,grade;
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
				System.out.println("Enter name");
				name=reader.readLine();
				System.out.println("Enter age");
				age=Integer.parseInt(reader.readLine());
				System.out.println("Enter grade");
				grade=reader.readLine();
				actionObject.insertPerson(name,age,grade);
				break;
				
			case 2:
				String nameModify;
				System.out.println("Enter the name of student to be modified");
				nameModify=reader.readLine();
				System.out.println("Enter modified name");
				name=reader.readLine();
				System.out.println("Enter modified age");
				age=Integer.parseInt(reader.readLine());
				System.out.println("Enter modified grade");
				grade=reader.readLine();
				actionObject.modifyPerson(nameModify,name, age, grade);
				break;
			case 3:
				actionObject.display();
				break;
			case 4:
				String nameDelete;
				System.out.println("Enter the name of student to be deleted");
				nameDelete=reader.readLine();
				actionObject.delete(nameDelete);
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
