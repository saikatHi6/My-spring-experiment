package org.practice;

public class LongestRepetatingSubSequence {

	public static void main(String[] args) {
		String s = "AABEBCDD";
		System.out.println(lrs(s));
	}

	public static int lrs(String s) {
		String duplicate = s;
		int[][] arr = new int[s.length() + 1][s.length() + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (s.charAt(i-1) == duplicate.charAt(j-1) && i != j) {
					arr[i][j] = 1 + arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		return arr[s.length()][s.length()];
	}

}
