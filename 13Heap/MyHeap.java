import java.util.*;
@SuppressWarnings("unchecked")


public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       size = 0;
       data = (T[]) new Object[9];
   }

   public MyHeap(T[] array){
       size = array.length;
       data = (T[]) new Object[size+1];


   }

   private void pushDown(int k){
       T temp = data[k];
       data[k] = data[2*k];
       data[2*k] = temp;
   }

   private void pushUp(int k){
       T temp = data[k];
       data[k] = data[k/2];
       data[k/2] = temp;
   }
       

   private void heapify(){
       int index = 1;
       while (index >= 1 && index <= size/2){
    	   if (data[index].compareTo(data[index*2])<0 || data[index].compareTo(data[index*2+1]) < 0 ){
    		   if ( data[index].compareTo(data[index*2]) < 0 ){
    			   pushDown(index);
    			   
    		   }   		   
    	   }
    	   index++;
       }
   }
   
   public T delete(){
	   T removed = data[1];
	   data[1] = data[size];
	   heapify();
	   size--;
	   return removed;	   	   
   }
   
   public void add(T x){
	   if (size==0){
		   data[1] = x;
	   }else{
		   	data[size+1]=x;
		   	heapify();
	   }
	   size++;
   }
   // private void doubleSize()
   // public String toString()

   // //do this last
   // public MyHeap(boolean isMax)
   // public MyHeap(T[] array, boolean isMax)

}