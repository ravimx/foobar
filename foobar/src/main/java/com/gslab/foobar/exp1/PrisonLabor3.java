package com.gslab.foobar.exp1;

public class PrisonLabor3 {

	public static void main(String[] args) {
		int[] x = { 14, 27, 1, 4, 2, 50, 3, 1 };
		int[] y = { 2, 4, -4, 3, 1, 1, 14, 27, 50 };
		System.out.println(answer(x, y));
	}

	public static int answer(int[] x, int[] y) {
		
		int[] marker = new int [y.length];
		for (int i : x) {
			boolean isCommon = false;
			for (int j = 0; j < y.length; j++) {
				if (i == y[j]) {
					isCommon = true;
					marker[j] = -111111;
					break;
				}
			}
			if (!isCommon) {
				return i;
			}
		}
		
		for (int j = 0; j < y.length; j++) {
			if (marker[j] != -111111) {
				return y[j];
			}
		}
		return -111111;
	}
}