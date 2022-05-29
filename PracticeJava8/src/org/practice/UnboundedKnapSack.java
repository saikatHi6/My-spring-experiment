package org.practice;

import java.util.Arrays;

public class UnboundedKnapSack {

	public static void main(String[] args) {
		int price[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		int length[] = new int[price.length];
		Arrays.setAll(length, i -> i + 1);
		System.out.println(rodCuttingProblem(price, length));
		int[] coins = {1,2,3};
		System.out.println(maxNoOfWays(coins, 5));
	}

	public static int rodCuttingProblem(int[] cost, int length[]) {

		int size = cost.length;

		int[][] arr = new int[size + 1][size + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (i <= j) {
					arr[i][j] = Math.max(cost[i - 1] + arr[i][j - i], arr[i - 1][j]);
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}

		return arr[size][size];

	}

	public static int maxNoOfWays(int[] coins, int sum) {

		int arr[][] = new int[coins.length + 1][sum + 1];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(i>0 && j==0)
					arr[i][j] = 1;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (coins[i - 1] <= j) {
					arr[i][j] = arr[i][j - coins[i - 1]] + arr[i - 1][j];
				} else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}

		return arr[coins.length][sum];
	}
	
	
	public static int minNoOfCoins(int[] coins, int sum) {
		int arr[][] = new int[coins.length + 1][sum + 1];
	
		return arr[coins.length][sum];
	}
	

}
