package arrays;

import java.util.stream.IntStream;


/** 
 * This class has a couple of static methods in which an array of integers can me manipulated.
 *
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 23:15, September 7, 2015.
 */
public class Arrays {
	
	/**
	 * Adds all elements together in the array and computes the sum.
	 * 
	 * @param arr	the array to sum
	 * @return		the sum of all integers in the array
	 */
	public static int sum(int[] arr) {

// Enough?
		return IntStream.of(arr).sum();
		
// Otherwise.
/*		
        int sum = 0;
        for(int n : arr) {
            sum += n;
        } 
        return sum;
 */
	}
	
	/**
	 * Returns a string which, if printed, provides a nice looking print out of the array content.
	 * 
	 * @param arr	the array to transform
	 * @return		a pretty String
	 */
	public static String toString(int[] arr) {
		
        StringBuilder sb = new StringBuilder();

		sb.append("[");
		
		for (int i = 0; i < arr.length; i++) {
			
            if(i != 0) {
                sb.append(", ");
            }
            sb.append(arr[i]);
		}
		
        sb.append("]");

		return sb.toString();
	}
	
	/**
	 * Returns an array where we have added the number n to all elements in the array.
	 * 
	 * @param arr	the array which we will add the number to
	 * @param n		the number to add into the array
	 * @return 		the updated array
	 */
	public static int[] addN(int[] arr, int n) {				
		for (int i = 0; i < arr.length; i++) {
			arr[i] += n;
		}
		return arr;
	}
	
	/**
	 * Reverses the order of an cloned array.
	 * 
	 * @param arr	the array to reverse
	 * @return		the new array in reversed order from the old one.
	 */
	public static int[] reverse(int[] arr) {
		
		int[] reversedArray = arr.clone();

		for(int i = 0; i < reversedArray.length / 2; i++)
		{
		    int temp = reversedArray[i];
		    reversedArray[i] = reversedArray[reversedArray.length - i - 1];
		    reversedArray[reversedArray.length - i - 1] = temp;
		}
		return reversedArray;
	}

	/**
	 * Replaces all occurrences of the element old with nw in an array.
	 * 
	 * @param arr	the array to replace the element in
	 * @param old	the old value
	 * @param nw	the new value
	 */
	public static void replaceAll(int[] arr, int old, int nw) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == old) {
				arr[i] = nw;
			}
		}
	}
	
	/**
	 * Sorts an cloned array (least element first).
	 * 
	 * @param arr	the array to sort
	 * @return		the new sorted array
	 */
	public static int[] sort(int[] arr) {
		int[] sortedArray = arr.clone();
		
		// The bubble method is used for sorting.
	    for (int i = 0; i < sortedArray.length; i++) {
	        for (int j = i + 1; j < sortedArray.length; j++) {
	            int tmp = 0;
	            if (sortedArray[i] > sortedArray[j]) {
	                tmp = sortedArray[i];
	                sortedArray[i] = sortedArray[j];
	                sortedArray[j] = tmp;
	            }
	        }
	    }
	    return sortedArray;
	}
	
	/**
	 * Checks if the subsequence sub is a part of the array.
	 * 
	 * @param arr	the array to check in
	 * @param sub	the subsequence
	 * @return		if array contains the subsequence
	 */
	public static boolean hasSubsequence(int[] arr, int[] sub) {
		
		boolean hasSubsequence = false;
		
		for (int i = 0; i < arr.length; i++) {
			
			// If the first sub index was found in the array.
			if (arr[i] == sub[0]) {
				
				hasSubsequence = true;
				
                for(int j = 0; j < sub.length; j++) {
                	
                	// If the subsequence still exists through the rest of the sub indexes.
                    if(arr[i+j] != sub[j]) {
                    	hasSubsequence = false;
                		break;
                    }
                }
                
                if(hasSubsequence == true) {
                    break;
                }
			}
		}
		return hasSubsequence;
	}
		
	/**
	 * Creates an array which is the absolute difference between two arrays.
	 * 
	 * @param arr1	the first array
	 * @param arr2	the second array
	 * @return		the new array which is the absolute difference between arr1 and arr2
	 */
	public static int[] absDif(int[] arr1, int[] arr2) {

		// If the arrays are of different sizes.
		if(arr1.length != arr2.length) {
            throw new IllegalArgumentException("Different sizes!");
        }
		
		// Create the new array.
        int[] absDif = new int[arr1.length];
        
        // Basically arr1 - arr2 on each index.
        for(int i = 0; i < arr1.length; i++) {
        	absDif[i] = Math.abs(arr1[i] - arr2[i]);
        }
        return absDif;
	}
}