import java.util.NoSuchElementException;

public class MyDeque<T> {

    private static final int DEFAULT_SIZE = 10;
    
	private Object[] deck;
	private int start, end, size;

	@SuppressWarnings( { "unchecked" } )
	public MyDeque() {
	    deck = (T[]) new Object[DEFAULT_SIZE];
	}

	
	private void grow(int newSize) {
		
		int capacity = newSize * 2;
		Object[] newDeck = new Object[capacity];
		int index = 0;
		
		while (!isEmpty())
		{
		   Object cur = removeFirst();
		   newDeck[index++] = cur;
		}
		start = 0;
		end = newSize-1;
		deck = newDeck;
		size = capacity;
	}

	public Object removeFirst()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		Object t = deck[start];
		start = (start + 1) % deck.length;
		return t;
	}
	

	public Object removeLast()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		Object t = deck[end];
		start = ( end - 1 + deck.length ) % deck.length;
		return t;
	}

	
	public T getFirst()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		
		return deck[start];
	}
	

	public T getLast()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		return deck[end];
	}
	
	public void addFirst(T value) {
		growIfNecessary();		
		int newIndex = (start - 1 + deck.length) % deck.length;
		deck[newIndex] = value;
		start = newIndex;
		size++;
	}

	
	public void addLast(T value) {
		growIfNecessary();		
		int newIndex = (end + deck.length) % deck.length;
		deck[newIndex] = value;
		end = newIndex;
		size++;
	}
	
	
	public int size()
	{
		return size;
	}
	
	
	private boolean isEmpty ()
	{
		return size == 0;
	}
	
	private boolean isFull()
	{
		return size == deck.length;
	}
	
	private void growIfNecessary()
	{
	    if ( isFull())
	    {
	       grow(size);    	
	    }
	}
	
/*
 0b. You need a private method to grow the array and copy over the values. 
There are 6 public methods:
1. void addFirst(T value)
2. void addLast(T value)
-When the array is full, re-size, then add. 
-No exceptions are required since you will re-size.

3. T removeFirst()  
4. T removeLast()  
-NoSuchElementException is thrown when there are no elements. 

5. T getFirst()
6. T getLast()
-NoSuchElementException is thrown when there are no elements. 	
 */
	
	
}
