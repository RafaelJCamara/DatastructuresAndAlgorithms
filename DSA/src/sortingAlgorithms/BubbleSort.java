package sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {

	public static void sort(int[] array) {
		for(int i=0;i<array.length;i++) {
			boolean isSorted = true;
			for(int j=0;j<array.length-1;j++) {
				if(isBiggerThan(array[j], array[j+1])) {
					swap(array, j, j+1);
					isSorted = false;
				}
			}
			if(isSorted) return;
		}
	}
	
	private static boolean isBiggerThan(int firstElement, int secondElement) {
		return firstElement > secondElement;
	}
	
	private static void swap(int[] array, int firstPosition, int secondPosition) {
		int aux = array[firstPosition];
		array[firstPosition] = array[secondPosition];
		array[secondPosition] = aux;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		BubbleSort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
