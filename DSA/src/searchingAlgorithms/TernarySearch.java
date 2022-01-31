package searchingAlgorithms;

import java.util.Arrays;

public class TernarySearch {

	public static int ternarySearch(int[] array, int target) {
		Arrays.sort(array);
		return ternarySearch(array, target, 0, array.length-1);
	}
	
	private static int ternarySearch(int[] array, int target, int low, int high) {
		if(low>high) return -1;
		int partitionSize = (high-low)/3;
		int mid1 = low + partitionSize;
		int mid2 = high - partitionSize;
		if(mid1<low || mid2>high) return -1;
		if(array[mid1]==target) return mid1;
		if(array[mid2]==target) return mid2;
		//check on which partition to look for
		if(target<array[mid1]) {
			return ternarySearch(array,target,low,mid1-1);
		}else if(target>array[mid1] && target<array[mid2]) {
			return ternarySearch(array,target,mid1+1,mid2-1);
		}
		return ternarySearch(array,target,mid2+1,high);
	}
	
	public static void main(String[] args) {
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 1));
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 2));
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 3));
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 4));
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 5));
		System.out.println(TernarySearch.ternarySearch(new int[] {1,2,3,4,5}, 70));
	}

}
