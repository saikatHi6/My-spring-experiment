package org.practice;

public class MatrixChainMultiplication {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 2, 3, 4, 3 };
		System.out.println(mcm(arr, 1, arr.length - 1));
		System.out.println(MatrixChainOrder(arr, 1, arr.length - 1));
	}

	public static int mcm(int[] arr, int i, int j) {
		int min = Integer.MAX_VALUE;

		if (i >= j)
			return 0;

		for (int k = i; k <= j - 1; k++) {
			int temp = mcm(arr, i, k) + mcm(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			if (temp < min) {
				min = temp;
			}
		}

		return min;
	}

	static int MatrixChainOrder(int p[], int i, int j) {
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		// place parenthesis at different places between
		// first and last matrix, recursively calculate
		// count of multiplications for each parenthesis
		// placement and return the minimum count
		for (int k = i; k < j; k++) {
			int count = MatrixChainOrder(p, i, k) + MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}

		// Return minimum count
		return min;
	}
}
