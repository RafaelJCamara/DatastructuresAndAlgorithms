package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] array) {
		
		if(array.length<2) return;
		
		//divide array in half
		int middle = array.length/2;
		
		int[] left = new int[middle];
		
		for(int i=0;i<middle;i++) left[i] = array[i];
		
		int[] right = new int[array.length - middle];
		
		for(int i=middle;i<array.length;i++) right[i-middle]=array[i];
		
		//sort each half
		sort(left);
		sort(right);
		
		//merge sorted parts
		merge(left,right,array);
	}
	
	private static void merge(int[] left, int[] right, int[] result) {
		int leftIndex = 0, rightIndex = 0, resultIndex = 0;
		
		while(leftIndex<left.length && rightIndex<right.length) {
			if(left[leftIndex]<=right[rightIndex]) result[resultIndex++] = left[leftIndex++];
			else result[resultIndex++] = right[rightIndex++];
		}
		
		while(leftIndex<left.length) {
			result[resultIndex++] = left[leftIndex++];
		}
		
		while(rightIndex<right.length) {
			result[resultIndex++] = right[rightIndex++];
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		MergeSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
