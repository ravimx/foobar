package com.gslab.foobar.exp1;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrisonLabor {

	public static void main(String[] args) {
		
		int[] x = {14, 27, 1, 4, 2, 50, 3, 1};
		int[] y = {2, 4, -4, 3, 1, 1, 14, 27, 50};

		List<Integer> shiftX = Arrays.stream(x).boxed().collect(Collectors.toList());
		List<Integer> shiftY = Arrays.stream(y).boxed().collect(Collectors.toList());
		
		List<Integer> firstShiftCheck = shiftX.stream()
	            .filter(e -> !shiftY.contains(e))
	            .collect(Collectors.toList());
		
		if (firstShiftCheck != null && !firstShiftCheck.isEmpty()) {
			if (firstShiftCheck != null && !firstShiftCheck.isEmpty()) {
				System.out.println(firstShiftCheck.get(0));
			}
		} else {
			List<Integer> secondShiftCheck = shiftY.stream()
					.filter(e -> !shiftX.contains(e))
					.collect(Collectors.toList());
			
			if (secondShiftCheck != null && !secondShiftCheck.isEmpty()) {
				System.out.println(secondShiftCheck.get(0));
			}
		}
		
		
	}

}
