package org.practice;

public class MinimumPalindromicPartition {

	static int[][] arr = null;

	public static void main(String[] args) {

		String s = "nitin";

		arr = new int[s.length() + 1][s.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				arr[i][j] = -1;
			}
		}

		System.out.println(palindromicPartition(s, 0, s.length() - 1));
	}

	public static int palindromicPartition(String s, int i, int j) {
		if (i >= j)
			return 0;

		if (isPalindromic(s, i, j))
			return 0;

		if (arr[i][j] != -1)
			return arr[i][j];

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {

			int temp1, temp2 = 0;
			if (arr[i][k] != -1) {
				temp1 = arr[i][k];
			} else {
				temp1 = palindromicPartition(s, i, k);
			}
			if (arr[k + 1][j] != -1) {
				temp2 = arr[k + 1][j];
			} else {
				temp2 = palindromicPartition(s, k + 1, j);
			}

			int temp = 1 + temp1 + temp2;

			if (temp < min)
				min = temp;
		}

		return arr[i][j] = min;
	}

	private static boolean isPalindromic(String s, int i, int j) {

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

}
