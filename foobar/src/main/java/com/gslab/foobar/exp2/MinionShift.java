package com.gslab.foobar.exp2;

public class MinionShift {
	
	public static void main(String[] args) {
		int[] data = {1, 2, 2, 3, 3, 3, 4, 5, 5};
		int y = 2;
		int[] answer = answer(data, y);
		
		for (int i : answer) {
			System.out.print(" " + i);
		}
		
	}
    public static int[] answer(int[] data, int n) { 
    	
    	int length = data.length;
    	int[] modifiedShifts = new int [length];
    	int[] orignalShifts = data;
    	
    	for (int i = 0; i < length; i++) {
			int index = data[i] % length;
			data[index] += length;
		}
    	
    	int counter = 0;
    	for (int i = 0; i < length; i++) {
			int j = data[i]/length;
			if (j < n) {
				modifiedShifts[counter] = orignalShifts[i];
				counter++;
			} else {
//				System.out.println(i);
			}
		}
    	
    	return modifiedShifts;
    }


}
