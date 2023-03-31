package com.zohocorp.student;

import java.util.Map;

public interface StudentDatabaseInterface 
{
	public boolean insertPerson(String admissionNumber,String name,int age,String grade);
	public boolean modifyPerson(String admNoKey,String name,int age,String grade);
	public Map<String,Student> display();
	public boolean delete(String admNoDelete);
	public Student displayStudentDetails(String admNo);

}
