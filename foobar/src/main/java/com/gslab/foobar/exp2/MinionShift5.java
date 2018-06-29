package com.gslab.foobar.exp2;

public class MinionShift5 {
	
	public static void main(String[] args) {
		int[] data = {1, 2, 2, 3, 19, 3, 9, 10,10};
		int y = 1;
		int[] answer = answer(data, y);
		
		for (int i : answer) {
			System.out.print(" " + i);
		}
		
	}
    public static int[] answer(int[] data, int n) { 
    	int [][] hashArray = new int [data.length][];
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
//			int number = hashArray[j][1];
    		int number = get(hashArray, data[j]);
			if (number <= n && number != 0) {
				filteredShifts[counter] = getMinionId(hashArray, data[j], 0);
				counter++;
			}
		}
    	return trimFilteredlist(filteredShifts, counter);
    	
    }
    
    private static int getMinionId(int[][] hashArray, int key, int collisionIndex) {
    	int hashCode = getHashCode(key, hashArray.length);
    	
		if (hashArray[hashCode] == null || hashArray[hashCode].length <= 0
				|| hashArray[hashCode].length < ((collisionIndex * 3) + 1)) {
			return 0;
		} else {
			if (hashArray[hashCode][(collisionIndex*3) + 2] != 0 && key != hashArray[hashCode][(collisionIndex*3) + 2]) {
				// not in this bucket, next bucket search;
				return getMinionId(hashArray, key, collisionIndex + 1);
			} else {
				return hashArray[hashCode][(collisionIndex*3) + 2];
			}
		}
    	
	}
    
    
	private static void put(int hashArray[][] , int key, int value) {
		modifyHashArray(hashArray, key, 0);
    }

    private static void modifyHashArray(int hashArray[][] , int key, int collisionIndex) {
    	int hashCode = getHashCode(key, hashArray.length);
    	
    	// Check for length of jagged array
		if (hashArray[hashCode] == null || !(hashArray[hashCode].length >= ((collisionIndex + 1) * 3))) {
			if (hashArray[hashCode] == null ) {
				hashArray[hashCode] = new int[3];
			} else {
				hashArray[hashCode] = increaseSizeOfArray(hashArray[hashCode]);
			}
			
		} 
		
		if (hashArray[hashCode][(collisionIndex*3) + 2] != 0 && key != hashArray[hashCode][(collisionIndex * 3) + 2]) {
			modifyHashArray(hashArray, key, collisionIndex + 1);
		} else {
			int oldValue = hashArray[hashCode][(collisionIndex*3) + 1];
			hashArray[hashCode][(collisionIndex*3) + 0] = hashCode;
			hashArray[hashCode][(collisionIndex*3) + 1] = oldValue + 1;
			hashArray[hashCode][(collisionIndex*3) + 2] = key;
		}
    }
    
    private static Integer getCollisionSafeValue(int hashArray[][] , int key, int collisionIndex) {
    	int hashCode = getHashCode(key, hashArray.length);
    	
		int expectedBucketSize = (collisionIndex + 1) * 3;
		if (hashArray[hashCode] == null || hashArray[hashCode].length <= 0
				|| hashArray[hashCode].length < expectedBucketSize) {
			return 0;
		} else {
			if (hashArray[hashCode][(collisionIndex * 3) + 2] != 0 && key != hashArray[hashCode][(collisionIndex * 3) + 2]) {
				// not in this bucket, next bucket search;
				return getCollisionSafeValue(hashArray, key, (collisionIndex * 3) + 1);
			} else {
				return hashArray[hashCode][(collisionIndex * 3) + 1];
			}
		}
	}
    
    private static Integer get(int hashArray[][] , int key) {
    	return getCollisionSafeValue(hashArray, key, 0);
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
	
	static int[] increaseSizeOfArray(int[] arr) {
		int[] brr = new int[(arr.length + 3)];
		for (int i = 0; i < arr.length; i++) {
			brr[i] = arr[i];
		}
		return brr;
	}


}
