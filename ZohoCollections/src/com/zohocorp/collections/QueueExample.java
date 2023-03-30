package com.zohocorp.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample 
{
	public static void main(String args[])
	{
	
		Queue<Integer> q= new LinkedList<Integer>();
		
		for (int i = 0; i < 5; i++)
		    q.add(i);
		
		System.out.println("Elements of queue "+ q);
		
		// To remove the head of queue.i.e 1st element
		q.remove();
		System.out.println(q);
		
		// To view the head of queue
		int head = q.peek();
		System.out.println("head of queue-"+ head);
		
		
		
		//PRIORITY QUEUE
		PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(q);
		
		// Printing the top element 
		System.out.println("Head: "+pQueue.peek());
		
		// Printing the top element and removing it/
		System.out.println("Removed element: "+pQueue.poll());
		
		Iterator<Integer> iterator = pQueue.iterator();
		  
        while (iterator.hasNext()) 
            System.out.print(iterator.next() + " ");
        System.out.println("Is the queue empty? " + pQueue.isEmpty());
        
        
        //DEQUE
        Deque<String> dq= new ArrayDeque<String>();

	    // add() method to insert
	    dq.add("Hello");
	    dq.addFirst("Good");
	    dq.addLast("Morning");
	    dq.add("Java");
	
	    for (Iterator<String> itr = dq.descendingIterator();itr.hasNext();) 
	    {
	            System.out.print(itr.next() + " ");
	    }
	    System.out.println();
	    System.out.println(dq.pop());//1st element
	
	    System.out.println(dq.poll());//1st element
	
	    System.out.println(dq.pollFirst());
	    
	    System.out.println(dq.getLast());
	    dq.clear();
	    
	    dq.offer("Afternoon");//add at last
	    
        // Add at the first
        dq.offerFirst("Good");
	
	    System.out.println(dq.pollLast());
	}
	
}
