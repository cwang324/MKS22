import java.util.NoSuchElementException;


public class MyStack<T> {

    MyLinkedList<T> L = new MyLinkedList();

	
	/**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
    	L.add(item);
    };

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return L.remove(size()-1);
    };

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T peek(){
    	if (isEmpty()){
    		throw new NoSuchElementException();
    	}
    	return L.get(size()-1);
    };

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
    	return L.size();
    };

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
    	return L.size()==0;
    };

    public static boolean isMatching(String s){
	MyStack<Character> input = new MyStack<Character>();
	for (int i=0; i < s.length(); i++){
	    input.push(s.charAt(i));
	}
	

	System.out.println(input.L);
	return true;
    }

   


    public static void main(String[] args){
	String input="";
	if(args.length > 0){
	    input = args[0];
	}

	System.out.println(isMatching(input));
    }
}
	
	

