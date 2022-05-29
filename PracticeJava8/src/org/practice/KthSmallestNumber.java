package org.practice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
	    System.out.println("Kth smallest number is: " + result);

	    // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
	    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
	    System.out.println("Kth smallest number is: " + result);

	    result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
	    System.out.println("Kth smallest number is: " + result);
	}

	private static int findKthSmallestNumber(int[] is, int i) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1,n2)-> n2-n1);
		Arrays.stream(is, 0, i).forEach(e->maxHeap.add(e));
		Arrays.stream(is, i, is.length).filter(e->e<maxHeap.peek()).forEach(e->{
			maxHeap.poll();
			maxHeap.add(e);
		});
		
		return maxHeap.peek();
	}

}
