package searchingAlgorithms;

import java.util.Arrays;

public class BinarySearch {

	public static int binarySearchRecursive(int[] array, int target) {
		return binarySearchRecursive(array,target,0,array.length-1);
	}
	
	private static int binarySearchRecursive(int[] array, int target, int low, int high) {
		//sort the original array
		Arrays.sort(array);
		if(high<low) return -1;
		int middle = (low+high)/2;
		if(array[middle]==target) return middle;
		if(target>array[middle]) low = middle+1;
		else high=middle-1;
		return binarySearchRecursive(array,target,low, high);
	}
	
	public static int binarySearchIterative(int[] array, int target) {
		int low = 0;
		int high = array.length -1;
		while(high>=low) {
			int middle = (high+low)/2;
			if(array[middle]==target) return middle;
			if(target>array[middle]) low = middle+1;
			else high=middle-1;
		}
		return -1;
	}
	
	/*
	public static int binarySearchIterative(int[] array, int target) {
		
	}
	*/
	
	public static void main(String[] args) {
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 1));
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 2));
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 3));
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 4));
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 5));
		System.out.println(BinarySearch.binarySearchRecursive(new int[] {1,2,3,4,5}, 70));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 1));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 2));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 3));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 4));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 5));
		System.out.println(BinarySearch.binarySearchIterative(new int[] {1,2,3,4,5}, 70));
	}

}
