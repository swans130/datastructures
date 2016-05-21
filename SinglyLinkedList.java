public class SinglyLinkedList {

	private class Node {

		Node next;
		Object data;

		public Node (Object _data) {
			next = null;
			data = _data;
		}

		public Node (Object _data, Node _next) {
			next = _next;
			data = _data;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object _data) {
			data = _data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node _next) {
			next = _next;
		}
	}

	private Node head;
	private int listCount;

	public SinglyLinkedList() {

		head = new Node(null);
		listCount = 0;

	}

	//add element to the end of the list
	public void addToEnd(Object data) {

		Node temp = new Node(data);
		Node current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(temp);
		++listCount;

	}

	//add element at specified index
	public void addToIndex(Object data, int index) {

		Node temp = new Node(data);
		Node current = head;

		for (int i = 1; i < index && current.getNext() != null; ++i) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		++listCount;

	}

	//returns element at specified index
	public Object get(int index) {

		if (index <= 0) {
			return null;
		}

		Node current = head.getNext();
		for (int i = 1; i < index; ++i) {
			if(current.getNext() == null) {
				return null;
			}
			current = current.getNext();
		}
		return current.getData();

	}

	//remove element at specified index
	public boolean remove(int index) {

		if(index < 1 || index > size()) {
			return false;
		}

		Node current = head;
		for(int i = 1; i < index; ++i) {
			if(current.getNext() == null) {
				return false;
			}
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		--listCount;
		return true;

	}

	//returns number of elements in the list
	public int size() {

		return listCount;

	}

	public String toString() {

		Node current = head.getNext();
		String output = "";
		while (current != null) {
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;

	}

}

//http://www.mycstutorials.com/articles/data_structures/linkedlists