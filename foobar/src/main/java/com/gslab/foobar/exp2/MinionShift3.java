package com.gslab.foobar.exp2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinionShift3 {
	
	public static void main(String[] args) {
		int[] data = {1, 2, 2, 3, 3, 3, 4, 5, 5};
		int y = 2;
		int[] answer = answer(data, y);
		
		for (int i : answer) {
			System.out.print(" " + i);
		}
		
	}
    public static int[] answer(int[] data, int n) { 
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	List<Integer> filteredShifts = new ArrayList<Integer>();
    	for (int i = 0; i < data.length; i++) {
    		Integer value = map.get(data[i]);
    		if (value != null) {
    			map.put(data[i], value.intValue() + 1);
			} else {
				map.put(data[i], 1);
			}
		}
    	for (int i : map.keySet()) {
			Integer number = map.get(i);
			if (number <= n) {
				filteredShifts.add(i);
			}
		}
    	
    	return convertIntegers(filteredShifts);
    	
    	
    }
    
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}
