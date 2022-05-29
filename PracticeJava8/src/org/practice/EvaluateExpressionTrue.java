package org.practice;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionTrue {
	
	static Map<String,Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {

		String s = "T^T^T^F|F&F^F|T^F^T";
		System.out.println(validateTrueWithBooleanParenthisis(s, 0, s.length() - 1, true));

	}

	public static int validateTrueWithBooleanParenthisis(String s, int i, int j, boolean isTrue) {

		if (i > j)
			return 0;
		if (i == j) {
			if (isTrue) {
				if (s.charAt(i) == 'T')
					return 1;
				else if (s.charAt(i) == 'F')
					return 0;
			} else {
				if (s.charAt(i) == 'F')
					return 1;
				else if (s.charAt(i) == 'T')
					return 0;
			}
		}
		
		String key = i+"_"+j+"_"+isTrue;
		if(map.containsKey(key)) return map.get(key);
		
		
		
		int result = 0;

		for (int k = i + 1; k < j; k = k + 2) {
			int lt = validateTrueWithBooleanParenthisis(s, i, k - 1, true);
			int lf = validateTrueWithBooleanParenthisis(s, i, k - 1, false);
			int rt = validateTrueWithBooleanParenthisis(s, k + 1, j, true);
			int rf = validateTrueWithBooleanParenthisis(s, k + 1, j, false);

			System.out.println(i + " " + j);
			System.out.println("Left True " + lt);
			System.out.println("Left False " + lf);
			System.out.println("Right True " + rt);
			System.out.println("Right False " + rf);
			System.out.println("================" + s.charAt(k) + "===================");

			if (s.charAt(k) == '&') {
				if (isTrue) {
					result = result + lt * rt;
				} else {
					result = result + lf * rf + lt * rf + lf * rt;
				}
			}
			if (s.charAt(k) == '|') {
				if (isTrue) {
					result = result + lt * rt + lf * rt + lt * rf;
				} else {
					result = result + lf * rf;
				}
			}
			if (s.charAt(k) == '^') {
				if (isTrue) {
					result = result + lt * rf + lf * rt;
				} else {
					result = result + lf * rf + lt * rt;
				}
			}

		}

		map.put(key, result);
		return result;

	}

}
