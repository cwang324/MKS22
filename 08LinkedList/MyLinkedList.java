import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

	public Iterator<T> iterator() {
		return new MyLinkedListIteratorThingy();
	}

	public class MyLinkedListIteratorThingy implements Iterator<T> {

		private LNode<T> next;

		public MyLinkedListIteratorThingy() {
			next = head;
		}

		public boolean hasNext() {
			return next != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T ans = next.getValue();
			next = next.getNext();
			return ans;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private LNode<T> head;
	private LNode<T> end;

	int size;

	public String toString() {

		String retString = "[ ";
		LNode<T> current = head;

		while (current != null) {
			retString += current.getValue();
			if (current.getNext() != null) {
				retString += ", ";
			}
			current = current.getNext();
		}
		retString += " ]";
		return retString;
	}

	public String toString(boolean b) {

		String retString = "[ ";
		LNode<T> current = head;

		while (current != null) {
			retString += current.getValue();
			if (current.getNext() != null) {
				retString += ", ";
			}
			current = current.getNext();
		}
		retString += " ]";
		if (b) {
			retString += "\t head:" + head.getValue() + "\t end:"
					+ end.getValue();
		}
		return retString;
	}

	private class LNode<T> {
		private T value;
		private LNode<T> next;

		public LNode(T value) {
			this.value = value;
		}

		public LNode() {
		}

		// accessors
		public T getValue() {
			return value;
		}

		public LNode<T> getNext() {
			return next;
		}

		// mutators
		public void setValue(T newValue) {
			value = newValue;
		}

		public void setNext(LNode<T> newNext) {
			next = newNext;
		}
	}

	public boolean add(T value) {
		if (head == null) {
			head = new LNode<T>(value);
			end = head;
			size++;
		} else {

			LNode<T> p = end;
			end = new LNode<T>(value);
			p.setNext(end);
			size++;
		}
		return true;
	}

	// return the number of elements in the list
	public int size() {
		return size;
	}

	// get the value of the element at the specified index (0 based)
	public T get(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LNode<T> p = head;
		while (index > 0) {
			p = p.getNext();
			index--;
		}
		return p.getValue();
	}

	// change the value of the element at the specified index to the newValue,
	// return the old value
	public T set(int index, T newValue) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		LNode<T> p = head;
		for (int i = 0; i < index; i++) {
			p = p.getNext();
		}
		T oldValue = p.getValue();
		p.setValue(newValue);
		return oldValue;
	}

	// remove the element at the specified index, returns the value removed
	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Please enter a valid index.");
		}

		// set return value to first value
		T oldValue = head.getValue();

		// removing from front
		LNode<T> p = head;
		if (index == 0) {
			head = p.getNext();

		} else {

			// go through list
			for (int i = 0; i < index - 1; i++) {
				p = p.getNext();

			}
			oldValue = p.getNext().getValue();
			if (index == size() - 1) {
				end = p;
			}
			// else{
			p.setNext(p.getNext().getNext());
			// }

		}
		size--;
		return oldValue;
	}

	// insert a new element at the specified index, 0 at the front, size() at
	// the end
	public boolean add(int index, T value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Please enter a valid index.");
		}
		LNode<T> p = head;
		if (head == null || index == 0) {
			head = new LNode<T>(value);
			head.setNext(p);
			size++;
		} else if (index == size) {
			add(value);
		} else {
			for (int i = 0; i < index - 1; i++) {
				p = p.getNext();
			}
			LNode<T> nextNode = p.getNext();
			p.setNext(new LNode<T>(value));
			p.getNext().setNext(nextNode);
			size++;
			if (index == size()) {
				end = p.getNext();
			}

		}
		return true;
	}

	// returns the index of the 1st occurrence of the value in the linked list,
	// -1 if not found
	public int indexOf(T value) {
		int index = -1;
		LNode<T> p = head;
		for (int i = 0; i < size(); i++) {
			if (p.getValue().equals(value)) {
				return i;
			}
			p = p.getNext();
		}
		return index;
	}

	public static void main(String[] args) {

		MyLinkedList<Integer> n = new MyLinkedList<Integer>();

		for (int i = 0; i < 20; i++) {
			n.add(i);
		}

		Iterator<Integer> it = n.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");

		}
		System.out
				.println("----------------------TESTING------------------------");
		System.out.println(n);
		System.out.println(n.remove(1));
		System.out.println(n);
	}

}
