package mySinglyLinkedList;

public class mySinglyLinkedList<E> {

	Node head;

	public class Node{
		E data;
		Node next;
		public Node() {
			data = null;
			next = null;
		}
		public Node(E newData, int index) {
			Node current = head;
			int counter = 0;
			while(counter != index) {
				current = current.next;
			}
			data = newData;
			this.next = current.next;
			current.next = this;
		}
	}

	public void addFirst(E item) {
		Node newNode = new Node();
		newNode.data = item;
		if(head == null) {
			head = new Node();
			head.next = newNode;
			return;
		}

		newNode.next = head.next;
		head.next = newNode;
		return;
	}

	public void addLast(E item) {
		Node newNode = new Node();	
		newNode.next = null;
		newNode.data = item;
		Node tail = head;
		while(tail.next != null)
			tail = tail.next;
		tail.next = newNode;
		return;			
	}

	public int size() {
		if(head.next == null) {
			return 0;
		}
		int counter = 1;
		Node current = head.next;
		while(current.next != null) {
			counter++;
			current = current.next;
		}	
		return counter;
	}

	public void addNew(E item, int index) {
		if(index < 0 || index > size()) {
			System.out.println("Invalid");
			return;
		}
		Node newNode = new Node();
		newNode.data = item;
		newNode.next = null;

		if(index == 0) {
			addFirst(item);
		}else if(index == size()){
			addLast(item);
		}else {
			Node tempHead = head;
			for(int i = 0; i < index; i++) {
				tempHead = tempHead.next;
			}
			newNode.next = tempHead.next;
			tempHead.next = newNode;
		}
	}

	void deleteFirst(){
		if(head == null) {
			return;
		}	
		if(head != null) {
			head = head.next;
		}
	}

	void deleteLast() {
		Node newNode = head;	
		Node end = null;
		while(newNode.next != null) {
			end = newNode;
			newNode = newNode.next;	
		}
		end.next = null;
	}

	void delete(int index) {
		if(index < 0 || index > size()) {
			System.out.println("Not valid");
			return;
		}
		if(index == 0) {
			deleteFirst();
		}else if(index == size()){
			deleteLast();
		}else {	
			Node tempHead = head;
			Node deletedNode = null;
			for(int i = 0; i < index; i++) {
				tempHead = tempHead.next;
			}
			deletedNode = tempHead.next;
			tempHead.next = deletedNode.next;
			System.out.println("Deleted: " + deletedNode.data);
			deletedNode = null;
		}
	}

	void change(E item, int index) {

		Node current = head.next;
		int counter = 0;
		while(counter != index){
			current = current.next;
			counter++;
		}
		current.data = item;
	}

	public void traverse () {
		Node current = head.next;
		while(current.next != null) {
			System.out.println(current.data);
			current = current.next;
		}
		System.out.print(current.data);
		return;
	}

	public static void main(String[] args){

		mySinglyLinkedList <Integer> list1 = new mySinglyLinkedList<Integer>();
		System.out.println("List after adding first:");
		list1.addFirst(1);
		list1.addFirst(2);
		list1.addFirst(3);
		list1.traverse();
		System.out.println("\n");
		
		System.out.println("List after adding last:");
		list1.addLast(6);
		list1.addLast(7);
		list1.addLast(8);
		list1.traverse();
		System.out.println("\n");

		System.out.println("List after adding to a specified index:");
		list1.addNew(10, 3);
		list1.traverse();
		System.out.println("\n");

		System.out.println("List after removing first:");
		list1.deleteFirst();
		list1.traverse();
		System.out.println("\n");
		
		System.out.println("List after removing last:");
		list1.deleteLast();
		list1.traverse();
		System.out.println("\n");
		
		System.out.println("List after removing at specified index:");
		list1.delete(4);
		list1.traverse();
		System.out.println("\n");

		System.out.println("List after chaning the value of specified index:");
		list1.change(14, 2);
		list1.traverse();



	}
}