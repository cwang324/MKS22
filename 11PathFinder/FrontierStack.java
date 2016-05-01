
import java.util.Stack;

public class FrontierStack<T> implements Frontier<T>{
	private Stack<T> data;

	public FrontierStack(){
		data = new Stack<T>();
	}

	public void add(T element){
		data.push(element);
	}

	public T next(){
		return data.pop();
	}

	public boolean hasNext(){
		return !data.empty();
	}

}
