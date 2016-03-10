
public class Sorts {

	
		public static String name(){
		    return "6,Wang,Carol";     
		}
	
	    public static void printArray(int[] data){
		System.out.print("[");
		for (int i = 0; i < data.length-1; i++){
		    if (i < data.length-1){
			System.out.print(data[i] + ", ");
		    }else{
			System.out.print(data[i]);
		    }
		}
		System.out.print("]");     
	    }

	   
	    
	    public static void insertionSort(int[] data){
		for (int nextI = 1; nextI < data.length; nextI++){
		    int curI = nextI;
		    while ( curI > 0 && data[curI-1] > data[curI] ) {
			// swap data[curI=i] and data[curI]
			int copy = data[curI-1];
			data[curI-1]  = data[curI];
			data[curI]=copy;
			curI = curI -1;       
		    }	
		}

	    }

	    public static void selection(int[] data){
		int minI;
		int minVal;
		for (int i=0; i < data.length; i++){
		    minI = findMin(data,i);
		    minVal = data[minI];
		    data[minI] = data[i];
		    data[i] = minVal;
		}

	    }

	    private static int findMin(int[] data, int startI){
		int min = 0;
		int minI = 0;
		for (int i = startI; i<data.length; i++){
		    if (data[i] < min){
			min = data[i];
			minI = i;
		    }
		}
		return minI;		   
	    }

	   /**
    * Precondition: Every indexed variable of the array a has a value.
    * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
    */
	public static void mergeSort(int[] a)
	{
		int dataSize = a.length;
		
		if ( dataSize >= 2)
		{	
			int halfLength = dataSize / 2;
			int [] firstHalf = new int[halfLength];
			int [] secondHalf = new int[dataSize-halfLength];
			
			divide(a, firstHalf, secondHalf);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(a, firstHalf, secondHalf);
		}
		else
		{	
			// do nothing, an array of size 1 is already sorted
		}
	}
	
	
	//Precondition: a.length = firstHalf.length + lastHalf.length.
    //Postcondition: All the elements of a are divided
    //between the arrays firstHalf and lastHalf.
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf)
    {
        for (int i = 0; i < firstHalf.length; i++)
            firstHalf[i] = a[i];
        
        for (int i = 0; i < lastHalf.length; i++)
            lastHalf[i] = a[firstHalf.length + i];
    }
	
    
    //Precondition: Arrays firstHalf and lastHalf are sorted from 
    //smallest to largest; a.length = firstHalf.length + 
    //lastHalf.length.
    //Postcondition: Array a contains all the values from firstHalf 
    //and lastHalf and is sorted from smallest to largest.
	private static void merge(int[] a, int[] firstHalf, int[] lastHalf)
    {
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

        while ((firstHalfIndex < firstHalf.length) &&
			   (lastHalfIndex < lastHalf.length))
        {
            if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex])
            {
                a[aIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }
            else
            {
                a[aIndex] = lastHalf[lastHalfIndex];
                lastHalfIndex++;
            }
            aIndex++;
        }
        //At least one of firstHalf and lastHalf has been
        //completely copied to a.

        //Copy rest of firstHalf, if any.
		while (firstHalfIndex < firstHalf.length)
        {
            a[aIndex] = firstHalf[firstHalfIndex];
            aIndex++;
            firstHalfIndex++;
        }

        //Copy rest of lastHalf, if any.
        while (lastHalfIndex < lastHalf.length)
        {
            a[aIndex] = lastHalf[lastHalfIndex];
            aIndex++;
            lastHalfIndex++;
        }
    }    

    


}
	

