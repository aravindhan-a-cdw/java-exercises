package exercise_1;

public class MyLinkedList<E> {
	
	private int size = 0;
	
	private Node<E> first;
	private Node<E> last;
	
	
	public void insert(E newElement) {
		final Node<E> l = last;
		final Node<E> newNode = new Node<>(l, newElement, null);
		last = newNode;
		if (l == null)
			first = last;
		else
			l.next = last;
		++size;
	}
	
	public int size() {
		return size;
	}
	
	public void remove() {
		last = last.prev;
		size--;
	}
	
	public E peek() {
		return last.element;
	}
	
	public void print() {
		Node<E> current = first;
		
		while(current != null) {
			System.out.println(current.element);
			current = current.next;
		}
	}
	
}


class Node<E>{
	Node<E> prev;
	E element;
	Node<E> next;
	
	public Node(Node<E> prev, E element, Node<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
}
