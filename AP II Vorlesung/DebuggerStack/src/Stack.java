// ENTHAELT EINEN FEHLER
import java.util.NoSuchElementException;

public class Stack<T> {
	
	//Instanzvariablen
	private int top;
	private T[] data = newArray(3);
	
	//Konstruktoren
	
	
	// Methoden
	public Stack<T> push(T x) {
		checkStorage();
		data[top++] = x;
		return this;
	}
	
	public T pop() {
		if (isEmpty())
			throw new NoSuchElementException();
		T r = data[--top];
		data[top] = null;
		return r;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("[");
		if (!isEmpty()) b.append(data[0]);
		for (int i = 1; i < top; i++)
			b.append(",").append(data[i]);
		return b.append("]").toString();
	}
	
	private void checkStorage() {
		if (top == data.length) {
			T[] newData = newArray(2 * data.length);
			for (int i = 0; i < data.length; i++)
				newData[i] = data[i];
			data = newData;
		}
	}
	
	@SuppressWarnings("unchecked")
	private T[] newArray(int size) {
		return (T[]) new Object[size];
	}

}
