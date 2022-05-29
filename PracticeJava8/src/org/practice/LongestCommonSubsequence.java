package org.practice;

public class LongestCommonSubsequence {

	static int[][] memorizeT;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "abcdgh";
		String s2 = "abedfhr";
		System.out.println(lcsRecursively(s1, s2, s1.length(), s2.length()));

		memorizeT = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < memorizeT.length; i++) {
			for (int j = 0; j < memorizeT.length; j++) {
				memorizeT[i][j] = -1;
			}
		}

		System.out.println(lcsMemorize(s1, s2, s1.length(), s2.length()));

		System.out.println(lcsTopDown(s1, s2, s1.length(), s2.length()));
	}

	public static int lcsRecursively(String s1, String s2, int s1Len, int s2Len) {
		if (s1Len == 0 || s2Len == 0)
			return 0;
		if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
			return 1 + lcsRecursively(s1, s2, s1Len - 1, s2Len - 1);
		} else {
			return Math.max(lcsRecursively(s1, s2, s1Len - 1, s2Len), lcsRecursively(s1, s2, s1Len, s2Len - 1));
		}
	}

	public static int lcsMemorize(String s1, String s2, int s1Len, int s2Len) {
		if (s1Len == 0 || s2Len == 0)
			return 0;

		if (memorizeT[s1Len - 1][s2Len - 1] != -1)
			return memorizeT[s1Len - 1][s2Len - 1];

		else {

			if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
				return memorizeT[s1Len - 1][s2Len - 1] = 1 + lcsRecursively(s1, s2, s1Len - 1, s2Len - 1);
			} else {
				return memorizeT[s1Len - 1][s2Len - 1] = Math.max(lcsRecursively(s1, s2, s1Len - 1, s2Len),
						lcsRecursively(s1, s2, s1Len, s2Len - 1));
			}
		}
	}

	public static int lcsTopDown(String s1, String s2, int s1Len, int s2Len) {
		int[][] topDownTable = new int[s1Len + 1][s2Len + 1];

		for (int i = 1; i < topDownTable.length; i++) {
			for (int j = 1; j < topDownTable[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					topDownTable[i][j] = 1 + topDownTable[i-1][j-1];
				} else {
					topDownTable[i][j] = Math.max(topDownTable[i - 1][j], topDownTable[i][j - 1]);
				}
			}
		}

		return topDownTable[s1Len][s2Len];
	}

}
