import java.util.NoSuchElementException;
import java.util.*;

public class MyStack<T> {

	MyLinkedList<T> L;
	
	public MyStack(){
	    L = new MyLinkedList<T>();
	}

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

    public static void main (String[] args){

	MyStack<Integer> mine = new MyStack<Integer>();
	Stack<Integer> real = new Stack<Integer>();
	
	for (int i=0; i < 1000000; i++){
	    mine.push(i);
	    real.push(i);
	}

	//	while(!mine.isEmpty()){

	if (!(mine.peek().equals(real.peek()))){
		System.out.println("peek broken");
	    }

	if (!(mine.pop().equals(real.pop()))){
		System.out.println("pop broken");

	    }
	    //	}

    }
}
	
	

