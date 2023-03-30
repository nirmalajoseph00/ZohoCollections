package com.zohocorp.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class List{  
	 public static void main(String args[])
	 {  
		 //CONSTRUCTORS
		  ArrayList<Integer> list1=new ArrayList<Integer>();
		 list1.add(1);
		 list1.add(5);
		  ArrayList<Integer> list2=new ArrayList<Integer>(3);
		  list2.addAll(list1);
		  list2.add(1,27);//index 1
		  ArrayList<Integer> list3 = new ArrayList<>(list2);
		  
		//Traversing list through for-each loop  
		  for(int element:list2)    
		    System.out.print(element+" "); 
		  System.out.println();
		  
		  Iterator<Integer> itr=list3.iterator();//getting the Iterator  
		  while(itr.hasNext())//check if iterator has the elements  
		  {
			  System.out.println(itr.next());//printing the element and move to next  
		  }  
		  
		  System.out.println("Element in list3 at index 2: "+ list3.get(2));
		  
		  	list3.remove(1);
	        System.out.println("After removing the second element, the ArrayList contains: " + list3);

	        // check if an element exists in the ArrayList using the contains() method
	        boolean containsElement = list3.contains(5);
	        System.out.println("Does the ArrayList contain 5? " + containsElement);

	        // replace an element in the ArrayList using the set() method
	        list3.set(1, 6);
	        System.out.println("After replacing the second element: " + list3);

	        // clear all elements from the ArrayList using the clear() method
	        list3.clear();
	        System.out.println("After clearing the ArrayList: " + list3);
		  
	 }  
}  