package com.zohocorp.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		
		
		
		//LINKED HASH SET
		LinkedHashSet<String> al=new LinkedHashSet<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ravi");  //duplicate
		  al.add("Ajay");  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()) 
		   System.out.println(itr.next()); 
		   
		  System.out.println(al.remove("Vijay"));
		  
		//TREE HASH SET
		  TreeSet<String> treeSet=new TreeSet<String>(al); 
		  treeSet.add("Linda");
		  treeSet.add("Zoya");//alphabetical
		  System.out.println(treeSet);
		  System.out.println("Lowest Value: "+treeSet.pollFirst());    
	      System.out.println("Highest Value: "+treeSet.pollLast()); 
		  
		//HASH SET
			HashSet<String> set=new HashSet(al); 
			set.removeIf(str->str.contains("Ajay")); 
		  
		  
	}

}
