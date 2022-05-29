package org.practice;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcde";
		String s2 = "ababcde";

		System.out.println(lcsTopDown(s1, s2, s1.length(), s2.length()));
	}

	public static int lcsTopDown(String s1, String s2, int s1Len, int s2Len) {
		int[][] topDownTable = new int[s1Len + 1][s2Len + 1];
		int maxSubString = 0;
		for (int i = 1; i < topDownTable.length; i++) {
			for (int j = 1; j < topDownTable[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					topDownTable[i][j] = 1 + topDownTable[i - 1][j - 1];
					maxSubString = Math.max(maxSubString, topDownTable[i][j]);
				} else {
					topDownTable[i][j] = 0;
				}
			}
		}

		return maxSubString;
	}

}
