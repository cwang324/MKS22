import java.util.*;

public class MyQueue<T> {
	
	MyLinkedList<T> L;

	/**
     * Adds the given item to the rear of the queue.
     */
    void enqueue(T item){
    	L.add(item);	
    };

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue(){
    	return L.remove(0);
    };

    /**
     * Returns the front item from the queue without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return L.get(0);	
    };

    /**
     * Returns the number of items currently in the queue.
     */
    int size(){
    	return L.size();
    };

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty(){
    	return L.size()==0;
    };
}
	

