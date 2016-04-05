import java.util.NoSuchElementException;

public class MyDeque<T> {

    private static final int DEFAULT_SIZE = 10;
    
	private T[] deck;
	private int start, end, size;

	@SuppressWarnings( { "unchecked" } )
	public MyDeque() {
	    deck = (T[]) new Object[DEFAULT_SIZE];
	}

	@SuppressWarnings( { "unchecked" } )
	private void grow(int newSize) {
		
		int capacity = newSize * 2;
		
		T[] newDeck = (T[]) new Object[capacity];
		int index = 0;
		
		while (!isEmpty())
		{
		   T cur = removeFirst();
		   newDeck[index++] = cur;
		}
		start = 0;
		end = newSize-1;
		deck = newDeck;
		size = capacity;
	}

	public T removeFirst()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		T t = deck[start];
		start = (start + 1) % deck.length;
		return t;
	}
	

	public T removeLast()
	{
		if ( isEmpty())
		{	
			throw new NoSuchElementException();
		}
		T t = deck[end];
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
	
	public static void main(String[] args){


	    MyDeque<String> d = new MyDeque<String>();

	}
	
	
}
