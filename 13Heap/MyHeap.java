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

   private void heapify(){
       

   }
   // public T delete()
   // public void add(T x)
   // private void doubleSize()
   // public String toString()

   // //do this last
   // public MyHeap(boolean isMax)
   // public MyHeap(T[] array, boolean isMax)

}
