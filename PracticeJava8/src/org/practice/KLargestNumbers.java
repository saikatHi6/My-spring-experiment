package org.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KLargestNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
	    System.out.println("Here are the top K numbers: " + result);

	    result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
	    System.out.println("Here are the top K numbers: " + result);
	}

	private static List<Integer> findKLargestNumbers(int[] is, int i) {

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1,n2)-> n1-n2);
		
		for (int j = 0; j < i; j++) {
			queue.add(is[j]);
		}
		
		/*
		 * for (int j = i; j < is.length; j++) { if(is[j]>queue.peek()) { queue.poll();
		 * queue.add(is[j]); } }
		 */
		
		Arrays.stream(is, i, is.length).filter(e->e>queue.peek()).forEach(e->{
			queue.poll();
			queue.add(e);
		});
		/*
		 * List<Integer> list = new ArrayList<Integer>(); for (int j=i;j>0;j--) {
		 * list.add(queue.poll()); }
		 */
		
		return new ArrayList<Integer>(queue);
	}
	
	
	

}
