package org.practice;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class TwoSingleNumbers {

	public static int[] findSingleNumbers(int[] nums) throws InterruptedException{


		int n1xn2 = 0;
		for (int num : nums) {
			n1xn2 ^= num;
		}
		System.out.println(n1xn2);
		System.out.println(Thread.currentThread().getName());
		int[] b = new int[nums.length];
		Arrays.sort(nums);
		int k = 0;
		for(int i=0;i<nums.length-1;i++) {
			System.out.println(Thread.currentThread().getName());
			if((nums[i]^nums[i+1])==0) {
				i++;
			}
			else {
				b[k++] = nums[i];
			}

		}
		System.out.println("Single numbers are: " + b[0] + ", " + b[1]);
		return b;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
		/*
		 * int[] result = TwoSingleNumbers.findSingleNumbers(arr);
		 * System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
		 */

		int[] arr1 = new int[] { 2, 1, 3, 2 };
		/*
		 * result = TwoSingleNumbers.findSingleNumbers(arr1);
		 * System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
		 */
		
		
		CompletableFuture.runAsync(()->{
			try {
				TwoSingleNumbers.findSingleNumbers(arr);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}).runAsync(()->{
			try {
				TwoSingleNumbers.findSingleNumbers(arr1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).join();
		
		
		
			System.out.println("======================================");
		
		
	}
}
