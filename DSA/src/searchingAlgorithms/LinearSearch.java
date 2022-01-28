package searchingAlgorithms;

public class LinearSearch {

	public static int search(int[] array, int element) {
		for(int i=0;i!=array.length;i++) {
			if(array[i]==element) return i;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		System.out.println(LinearSearch.search(new int[] {1,2,3,4,5}, 0));
		System.out.println(LinearSearch.search(new int[] {1,2,3,4,5}, 1));
		System.out.println(LinearSearch.search(new int[] {1,2,3,4,5}, 5));
		System.out.println(LinearSearch.search(new int[] {1,2,3,4,5}, 6));
	}

}
