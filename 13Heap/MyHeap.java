import java.util.*;
@SuppressWarnings("unchecked")


public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;

   public MyHeap(){
       size = 0;
       data = (T[]) new Comparable[9];
   }

   public MyHeap(T[] array){
       size = array.length;
       data = (T[]) new Comparable[size+1];
       for (int i = 1; i < array.length; i++){
	   data[i] = array[i-1];
       }
       heapify();
   }

   private void pushDown(int k){
       T temp = data[k];
       data[k] = data[2*k+1];
       data[2*k] = temp;
   }

   private void pushUp(int k){
       T temp = data[k];
       data[k] = data[k/2];
       data[k/2] = temp;
   }
       

   private void heapify(){
       int index = 1;
       heapifyH(1);
   }

   private void heapifyH(int index){
       if (index>=1 && index <= size/2){
	   
	   if (data[index].compareTo(data[index*2])<0 ||
	       data[index].compareTo(data[index*2+1]) < 0 ){

	       if ( data[index].compareTo(data[index*2]) < 0 ){
		   pushDown(index);
		   heapifyH(index*2);
	       }else{
		   pushDown(index);
		   heapifyH(index*2+1);
	       }

	   }
    	
       }		   
    	        
   }
   
   public T delete(){
	   T removed = data[1];
	   data[1] = data[size];
	   for (int i=1; i<size; i=i*2+1){
	       pushDown(i);
	   }
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

   private void doubleSize(){
       T[] doubleData = (T[]) new Comparable[size*2];
       for (int i=1; i<size; i++){
	   doubleData[i] = data[i];
       }
       data = doubleData;
   }

   public String toString(){
       String retString = "[ ";
       for (T value : data){
	   retString += value + " ";
       }
       retString += "]";
       return retString;
   }

   // //do this last
   // public MyHeap(boolean isMax)
   // public MyHeap(T[] array, boolean isMax)

}
