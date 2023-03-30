package com.zohocorp.collections;

class PriorityQueue 
{ 
		private int[] arr;
		private int nItems;
		public PriorityQueue () 
		{
			arr = new int [10];
			nItems = 0;
		}
		public void insert (int val) 
		{
			int i;
			if (nItems == 0) {
				arr [0] = val;
				nItems++;
				return;
			}
			for (i =nItems - 1; i >= 0; i--) 
			{
				if(val > arr[i]) 
				{
					arr [i+1] = arr[i];
				} 
				else 
				{
					break;
				}
			}
			arr [i+1] = val;
			nItems++;
		}
		public void printPriorityQueue () 
		{
			for (int i = 0; i < nItems; i++)
			{
				System.out.print (arr[i] + " ");
			}
		}
		public int remove () {
			return arr [--nItems];
		}
		public boolean isFull () {
			return nItems == MAX;
		}
		public boolean isEmpty() {
			return nItems == 0;
		}
		public int getPeek () {
			return arr[nItems - 1];
		}
}

public class PriorityQueueExample {

	public static void main(String[] args) 
	{
		PriorityQueue pQueue= new PriorityQueue();
		pQueue.insert(8);
		pQueue.insert(1);
		pQueue.insert(10);
		pQueue.insert(12);
		pQueue.insert(11);
		
		pQueue.printPriorityQueue();
		System.out.println();
		System.out.println(pQueue.remove());
		System.out.println(pQueue.remove());
		pQueue.printPriorityQueue();
		

		
	}

}
