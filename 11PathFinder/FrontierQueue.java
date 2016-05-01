import java.util.ArrayDeque;

public class FrontierQueue<T> implements Frontier<T>{
	public ArrayDeque<T> data;

	public FrontierQueue(){
		data = new ArrayDeque<T>();
	}

	public void add(T element){
		data.addLast(element);
	}

	public T next(){
		return data.removeFirst();
	}

	public boolean hasNext(){
		if (data.size() == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	
}