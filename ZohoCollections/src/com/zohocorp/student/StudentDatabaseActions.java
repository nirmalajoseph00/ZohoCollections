package com.zohocorp.student;

import java.util.Map;
import java.util.TreeMap;

public class StudentDatabaseActions implements StudentDatabaseInterface
{
	private Map<String,Student> student=new TreeMap<String,Student>();
	
	@Override
	public boolean insertPerson(String admissionNumber,String name,int age,String grade)
	{
		if (student.containsKey(admissionNumber)) 
			return false;
		else
	    {
			student.put(admissionNumber, new Student(admissionNumber,name, age, grade));
			return true;
	    }
	}
	@Override
	public boolean modifyPerson(String admNoKey,String name,int age,String grade)
	{
		if (student.containsKey(admNoKey)) 
		{
			Student personObjectModify=student.get(admNoKey);
			personObjectModify.setName(name);
			personObjectModify.setAge(age);
			personObjectModify.setGrade(grade);
			return true;
		}
		else
			return false;
	}
	@Override
	public Map<String,Student> display()
	{
		return student;
	}
	@Override
	public boolean delete(String admNoDelete)
	{
		if (student.containsKey(admNoDelete)) 
	    {
			student.remove(admNoDelete);
			return true;
	    }
		else
			return false;
	}
	@Override
	public Student displayStudentDetails(String admNo) 
	{
		return student.get(admNo);
	}

}
