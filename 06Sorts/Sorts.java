public class Sorts{

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
    public static void mergesort(int[] a)
    {
	int startA = 0; 
	int endA = a.length-1;
			
	betterMergeSortImpl(a, startA, endA);
			
    }
	
    /**
     * Precondition: Every indexed variable of the array a has a value.
     * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
     */
    public static void betterMergeSortImpl(int[] a, int startIndex, int endIndex)
    {
	int dataSize = endIndex - startIndex + 1;
			
	if ( dataSize >= 2)
	    {	
		int halfLength = dataSize / 2;
		int startA = startIndex;
		int endA = startIndex + halfLength-1;
		int startB = endA + 1;
		int endB = endIndex;
		betterMergeSortImpl(a, startA, endA);
		betterMergeSortImpl(a, startB, endB);
		betterMerge(a, startA, endA, startB, endB);
	    }
	else
	    {	
		// do nothing, an array of size 1 is already sorted
	    }
    }
	
	
    //Precondition: int[] a conains the entire array to be sorted using merge sort 
    //startA <= endA <= startB <= endB 
    //
    //Postcondition: Array a index startA to endB is sorted from smallest to largest 
    //and lastHalf and is sorted from smallest to largest.
    private static void betterMerge(int[] a, int startA, int endA, int startB, int endB)
    {
		
	int tempArraySize = endB - startA + 1;
	int[] tempArray = new int[tempArraySize];
	int aIndex = startA;
	int bIndex = startB;
	int tIndex = 0;

         
	while ((aIndex <= endA) && (bIndex <= endB))
	    {
		if (a[aIndex] < a[bIndex])
		    {
			tempArray[tIndex++] = a[aIndex++];                
		    }
		else
		    {
			tempArray[tIndex++] = a[bIndex++];
		    }
	    }
        // At least one half (startA to endA or startB to endB) is
        // completely copied to tempArray

        //Copy rest of firstHalf, if any.
	while (aIndex <= endA)
	    {
		tempArray[tIndex++] = a[aIndex++];
	    }

        //Copy rest of lastHalf, if any.
        while (bIndex <= endB)
	    {
		tempArray[tIndex++] = a[bIndex++];
	    }
        
        // copy the merged result from tempArray back to array a
        tIndex = 0;
        aIndex = startA;
        while ( startA <= endB)
	    {	
        	a[aIndex++] = tempArray[tIndex++];
        	startA++;
	    }        
    }
}
