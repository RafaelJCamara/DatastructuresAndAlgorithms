package searchingAlgorithms;

import java.util.Arrays;

public class JumpSearch {

	public static int jumpSearch(int[] array, int target) {
		Arrays.sort(array);
		int blockSize = (int) Math.floor(Math.sqrt(array.length));
		int start = 0;
		int next = start + blockSize;
		
		//first find the possible block where the value might be
		while(start < array.length && array[next-1]<target) {
			start = next;
			next = start + blockSize;
			if(next>array.length) next = array.length;
		}
		
		//linear search in that block
		for(int i=start;i<next;i++) {
			if(array[i]==target) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(JumpSearch.jumpSearch(new int[] {}, 1));
		System.out.println(JumpSearch.jumpSearch(new int[] {1,2,3,4,5,6,7,8,9,10}, 2));
		System.out.println(JumpSearch.jumpSearch(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
		System.out.println(JumpSearch.jumpSearch(new int[] {1,2,3,4,5,6,7,8,9,10}, 6));
		System.out.println(JumpSearch.jumpSearch(new int[] {1,2,3,4,5,6,7,8,9,10}, 10));
		System.out.println(JumpSearch.jumpSearch(new int[] {1,2,3,4,5,6,7,8,9,10}, 70));
	}

}
