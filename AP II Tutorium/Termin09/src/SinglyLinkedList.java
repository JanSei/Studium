public class SinglyLinkedList<T> {

	private int size = 0;
	
	private static class Node<T> {
		private T value;
		private Node<T> next;

		private Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	Node<T> first = null;

	public boolean contains(T obj) {
		Node<T> p = first;
		while (p != null && !p.value.equals(obj)) {
			p = p.next;
		}
		return p != null ? true : false;
	}

	public void addLast(T obj) {
		Node<T> p = first;
		Node<T> q = null;
		if (first == null)
			first.value = obj;
		else {
			while (p != null) {
				p = p.next;
				q = p;
			}
			q.next = new Node(obj, null);
		}
		size++;
	}

	public boolean remove(T obj) {
		Node<T> p = first;
		Node<T> q = null;
		while (p != null && !p.value.equals(obj)) {
			q = p; 
			p = p.next;
		}
		if(p == first) {
			first = first.next;
			size--;
			return true;
		}
		if(p != null) {
			q.next = p.next;
			size--;
			return true;
		}
		else 
			return false;
	}

}
