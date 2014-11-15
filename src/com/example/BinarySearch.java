package com.example;

/**
 * This class is demonstrating how to search a key from an array using binary search algorithm.
 * 
 * NOTE: The integer array should be an sorted array.
 * 
 * @author chansek
 *
 */
public class BinarySearch {

	public static void main (String[] args) {
		int[] values = new int[] {3, 6, 8, 12, 15, 23, 45, 67, 74, 86};
		int key = 86;
		System.out.println("Index of " + key + " is " + search(key, values));
	}

	/**
	 * Finds the index of the key from the array using binary search algorithm.
	 * @param key The integer value to be found
	 * @param values Array of integers to be searched from
	 * @return Returns the index of the array where the key found, else returns -1.
	 */
	private static int search (int key, int[] values) {
		int low = 0, high = values.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key > values[mid]) low = mid + 1;
			else if (key < values[mid]) high = mid - 1;
			else return mid;
		}
		return -1;
	}
}
