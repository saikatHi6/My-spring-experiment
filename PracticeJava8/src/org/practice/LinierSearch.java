package org.practice;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinierSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {20,50,10,30,15,100,70,40,10,120,105,10};
		System.out.print(search(10, list));
		System.out.print(find(list,10));
		
		String A[] = {"cba","daf","ghi"};
		minDeletionSize(A);
		
	}

	public static int search(Integer n, int[] list) {


		return IntStream.range(0, list.length).filter(i-> (list[i]==n)).findFirst().orElse(-1);
	}
	// Function to find the index of an element in a primitive array in Java
	public static int find(int[] a, int target)
	{
		return Arrays.stream(a) 					// IntStream
				.boxed()						// Stream<Integer>
				.collect(Collectors.toList())   // List<Integer>
				.indexOf(target);
	}
	
	
	public static int minDeletionSize(String[] A) {
        int ans = 0;
        
        Arrays.stream(A, 0, A[0].length()).forEach(s->{
        	int count =0;
        	filterArray(s,s+1,A,count);
        	count++;
        });
        
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }
        
        return ans;
    }

	private static int filterArray(String string, String string2,String[] A,int c) {
		int ans = 0;
		for (int r = 0; r < A.length - 1; ++r)
            if (A[r].charAt(c) > A[r+1].charAt(c)) {
                ans++;
                break;
            }
		return ans;
	}
	
	
	
	
	
}
