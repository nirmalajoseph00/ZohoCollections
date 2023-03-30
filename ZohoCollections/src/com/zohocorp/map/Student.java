package com.zohocorp.map;

import java.util.Map;
import java.util.TreeMap;
import com.zohocorp.collections.StudentManagement;
import com.zohocorp.collections.StudentPerson;

class StudentActions implements StudentManagement
{
	private static Map<String,StudentPerson> student=new TreeMap<String,StudentPerson>();
	
	public void insertPerson(String admissionNumber,String name,int age,String grade)
	{
		StudentPerson personObject=new StudentPerson(admissionNumber,name, age, grade);
		student.put(admissionNumber, personObject);
	}
	public void modifyPerson(String admNoKey,String name,int age,String grade)
	{
		StudentPerson personObjectModify=student.get(admNoKey);
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

