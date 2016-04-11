import java.util.*;

import javax.xml.soap.Node;



public class FrontierStack<T> implements Frontier<T>{

	Stack<T> frontier;
	T current;

	
	public FrontierStack(){
	    frontier = new Stack<T>();
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


