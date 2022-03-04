package sortingAlgorithms;

import java.util.Arrays;

public class Quicksort {

	
	public static void sort(int[] array) {
		sort(array, 0, array.length-1);
	}
	
	private static void sort(int[] array, int start, int end) {
		
		//base condition
		if(start>=end) return;
		
		//Partition
		int bound = partition(array, start, end);
		
		//Sort left
		sort(array, start, bound-1);
		
		//Sort right
		sort(array, bound+1, end);
	}
	
	private static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int b = start -1;
		for(int i=start;i<=end;i++) {
			if(array[i]<=pivot) {
				//add to left partition
				swap(array, ++b, i);
			}
		}
		
		return b;
	}
	
	private static void swap(int[] array, int firstPosition, int secondPosition) {
		int aux = array[firstPosition];
		array[firstPosition] = array[secondPosition];
		array[secondPosition] = aux;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1};
		Quicksort.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
