package com.zohocorp.collections;
 import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class MapExample
{  
	 public static void main(String args[])
	 {  
		 //MAP is an interface
		 
		 //CONSTRUCTORS
		 //1
		 Map<String,Integer> marks=new HashMap<String,Integer>(); 
		 marks.put("Amit",34);    
	      marks.put("Vijay",42);    
	      marks.put("Seeta",46);  
	      
	      //2
		 HashMap<Integer, String> hm1 = new HashMap<>(10);
		 hm1.put(1, "one");
	     hm1.put(2, "two");
	     hm1.put(3, "three");
	     
	     
	     //3
	     //load factor, which is the measure of how full the hashmap can be before it is resized.
	     HashMap<Integer, String> hm2= new HashMap<Integer, String>(4, 0.5f);
	     /*Threshold = (Current Capacity) * (Load Factor)= 4 * 0.5 = 2
			That means, the capacity of the HashMap is increased from 4 to 8 after the 2nd 
			key-value pair is added into the HashMap.
		 */
	     hm2.put(4, "four");
	     hm2.put(5, "five");
	     hm2.put(6, "six");
	     
	     //4
	     HashMap<Integer, String> hm3 = new HashMap<Integer, String>(hm2);
	     
	     HashMap<Integer, String> hm4 = new HashMap<Integer, String>(hm2);
	     hm4.putAll(hm2);//entire map copied
	     
		 Set<Entry<String, Integer>> set=new HashSet<Entry<String, Integer>>(); 
		 
		//Entry Interface is inside the HashMap interface - which we can use only on individual entry
	      
	      //TRANSVERSING THROUGH MAP
		 //1
	      set=marks.entrySet();
	      System.out.println(set); 
	      
	      for(Entry<String, Integer> me :marks.entrySet()) 
	      {
	            System.out.print(me.getKey() + ":");
	            me.setValue(me.getValue()+3);
	            System.out.println(me.getValue());
	      }
	      
	      //2
	      for (Object i:hm1.keySet())
	            System.out.println(i);
	      //3
	      Iterator itr=set.iterator();
	      while(itr.hasNext())
	      {
	    	  Map.Entry entry=(Entry) itr.next();
	    	  System.out.println(entry.getKey()+":"+entry.getValue());
	      }
	      
	      //Performs an action for each element of this stream  
	      set.forEach(System.out::println);  
	      
	      
	      //SEARCH
	      if (marks.containsKey("Amit")) 
	      {
	            System.out.println("value for key Amit: "+ marks.get("Amit"));
	            marks.remove("Amit");
	      }
	      if (marks.containsValue(50)) 
	      {
	            System.out.println("Atleast one student has perfect marks");
	      }
	      System.out.println("is marks empty: "+marks.isEmpty());
	      hm1.replace(1, "ONE"); 
	      hm1.replaceAll((k,v) -> "TWO"); 
	      System.out.println(hm1.entrySet());//return set of each key-value pair
	      hm4.clear(); //clear the map
	      
	      System.out.println("Keys: "+ marks.keySet());//set since keys can't have duplicates
	      System.out.println("Values: "+ marks.values());//a collection since values can be duplicate
	      
	      
	      
	      
	      
	      //HASHTABLE
	      Hashtable<String,Integer> hashTable=new Hashtable<String,Integer>(); 
	      hashTable.put("Amit",34);    
	      hashTable.put("Vijay",42);    
	      hashTable.put("Seeta",46);  
	      hashTable.putIfAbsent("Reena",26);
	      System.out.println("Updated Map: "+hashTable);
	      
	      Hashtable<Integer, String> ht1 = new Hashtable<Integer, String>(3, 0.5f);
	      ht1.put(1, "one");
	      ht1.put(2, "two");
	      ht1.put(3, "three");
	      System.out.println(ht1.getOrDefault(4, "Not Found")); 
	      //Transversal
	      for (Entry<Integer, String> eht : ht1.entrySet())
	            System.out.println(eht.getKey() + " "+ eht.getValue());
	      
	      //LINKED HASHMAP
	      LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>(marks);
	      lhm.put("Ralph", 47);
	      System.out.println(lhm);
	      
	      //TREEMAP
	      Map<Integer,String> treeMap = new TreeMap<>(hm2);
	      
	      //Iterating
	      for (int key : treeMap.keySet()) 
	            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
	      
	      //search
	      int value =1;
	      System.out.println("\nIs value \"" + value+ "\" present? "+ treeMap.containsValue(value));
	 }
}