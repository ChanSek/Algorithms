/**
 * This class is demonstrating how to search a key from an array using binary search algorithm.
 * 
 * NOTE: The integer array should be an sorted array.
 * 
 * @author chansek
 */
public class BinarySearch {

	public static void main (String[] args) {
		int[] values = new int[] {3, 6, 8, 12, 15, 23, 45, 67, 74, 86, 99};
		int key = 67;
		System.out.println("Index of " + key + " is " + findKeyFromSortedArray(key, values));

		// Now lets find the smallest element of a rotated array
		int[] rotatedValues = new int[] {86, 74, 67, 3, 6, 8, 12, 15, 23, 45, 54};
		System.out.println("Index of smallest element is " + findSmallestElementFromRotatedArray(rotatedValues));

		// Lets find the index of any number from the above rotated array
		System.out.println("Index of " + key + " is " + findKeyFromRotatedArray(key, rotatedValues));
	}

	/**
	 * Finds the index of the key from the array using binary search algorithm.
	 * @param key The integer value to be found
	 * @param values Array of integers to be searched from
	 * @return Returns the index of the array where the key found, else returns -1.
	 */
	private static int findKeyFromSortedArray (int key, int[] values) {
		int low = 0, high = values.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key > values[mid]) low = mid + 1;
			else if (key < values[mid]) high = mid - 1;
			else return mid;
		}
		return -1;
	}

	private static int findKeyFromSortedArray (int key, int[] values, int low, int high) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key > values[mid]) low = mid + 1;
			else if (key < values[mid]) high = mid - 1;
			else return mid;
		}
		return -1;
	}

	/**
	 * By saying rotated array means the array is sorted but its elements are shifted to some extend.
	 * For example 1st element is at 2nd, 2nd is at 3rd,... and last is at 1st
	 * Sorted Array - [2, 5, 7, 12, 24, 36, 68]
	 * Rotated Array - [7, 12, 24, 36, 68, 2, 5]
	 * 
	 * @param key The integer value to be found
	 * @param values Rotated array of integers to be searched from
	 * @return Returns the index of the array where the key found, else returns -1.
	 */
	private static int findKeyFromRotatedArray (int key, int[] values) {
		int leastEle = findSmallestElementFromRotatedArray(values);
		if (leastEle == 0) {
			// Its a sorted array
			return findKeyFromSortedArray(key, values);
		} else {
			if (values[leastEle - 1] >= key && values[0] <= key) {
				return findKeyFromSortedArray(key, values, 0, leastEle - 1);
			} else if (values[leastEle + 1] <= key && values[values.length -1] >= key) {
				return findKeyFromSortedArray(key, values, leastEle + 1, values.length - 1);
			} else return leastEle;
		}
	}

	private static int findSmallestElementFromRotatedArray (int[] values) {
		int low = 0, high = values.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (values[mid] < values[low] && values[mid] < values[high]) {
				// Both left and right side elements are larger than the middle element
				// In this case the immediate left element of middle should always be smaller,
				// otherwise the middle one is having the smallest value
				if (values[mid] < values[mid - 1]) return mid;
				else high = mid -1;
			} else if (values[mid] > values[low] && values[mid] > values[high]) {
				// Both left and right side elements are smaller than the middle element
				low = mid + 1;
			} else if (values[mid] < values[low] && values[mid] > values[high]) {
				return high;
			} else if (values[mid] > values[low] && values[mid] < values[high]) {
				return low;
			} else if (high - low == 1) {
				if (values[high] > values[low]) return low;
				else return high;
			} else if (high == low) return low;
		}
		return low;
	}
}
