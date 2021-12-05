package arrays;

public class Array {

	private int[] items;
	private int count;
	
	public Array(int size){
		this.items = new int[size];
		this.count = 0;
	}
	
	//insert (dynamic)
	public void insert(int item) {
		//check if array is full
		//if full: resize to double
		if(count==items.length) {
			resize();
		}
		items[count++] = item;
	}
	
	
	private void resize() {
		int[] aux = items;
		items = new int[count*2];
		for(int i=0;i<count;i++) items[i] = aux[i];
	}
	
	//removeAt
	public void removeAt(int index) {
		if(index<0) throw new IllegalArgumentException("Please provide a positive index");
		if(index>count) throw new IllegalArgumentException("Please provide a valid index");
		for(int i=index;i<count;i++) items[i] = items[i+1];
		count-=1;
	}
	
	
	//indexOf
	public int indexOf(int element) {
		for(int i=0;i<count;i++) {
			if(items[i]==element) return i;
		}
		return -1;
	}
	
	
	//max value
	public int max() {
		int currentMax = Integer.MIN_VALUE;
		for(int item:items) {
			if(item>currentMax) currentMax=item;
		}
		return currentMax;
	}
	
	//common items between lists
	public Array commonItems(Array array) {
		Array common = new Array(count);
		for(int item : items) {
			if(array.indexOf(item)!=-1) common.insert(item);
		}
		return common;
	}
	
	//reverse
	public void reverse() {
		int i=0,j=count-1;
		while(j>i) {
			int aux = items[i];
			items[i++] = items[j];
			items[j--] = aux;
		}
	}
	
	//insert at index
	public void insertAt(int item,int index) {
		System.out.println("Length: "+items.length);
		if(index<0 || index>=count) throw new IllegalArgumentException("Please provide a valid index");
		if(count==items.length) {
			//resize needed
			this.resize();
		}
		//shift values to the right of chosen index
		for(int i=count;i>index;i--) {
			items[i]=items[i-1];
		}
		this.items[index] = item;
		count+=1;
	}
	
	//print array
	public void print() {
		for(int i=0;i<count;i++) {
			System.out.println(items[i]);
		}
	}
	
	public static void main(String[] args) {
		Array array = new Array(2);
		array.insert(1);
		array.insert(2);
		array.insertAt(4, 1);
		//array.removeAt(0);
		//array.reverse();
		//System.out.println(array.max());
		array.print();
	}

}
