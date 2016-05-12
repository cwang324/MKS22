import java.util.*;
@SuppressWarnings("unchecked")


public class MyHeap<T extends Comparable<T>>
{
   private int size;
   private T[] data;
   private boolean isMax;

   public MyHeap(){
       size = 0;
       data = (T[]) new Comparable[10];
       isMax = true;
   }

   public MyHeap(T[] array){
       size = array.length;
       data = (T[]) new Comparable[size+1];
       isMax = true;
       heapify();
   }

   public MyHeap(boolean isMax){
	   this();
	   this.isMax = isMax;
   }
   
   public MyHeap(T[] array, boolean isMax){
	   this(array);
	   this.isMax = isMax;
	   
   }
   
   private void swap(int k1, int k2) {
       T tmp = data[k1];
       data[k1] = data[k2];
       data[k2] = tmp;        
   }
   
   
   private void pushDown(int k){
	   if (isMax){
		   pushDownMax(k);
	   }else{
		   pushDownMin(k);
	   }  
   }
   
   private void pushDownMin(int k){
       int smaller = k*2;
	   while (k*2+1 <= size){
		  
	   
	   
		   if ( data[2*k+1]!=null && data[2*k].compareTo(data[2*k+1]) > 0){
			   	smaller = 2*k+1;
				swap(k,smaller);
		   }else{
		       swap(k,smaller);
		       k=2*k;
		   }
		   
		   if (k*2<=size){
		       swap(k,smaller);
		   }
	   }
   }

   private void pushDownMax(int k){

       int larger = 2*k;
	   while (k*2+1 <= size){
		   
	   
	   
		   if (	data[2*k].compareTo(data[2*k+1]) < 0) {
		       
		       larger = 2*k+1;
		       swap(k,larger);
		   }
		   
		   else{
			   swap(k, larger);
			   k = 2*k;
		   }
		   
	   }

	   if (k*2<=size){
	       swap(k, larger);
	   }
   }
   
   private void pushUp(int k){
	   if (isMax){
		   pushUpMax(k);
	   }else{
		   pushUpMin(k);
	   }  
   }
   
   private void pushUpMax(int k){
	   while (k > 1 && data[k/2].compareTo(data[k]) > 0){
    	   swap(k, k/2);
    	   k = k/2;
    	
       }
   }
   
   private void pushUpMin(int k){
	   while (k > 1 && data[k/2].compareTo(data[k]) < 0){
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
	   data[1] = null;

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


   public static void main(String[]args){
        MyHeap<Integer> a = new MyHeap<>();
        a.add(1);
        a.add(4);
        a.add(3);
        a.add(9);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(5);
        a.add(2);
        a.add(3);
        a.add(2);
        System.out.println(a);
        a.delete();
        System.out.println(a);
        System.out.println();

        Integer[] intA = {1,2,5,7,4,8,0};
        /*MyHeap<Integer> b = new MyHeap<>(intA);
        System.out.println(b);
        b.add(10);
        b.add(20);
        System.out.println(b);
        b.delete();
        System.out.println(b);
        b.delete();
        System.out.println(b);*/

        MyHeap<Integer> c = new MyHeap<>(false);
        /*c.add(7);
        c.add(6);
        c.add(5);
        c.add(4);
        c.add(3);
        c.add(2);
        c.add(1);
        c.add(17);
        c.add(16);
        c.add(15);
        c.add(14);
        c.add(13);
        c.add(12);
        c.add(11);
        System.out.println(c);
        c.delete();
        System.out.println(c);*/

        Integer[] intB = {8,7,6,5,4,3,2};
        MyHeap<Integer> d = new MyHeap<>(intB, true);
        /*d.add(17);
        d.add(16);
        d.add(15);
        d.add(14);
        d.add(13);
        d.add(12);
        d.add(11);
        d.add(10);
        System.out.println(d);
        d.delete();
        System.out.println(d);*/
    }

  

}
