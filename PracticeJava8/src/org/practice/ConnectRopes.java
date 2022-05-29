package org.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopes {

	public static int minimumCostToConnectRopes(int[] ropeLengths) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2)-> n1-n2);
		Arrays.stream(ropeLengths).forEach(e->minHeap.add(e));
		int sum = 0;
		
		minHeap.forEach(e->{
			if(minHeap.size()>1) {
			int c = minHeap.poll() + minHeap.poll();
			minHeap.add(c);
			}
			
		});
		
		
		return sum;
	}

	public static void main(String[] args) {
		int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
		System.out.println("Minimum cost to connect ropes: " + result);
		result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
		System.out.println("Minimum cost to connect ropes: " + result);
	}


}
