package com.zohocorp.collections;

import java.util.Map;
import java.util.TreeMap;



public class StudentActions implements StudentManagement
{
	private static Map<String,StudentPerson> student=new TreeMap<String,StudentPerson>();
	
	@Override
	public void insertPerson(String admissionNumber,String name,int age,String grade)
	{
		if (student.containsKey(admissionNumber)) 
			System.out.println("Admission No. already present");
		else
	    {
			StudentPerson personObject=new StudentPerson(admissionNumber,name, age, grade);
			student.put(admissionNumber, personObject);
	    }
	}
	@Override
	public void modifyPerson(String admNoKey,String name,int age,String grade)
	{
		
			StudentPerson personObjectModify=student.get(admNoKey);
			personObjectModify.setName(name);
			personObjectModify.setAge(age);
			personObjectModify.setGrade(grade);
	}
	@Override
	public void display()
	{
		if (student.size()==0)
			System.out.println("No data");
		else
		{
			student.forEach((k, v) -> {
				System.out.printf("Admission No: "+ k +"\t");
	            System.out.printf("Name: "+ v.getName()+"\t");
	            System.out.printf("Age: "+ v.getAge()+"\t");
	            System.out.printf("Grade: "+ v.getGrade()+"\n");
			});
		}
	}
	@Override
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
