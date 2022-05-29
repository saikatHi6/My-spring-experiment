package org.practice;

import java.util.Arrays;

public class SusetSumTest {

	public static void main(String[] args) {

		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");

		int arr[] = { 2, 3, 5, 6, 8, 10 };
		int target = 10;
		System.out.println(countSubsetSum(arr, arr.length, target));

		int minSet[] = { 1, 3, 4, 5 };
		int totalSum = Arrays.stream(minSet).sum();
		System.out.println(minimumSubsetSum(minSet, minSet.length, totalSum));
		
		
		int providedSet[] = { 1, 1, 2, 3 };
		System.out.println(countNumberofSubsetSumOfGivenDiff(providedSet, 1));
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {

		boolean arr[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0)
					arr[i][j] = true;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (set[i - 1] <= j) {
					arr[i][j] = arr[i - 1][j - set[i - 1]] || arr[i - 1][j];
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}

		return arr[n][sum];
	}

	private static int countSubsetSum(int set[], int n, int target) {

		int[][] t = new int[n + 1][target + 1];

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {

				if (j == 0)
					t[i][j] = 1;
			}
		}

		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[i].length; j++) {
				if (set[i - 1] <= j) {
					t[i][j] = t[i - 1][j - set[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}

		return t[n][target];
	}

	private static int minimumSubsetSum(int[] set, int n, int sum) {

		boolean arr[][] = new boolean[n + 1][sum + 1];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (j == 0)
					arr[i][j] = true;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (set[i - 1] <= j) {
					arr[i][j] = arr[i - 1][j - set[i - 1]] || arr[i - 1][j];
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int i = arr.length - 1;

		for (int j = 1; j < arr[i].length / 2; j++) {
			if (arr[i][j]) {
				int curVal = sum - 2 * j;
				min = Math.min(min, curVal);
			}
		}

		return min;
	}
	
	private static int countNumberofSubsetSumOfGivenDiff(int[] set,int diff) {
		int totalSum = Arrays.stream(set).sum();
		int subsetSum = (totalSum - diff)/2;
		return countSubsetSum(set, set.length, subsetSum);
	}

}
