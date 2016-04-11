import java.util.NoSuchElementException;
import java.util.*;


public class FrontierQueue<T> implements Frontier<T>{
	
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

	public Queue<T> frontier;
	public T current;

	
	public FrontierQueue(){
		frontier = new Queue<T>();
	}
	
	public void add(T element) {
		frontier.push(element);
	}



	public boolean hasNext() {
		return (! frontier.empty() );
	}

	

	public T next() {
		Stack<T> copy = (Queue<T>) frontier.clone();
		
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T value = copy.pop();
		current = copy.peek();
		return value;
	}

	
	
}