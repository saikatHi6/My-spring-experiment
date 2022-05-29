package org.practice;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "acbcf";
		System.out.println(scs(s1, s2));
	}

	public static String scs(String s1, String s2) {

		String finalScs = "";

		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					arr[i][j] = 1 + arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}

		int i = s1.length();
		int j = s2.length();

		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				finalScs = finalScs + s1.charAt(i - 1);
				i--;
				j--;
			} else {
				if (arr[i - 1][j] < arr[i][j - 1]) {
					finalScs = finalScs + s2.charAt(j - 1);
					j--;
				} else {
					finalScs = finalScs + s1.charAt(i - 1);
					i--;
				}
			}
		}

		while (i > 0) {
			finalScs = finalScs + s1.charAt(i - 1);
			i--;
		}
		while (j > 0) {
			finalScs = finalScs + s2.charAt(j - 1);
			j--;
		}

		return finalScs;
	}

}
