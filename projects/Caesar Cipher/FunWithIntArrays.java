/** Header Comment.
 *  Name: Rui Yan
 *  Login: cs8bwaka
 *  Date: January 12, 2016
 *  File: FunWithIntArrays.java
 *  Sources of Help: None
 * */


public class FunWithIntArrays {

	public static int findMax(int[] array) {
		//short circuit protects null access
		if (array == null || array.length == 0)
			return -1;

		int max = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			} 
		} 
		return max;
	}

	// return the smallest element in the input array
	public static int findMin(int array[]) {
		//short circuit protects null access
		if (array == null || array.length == 0)
			return -1;

		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	// return a copy of the input array
	public static int[] arrayCopy(int[] array) {
		if (array == null)
			return null;

		int[] result = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			result[i] = array[i];
		}
		return result;
	}

	// output the elements of the input array
	public static void printArray(int[] array) {
		if (array == null)
			return;

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}

		System.out.println();
	}

	// return a sorted copy of the input array
	public static int[] arraySort(int[] array) {
		if (array == null)
			return null;

		int[] result = arrayCopy(array);
		//call method arrayCopy and make a copy array of the array

		for (int i = 0; i < array.length - 1; ++i) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (result[j] > result[j + 1]) {
					//swapping result[j] and result[j+1]
					int temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
				}
			}
		}
		return result;
	}
}
