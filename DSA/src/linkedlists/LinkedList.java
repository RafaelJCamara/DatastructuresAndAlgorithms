	package linkedlists;

import java.util.Arrays;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {}
	
	//addFirst
	public void addFirst(int item) {
		//check if head is null (if so, list is empty, new element is head of list)
		//if not just add normally
		Node newNode = new Node(item);
		if(this.isListEmpty()) this.initList(newNode);
		else {
			newNode.addNextLink(head);
			head = newNode;
		}
		this.size++;
	}
		
	//addLast
	public void addLast(int item) {
		Node newNode = new Node(item);
		if(this.isListEmpty()) {
			this.initList(newNode);
		}else {
			tail.addNextLink(newNode);
			tail = newNode;
		}
		this.size++;
	}
	
	//deleteFirst
	public void deleteFirst() {
		if(head==null) throw new IllegalStateException("List is empty!");
		if(head==tail) head=tail=null;
		else {
			Node newHead = head.getNextNode();
			head.addNextLink(null);
			head = newHead;
		}
		this.size--;
	}
	
	//deleteLast
	public void deleteLast() {
		if(head==null) throw new IllegalStateException("List is empty!");
		
		if(head==tail) head=tail=null;
		else {
			Node aux = head;
			while(aux.getNextNode().getNextNode()!=null) {
				aux = aux.getNextNode();
			}
			aux.addNextLink(null);
			tail = aux;
		}
		this.size--;
	}
	
	//contains
	public boolean contains(int element) {
		return this.indexOf(element)!=-1;
	}
	
	//indexOf
	public int indexOf(int element) {
		Node aux = head;
		int count = 0;
		while(aux!=null) {
			if(aux.getCurrentNodeValue()==element) return count;
			aux = aux.getNextNode();
			count+=1;
		}
		return -1;
	}
	
	//size
	public int size() {
		return this.size;
	}
	
	//toArray
	public int[] toArray() {
		if(head==null) throw new IllegalStateException("List is empty");
		int[] newArray = new int[this.size];
		Node aux = head;
		int count = 0;
		while(aux!=null) {
			newArray[count++] = aux.getCurrentNodeValue();
			aux = aux.getNextNode();
		}
		return newArray;
	}
	
	
	//reverse linked lists
	public void reverse() {
		if(head==null) throw new IllegalStateException("Can't invert an empty list!");
		Node previous = null;
		Node current = head;
		while(current!=null) {
			Node aux = current.getNextNode();
			current.addNextLink(previous);
			previous = current;
			current = aux;
		}
		tail = head;
		head = previous;
	}
	
	
	//kth node from the end
	public int kthFromEnd(int k) {
		if(this.isListEmpty()) throw new IllegalStateException("List is empty.");
		if(k<0 || k>size) throw new IllegalStateException("k is not in between the list size.");
		
		Node a = head;
		Node b = head;
		
		//place second pointer at the right distance
		for(int i=0;i<k-1;i++) {
			b = b.getNextNode();
		}
		
		//move both pointers
		while(b!=this.tail) {
			a = a.getNextNode();
			b = b.getNextNode();
		}
		
		return a.getCurrentNodeValue();
	}

	
	//print middle element
	public void printMiddleElement() {
		if(this.isListEmpty()) throw new IllegalArgumentException("");
		Node first = head;
		Node second = head;
		while(second.getNextNode()!=null && second.getNextNode().getNextNode()!=null) {
			first = first.getNextNode();
			second = second.getNextNode().getNextNode();
		}
		System.out.println("Middle: "+first.getCurrentNodeValue());
	}
	
	
	/*
	 * Utils
	 * */
	
	//print list
	public void print() {
		Node aux = head;
		System.out.println("Begin list print");
		while(aux!=null) {
			System.out.println("Value:"+aux.getCurrentNodeValue());
			aux = aux.getNextNode();
		}
		System.out.println("End list print");
	}
	
	//checks if list is empty
	private boolean isListEmpty() {
		return head==null;
	}
	
	//init empty list
	private void initList(Node newNode) {
		head = newNode;
		tail = newNode;
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addLast(4);
		list.addLast(5);
		list.deleteFirst();
		list.deleteLast();
		list.addLast(6);
		list.addLast(7);
		//list.addFirst(8);
		list.print();
		list.printMiddleElement();
		//list.reverse();
		//list.print();
		//System.out.println(list.kthFromEnd(3));
		//System.out.println(list.size());
		//System.out.println(Arrays.toString(list.toArray()));
		//System.out.println(list.contains(1));
		//System.out.println(list.contains(0));
		//System.out.println(list.indexOf(1));
		//list.print();
	}

}
