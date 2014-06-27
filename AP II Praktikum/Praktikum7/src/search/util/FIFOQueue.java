package search.util;

import java.util.LinkedList;

public class FIFOQueue<T> implements IQueue<T> {

	// Instanzvariablen
	LinkedList<T> meineLinkedList = new LinkedList<T>();
	
	@Override
	public void put(T p) {
		meineLinkedList.addLast(p);
	}

	@Override
	public T get() {
		return meineLinkedList.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		return meineLinkedList.size() == 0;
	}

	@Override
	public void clear() {
		meineLinkedList.clear();
	}
}
