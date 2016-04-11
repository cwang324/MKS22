import java.util.NoSuchElementException;
import java.util.*;


public class FrontierQueue<T> implements Frontier<T>{
	
    /***Make This Work This Weekend!***/
    /***You can use your classes or built in ones***/
    /***You can extend another class OR wrap around it***/

	public MyQueue<T> frontier;


	
	public FrontierQueue(){
		frontier = new MyQueue<T>();
	}
	
	public void add(T element) {
		frontier.push(element);
	}



	public boolean hasNext() {
		return (! frontier.empty() );
	}

	

	public T next() {
		
		
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T value = frontier.pop();
		return value;
	}

	
	
}
