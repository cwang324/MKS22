import java.util.*;


public class RunningMedian {

	PriorityQueue<Integer> smallValue;
	PriorityQueue<Integer> bigValue;
	int numElements;
	
	public RunningMedian(){
	    smallValue = new PriorityQueue<Integer>();
		bigValue = new PriorityQueue<Integer>();
	}
		
	public double getMedian(){
		if (numElements==0){
			throw new NoSuchElementException();
		}
		if (smallValue.size() > bigValue.size()){
			return smallValue.peek();
		}else{
			return (( smallValue.peek() + bigValue.peek()) / 2 );
		}
	}
	
	
	public void add(Integer x){
		if (numElements==0){
			smallValue.add(x);
		}else if(x <= getMedian()){
			smallValue.add(x);
		}else{
			bigValue.add(x);
		}
		
		int removed;
		if (smallValue.size() - bigValue.size() > 1){
			removed = smallValue.poll();
			bigValue.add(removed);
		}else{
			removed = bigValue.poll();
			smallValue.add(removed);
		}
	}
}
