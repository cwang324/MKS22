
import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
	public static final int DEFAULT_HEAP_SIZE = 11;

	private int size;
	private T[] data;
	private boolean isMax = true;

	public MyHeap() {
		data = (T[]) new Comparable[DEFAULT_HEAP_SIZE];
	}

	public MyHeap(T[] array) {
		initData(array);
		heapify();
	}

	public MyHeap(boolean isMax) {
		data = (T[]) new Comparable[9];
		size = 0;
		this.isMax = isMax;
	}

	public MyHeap(T[] array, boolean isMax) {
		initData(array);
		this.isMax = isMax;
		heapify();
	}

	private void initData(T[] array) {
		size = array.length;
		data = (T[]) new Comparable[size + 1];
		System.arraycopy(array, 0, data, 1, size);
	}

	

	private void pushDown(int pos) {

		boolean done = false;
		int i = pos;
		int j = 2 * pos;
		T save = data[i];

		if (this.isMax) {
			while (j <= size && !done) {
				if (j < size) {
					if (data[j].compareTo(data[j + 1]) < 0)
						j = j + 1;
				}

				if (save.compareTo(data[j]) > 0)
					done = true;
				else {
					data[i] = data[j];
					i = j;
					j = 2 * i;
				}
			}
			data[i] = save;
		} else {
			while (j <= size && !done) {
				if (j < size) {
					if (data[j].compareTo(data[j + 1]) > 0)
						j = j + 1;
				}

				if (save.compareTo(data[j]) < 0)
					done = true;
				else {
					data[i] = data[j];
					i = j;
					j = 2 * i;
				}
			}
			data[i] = save;
		}
	}

	private void pushUp(int pos) {
		T save = data[pos];

		int k = pos;
		int j = pos / 2;

		if (this.isMax) {			
			while ( j >= 1 && data[j].compareTo(save) < 0) {
				data[k] = data[j];
				k = j;
				j /= 2;
			}

		} else {
			while (data[j].compareTo(save) > 0) {
				data[k] = data[j];
				k = j;
				j /= 2;
			}
		}
		data[k] = save;
	}

	
	private void heapify() {
		for (int i = size / 2; i > 0; i--) {
			pushDown(i);
		}
	}

	public T delete() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		T ans = data[1];
		int counter = 1;
		int k = 1;
		data[1] = null;
		pushDown(1);
		size--;
		return ans;
	}

	public T peek() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[1];
	}

	public void add(T x) {
		if (size == 0) {
			data[1] = x;
			size++;
		} else {
			if (size + 1 >= data.length) {
				doubleSize();
			}
			data[size + 1] = x;
			size++;

			pushUp(size);
		}
	}

	private void doubleSize() {
		T[] doubled = (T[]) new Comparable[(data.length - 1) * 2 + 1];
		for (int i = 1; i <= size; i++) {
			doubled[i] = data[i];
		}
		data = doubled;
	}

	public String toString() {
        return Arrays.toString(data);		
	}

	
	public static void main(String[] args) {

		Integer[] data1 = { 2, 4, 6, 8, 10, 12 };
		MyHeap<Integer> x = new MyHeap<>(data1);
		System.out.println(x);
		
		x.add(13);
		System.out.println(x);
		
		
		
//
//		Integer[] data2 = { 6, 5, 4, 3, 2, 1 };
//		MyHeap<Integer> y = new MyHeap<>(data2, false);
//		System.out.println(y);

		
//		 MyHeap<Integer> a = new MyHeap<>();
//		 a.add(1);
//		 a.add(4);
//		 a.add(3);
//		 a.add(9);
//		 a.add(5);
//		 a.add(6);
//		 a.add(7);
//		 a.add(8);
//		 a.add(1);
//		 a.add(2);
//		 a.add(7);
//		 a.add(5);
//		 a.add(2);
//		 a.add(3);
//		 a.add(2);
//		 System.out.println(a);
//		 a.delete();
//		 System.out.println(a);
//		 System.out.println();
		//
		// Integer[] intA = {1,2,5,7,4,8,0};
		// /*MyHeap<Integer> b = new MyHeap<>(intA);
		// System.out.println(b);
		// b.add(10);
		// b.add(20);
		// System.out.println(b);
		// b.delete();
		// System.out.println(b);
		// b.delete();
		// System.out.println(b);*/
		//
		// MyHeap<Integer> c = new MyHeap<>(false);
		// /*c.add(7);
		// c.add(6);
		// c.add(5);
		// c.add(4);
		// c.add(3);
		// c.add(2);
		// c.add(1);
		// c.add(17);
		// c.add(16);
		// c.add(15);
		// c.add(14);
		// c.add(13);
		// c.add(12);
		// c.add(11);
		// System.out.println(c);
		// c.delete();
		// System.out.println(c);*/
		//
		// Integer[] intB = {8,7,6,5,4,3,2};
		// MyHeap<Integer> d = new MyHeap<>(intB, false);
		// /*d.add(17);
		// d.add(16);
		// d.add(15);
		// d.add(14);
		// d.add(13);
		// d.add(12);
		// d.add(11);
		// d.add(10);
		// System.out.println(d);
		// d.delete();
		// System.out.println(d);*/
		//
	}
}