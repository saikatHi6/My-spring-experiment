package org.practice;

public class TestDSConcepts {

	
	static boolean[][] table;
	
	public static void main(String[] args) {
		int[] arr = {1,2,7};
		table = new boolean[arr.length+1][11];
		subSetSum(arr, 10);
		for(int i=0;i<table.length;i++) {
			for(int j=0;i<table[i].length;j++) {
				System.out.print(" "+table[i][j]);
			}
			System.out.println();
		}
	}
	
	public static boolean[][] subSetSum(int[] arr,int sum) {
		for(int i=0;i<table.length;i++) {
			for(int j=0;i<table[i].length;j++) {
				if(i==0)table[i][j] = true;
				else if(j==0)table[i][j] = false;
			}
		}
		for(int i=1;i<table.length;i++) {
			for(int j=1;i<table[i].length;j++) {
				if(arr[i]<=sum)
					table[i][j] = table[i-1][j-arr[i]] || table[i-1][j];
				else
					table[i][j] =  table[i-1][j];
			}
		}
		
		return table;
	}

}
