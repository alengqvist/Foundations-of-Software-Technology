package arrays;


/** 
 * This class contains a couple of tests for testing Arrays.java
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 22:25, September 7, 2015.
 */
public class ArraysMain {

	/**
	 * Main method which executes when the program starts.
	 * 
	 * @param args  array of strings arguments
	 */
	public static void main(String[] args) {

		// Define and initialize variables.		
		int[] arr = {4,2,5,1,7};

		// Testing Arrays.sum().
		System.out.println("Testing Arrays.sum() -> Sum of " + Arrays.toString(arr) + " is " + Arrays.sum(arr));
		
		// Testing Arrays.toString().
		System.out.println("Testing Arrays.toString() -> String of arr is " + Arrays.toString(arr));
		
		// Testing Arrays.addN().
		System.out.println("Testing Arrays.addN() -> Adding 1 to " + Arrays.toString(arr) + " gives us " + Arrays.toString(Arrays.addN(arr, 1)));
		
		// Testing Arrays.reverse().
		System.out.println("Testing Arrays.reverse() -> Reversing " + Arrays.toString(arr) + " gives us " + Arrays.toString(Arrays.reverse(arr)));
		
		// Testing Arrays.replaceALL().
		System.out.print("Testing Arrays.replaceAll() -> Replacing 6 with 9 from " + Arrays.toString(arr));
		Arrays.replaceAll(arr, 6, 9);
		System.out.println(" gives us " + Arrays.toString(arr));
		
		// Testing Arrays.sort().
		System.out.println("Testing Arrays.sort() -> Sorting " + Arrays.toString(arr) + " gives us " + Arrays.toString(Arrays.sort(arr)));
		
		// Testing Arrays.hasSubsequence().
		int[] sub = {3, 9, 2};
		System.out.print("Testing Arrays.hasSubsequence() -> Does " + Arrays.toString(arr) + " contains " + Arrays.toString(sub) + "?");
		if (Arrays.hasSubsequence(arr, sub)) {
			System.out.println(" - Yes.");
		} else {
			System.out.println(" - No.");
		}
		
		// Testing Arrays.absDif().
        int[] arr2 = {1, 1, 1, 1, 1};
		try {
			System.out.print("Testing Arrays.absDif() -> absDif between " + Arrays.toString(arr) + " and " + Arrays.toString(arr2) + " is " + Arrays.toString(Arrays.absDif(arr, arr2)));
		} catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
		}
	}
}