import java.util.*;
@SuppressWarnings("unchecked")


public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       size = 0;
       data = (T[]) new Object[10];
   }

   public MyHeap(T[] array){
       size = array.length;
       data = (T[]) new Object[size+1];
       heapify();
   }

   
   private void swap(int k1, int k2) {
       T tmp = data[k1];
       data[k1] = data[k2];
       data[k2] = tmp;        
   }
   
   
   private void pushDown(int k){

	   while (k*2+1 <= size){
		   int smaller = k*2;
	   
	   
		   if ( ((k*2+1) <= size) &&
			   data[2*k].compareTo(data[2*k+1]) > 0){
			   		smaller = 2*k+1;
		   }
		   
		   if (data[k].compareTo(data[smaller]) > 0){
			   swap(k, smaller);
		   }else{
			   break;
		   }
		   
		   k = smaller;
	   }
	   
   }

   private void pushUp(int k){
       while (k > 1 && data[k/2].compareTo(data[k]) > 0){
    	   swap(k, k/2);
    	   k = k/2;
    	
       }
   }
       

   private void heapify(){
      for (int i = size/2; i > 0; i--){
    	  pushDown(i);
      }
   }
   
   public T peek() {
	   if (size==0){
		   throw new NoSuchElementException();
	   }
	   return data[1];
   }
   
   public T delete(){
	   T removed = peek();
	   data[1] = data[size];
	   data[size]=null;
	   size--;
	   pushDown(1);
	   return removed;	   	   
   }
   
   public void add(T x){
	   if (size==0){
		   data[1] = x;
	   }else if(size >= data.length -1){
		   doubleSize();
	   }else{
		   	data[size+1]=x;
		   	pushUp(size+1);
	   }
	   size++;
   }
   
   private void doubleSize(){
	   T[] newData = Arrays.copyOf(data, data.length * 2);
	   data = newData;
   }
   
   public String toString(){
	   return Arrays.toString(data);
   }

   // //do this last
   // public MyHeap(boolean isMax)
   // public MyHeap(T[] array, boolean isMax)

}