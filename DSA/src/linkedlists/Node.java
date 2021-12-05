package linkedlists;

public class Node {
	
	private int value;
	private Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public int getCurrentNodeValue() {
		return this.value;
	}
	
	public Node getNextNode() {
		return this.next;
	}
	
	public void addNextLink(Node nextLink) {
		this.next = nextLink;
	}
	
}
