import java.util.NoSuchElementException;


public class MyStack<T> {

	MyLinkedList<T> L;
	
	/**
     * Adds the given item to the top of the stack.
     */
    void push(T item){
    	L.add(0, item);
    };

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T pop(){
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return L.remove(0);
    };

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return L.get(0);
    };

    /**
     * Returns the number of items currently in the stack.
     */
    int size(){
    	return L.size();
    };

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty(){
    	return L.size()==0;
    };
}
	
	

