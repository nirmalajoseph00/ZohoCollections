package com.zohocorp.collections;

public interface StudentManagement {
	public void insertPerson(String admissionNumber,String name,int age,String grade);
	public void modifyPerson(String admNoKey,String name,int age,String grade);
	public void display();
	public void delete(String admNoDelete);

}
