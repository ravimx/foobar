package com.gslab.foobar.exp1; 

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrisonLabor2 {   
	
	public static void main(String[] args) {
		int[] x = {};
		int[] y = {};
		System.out.println(answer(x, y));
		
		String bytes = "CAAaNAoyVXNlIG9mIHJlc3RyaWN0ZWQgY2xhc3MgamF2YS51dGlsLnN0cmVhbS5JbnRTdHJlYW0";
		
		byte[] bytes2 = bytes.getBytes();
		System.out.println(bytes2);
	}
    public static int answer(int[] x, int[] y) { 
        List<Integer> shiftX = Arrays.stream(x).boxed().collect(Collectors.toList());
		List<Integer> shiftY = Arrays.stream(y).boxed().collect(Collectors.toList());
		
		List<Integer> firstShiftCheck = shiftX.stream()
	            .filter(e -> !shiftY.contains(e))
	            .collect(Collectors.toList());
		
		if (firstShiftCheck != null && !firstShiftCheck.isEmpty()) {
			if (firstShiftCheck != null && !firstShiftCheck.isEmpty()) {
				return firstShiftCheck.get(0);
			}
		} else {
			List<Integer> secondShiftCheck = shiftY.stream()
					.filter(e -> !shiftX.contains(e))
					.collect(Collectors.toList());
			
			if (secondShiftCheck != null && !secondShiftCheck.isEmpty()) {
				return secondShiftCheck.get(0);
			}
		}
		return 1;

    } 
}