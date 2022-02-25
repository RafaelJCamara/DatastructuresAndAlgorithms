package sortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] array) {
		for(int i=1;i<array.length;i++) {
			//insert in correct position
			insertElementInSortedArray(array, array[i], i);
		}
	}
	
	private static void insertElementInSortedArray(int[] array, int element, int startingIndex) {
		for(int i=startingIndex; i>0 && element<array[i-1];i--) {
			swap(array, i, i-1);
		}
	}
	
	private static void swap(int[] array, int firstPosition, int secondPosition) {
		int aux = array[firstPosition];
		array[firstPosition] = array[secondPosition];
		array[secondPosition] = aux;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		InsertionSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
