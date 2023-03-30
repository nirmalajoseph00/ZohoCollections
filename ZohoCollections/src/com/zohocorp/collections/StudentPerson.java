package com.zohocorp.collections;


public class StudentPerson
{
	private String admissionNumber;
	private String name;
	private int age;
	private String grade;
	public StudentPerson(String admissionNumber,String name,int age,String grade)
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