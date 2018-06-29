package com.gslab.foobar.exp2;

import java.util.HashMap;
import java.util.Map;

public class MinionShift2 {
	
	public static void main(String[] args) {
		int[] data = {1, 2, 3};
		int y = 0;
		int[] answer = answer(data, y);
		
		for (int i : answer) {
			System.out.print(" " + i);
		}
		
	}
    public static int[] answer(int[] data, int n) { 
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int [] filteredShifts = new int[2];
    	for (int i = 0; i < data.length; i++) {
    		Integer value = map.get(data[i]);
    		if (value != null) {
    			map.put(data[i], value.intValue() + 1);
			} else {
				map.put(data[i], 1);
			}
		}
    	int counter = 0;
    	for (int i : map.keySet()) {
			Integer number = map.get(i);
			if (number < n) {
				if (counter == filteredShifts.length) {
					filteredShifts = increaseSizeOfArray(filteredShifts);
				}
				filteredShifts[counter] = i;
				counter++;
			}
		}
    	
    	return filteredShifts;
    	
    	
    }
    
	static int[] increaseSizeOfArray(int[] arr) {
		int[] brr = new int[(arr.length * 2)];
		for (int i = 0; i < arr.length; i++) {
			brr[i] = arr[i];
		}
		return brr;
	}


}
