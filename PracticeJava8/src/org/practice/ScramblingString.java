package org.practice;

import java.util.HashMap;
import java.util.Map;

public class ScramblingString {
	
	static int[][] arr = null;
	
	static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "knxhpkpcogzwrwdyfksw";
		String b = "fpsprgdywowkckhzxnkw";		
		
		arr = new int[a.length() + 1][a.length() + 1];

		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				arr[i][j] = -1;
			}
		}
		System.out.println(solve(a, b));

	}

	public static int solve(String a, String b) {
		if (a.compareTo(b) == 0)
			return 1;
		if (a.length() <= 1)
			return 0;
		/*
		 * int i = a.length()-1; int j = b.length()-1; if (arr[i][j] != -1) return
		 * arr[i][j];
		 */
		String key = a+"_"+b;
		if(map.containsKey(key))
			return map.get(key);
		
		int flag = 0;
		int size = a.length();
		for (int k = 1; k <= size - 1; k++) {
			if ((solve(a.substring(0, k), b.substring(size - k, size)) == 1
					&& solve(a.substring(k, size), b.substring(0, size - k)) == 1)
					|| ((solve(a.substring(0, k), b.substring(0, k)) == 1
							&& solve(a.substring(k), b.substring(k)) == 1))) {
				flag = 1;
				return flag;
			}
		}
		map.put(key, flag);
		return flag;

	}

}
