package sortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

	public static void sort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			//find lowest element and place in i position
			int lowest_index = i;
			for(int j=i+1;j<array.length;j++) {
				if(isSmallerThan(array[j], array[lowest_index]))  lowest_index = j;
			}
			swap(array,i,lowest_index);
		}
	}
	
	private static boolean isSmallerThan(int firstElement, int secondElement) {
		return firstElement < secondElement;
	}
	
	private static void swap(int[] array, int firstPosition, int secondPosition) {
		int aux = array[firstPosition];
		array[firstPosition] = array[secondPosition];
		array[secondPosition] = aux;
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		SelectionSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
