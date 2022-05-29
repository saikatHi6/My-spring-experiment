package org.practice;

public class EggDroppingProblem {

	public static void main(String[] args) {
		System.out.println(minimumAttemtReqToGetThreasoldValue(10, 2));
	}

	public static int minimumAttemtReqToGetThreasoldValue(int floor, int eggs) {

		if (floor == 1 || floor == 0)
			return floor;
		if (eggs == 1)
			return floor;

		int minAttemt = Integer.MAX_VALUE;

		for (int i = 1; i <= floor; i++) {
			int tempThreasold = 1 + Math.max(minimumAttemtReqToGetThreasoldValue(i - 1, eggs - 1),
					minimumAttemtReqToGetThreasoldValue(floor - i, eggs));

			minAttemt = Math.min(minAttemt, tempThreasold);
		}

		return minAttemt;
	}

}
