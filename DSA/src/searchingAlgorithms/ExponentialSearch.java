package searchingAlgorithms;

import java.util.Arrays;

public class ExponentialSearch {

	public static int search(int[] array, int target) {
		if(array.length==0) return -1;
		
		int lower_bound = 1;
		int higher_bound = 1;
	
		//find the right range
		while(higher_bound<array.length-1 && array[higher_bound]<target) {
			lower_bound = higher_bound;
			higher_bound = higher_bound * 2;
			if(higher_bound>=array.length) higher_bound = array.length - 1;
		}
		
		//binary search in such range
		return binarySearchRecursive(array, target, lower_bound, higher_bound);
	}
	
	private static int binarySearchRecursive(int[] array, int target, int low, int high) {
		if(high<low) return -1;
		int middle = (low+high)/2;
		if(array[middle]==target) return middle;
		if(target>array[middle]) low = middle+1;
		else high=middle-1;
		return binarySearchRecursive(array,target,low, high);
	}
	
	public static void main(String[] args) {
		System.out.println(ExponentialSearch.search(new int[] {}, 1));
		System.out.println(ExponentialSearch.search(new int[] {1,2,3,4,5,6,7,8,9,10}, 2));
		System.out.println(ExponentialSearch.search(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
		System.out.println(ExponentialSearch.search(new int[] {1,2,3,4,5,6,7,8,9,10}, 6));
		System.out.println(ExponentialSearch.search(new int[] {1,2,3,4,5,6,7,8,9,10}, 10));
		System.out.println(ExponentialSearch.search(new int[] {1,2,3,4,5,6,7,8,9,10}, 70));
	}

}
