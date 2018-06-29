package com.gslab.foobar.exp2;

public class MinionShift4 {
	
	public static void main(String[] args) {
		int[] data = {124, 224, 224, 324, 324, 324, 424, 524, 524};
		int y = 1;
		int[] answer = answer(data, y);
		
		for (int i : answer) {
			System.out.print(" " + i);
		}
		
	}
    public static int[] answer(int[] data, int n) { 
    	int [][] hashArray = new int [data.length][3];
    	int [] filteredShifts = new int[data.length];
    	for (int i = 0; i < data.length; i++) {
    		Integer value = get(hashArray, data[i]);
    		if (value != null && value != 0) {
    			put(hashArray,data[i], value.intValue());
			} else {
				put(hashArray,data[i], 0);
			}
		}
    	
    	int counter = 0;
    	for (int j = 0; j < data.length; j++) {
			int number = hashArray[j][1];
			if (number <= n && number != 0) {
				filteredShifts[counter] = hashArray[j][2];
				counter++;
			}
		}
    	return trimFilteredlist(filteredShifts, counter);
    	
    }
    
    private static void put(int hashArray[][] , int key, int value) {
    	int length = hashArray.length;
		int hashCode = getHashCode(key, length);
    	hashArray[hashCode][0] = hashCode;
    	hashArray[hashCode][1] = value + 1;
    	hashArray[hashCode][2] = key;
    }
    
    private static Integer get(int hashArray[][] , int key) {
    	int length = hashArray.length;
    	int hashCode = getHashCode(key, length);
    	return hashArray[hashCode][1];
    }
	private static int getHashCode(int key, int length) {
		int hashCode = Integer.hashCode(key) % length;
		return hashCode;
	}
	
	private static int[] trimFilteredlist (int [] array, int targetLength) {
		int[] newArray = new int[targetLength];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = array[i];
		}
		
		return newArray;
	}

}
