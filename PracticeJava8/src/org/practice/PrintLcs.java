package org.practice;

public class PrintLcs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdgh";
		String s2 = "abedfhr";

		System.out.println(lcsTopDown(s1, s2, s1.length(), s2.length()));
	}

	public static String lcsTopDown(String s1, String s2, int s1Len, int s2Len) {
		int[][] topDownTable = new int[s1Len + 1][s2Len + 1];

		for (int i = 1; i < topDownTable.length; i++) {
			for (int j = 1; j < topDownTable[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					topDownTable[i][j] = 1 + topDownTable[i - 1][j - 1];
				} else {
					topDownTable[i][j] = Math.max(topDownTable[i - 1][j], topDownTable[i][j - 1]);
				}
			}
		}
		int i = s1Len;
		int j = s2Len;

		String subSeq = "";

		while (i > 0 && j > 0) {
			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				subSeq = subSeq + s1.charAt(i-1);
				i--;
				j--;
			} else {
				if (topDownTable[i][j - 1] == topDownTable[i - 1][j]) {
					i--;
				} else {
					if (topDownTable[i][j - 1] > topDownTable[i - 1][j]) {
						j--;
					} else {
						i--;
					}
				}
			}
		}

		return subSeq;
	}

}
