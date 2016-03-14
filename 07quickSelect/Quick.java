import java.util.Arrays;

public class Quick {


    public static String name(){
	return "6,Wang,Carol"; // or "6,Last,First" 
    }

    public static void swap(int[] data, int a, int b){
	if (a!=b){
	    int temp = data[a];
	    data[a] = data[b];
	    data[b] = temp;
	}
    }
    //choose a random partition element  at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it.
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element.
    //	    this allows your quickselect method to decide where to go next.mew
	
    private static int partitionOld(int[]data, int left, int right){
	int part = ((int) (Math.random() * (right-left+1)) + left);
	//System.out.println(part);
	int partVal = data[part];
	swap(data, part, right);
	int newI = left;
	
	for (int i = left; i<right; i++){
	    if (data[i] < partVal){
		swap(data,i,newI);
	        newI++;
	    }
	    
	}
	swap(data,right,newI);
	return newI;
    }
	

	
    public static int quickSelectOld(int[]data, int k){
	if (k < 0 || k > data.length){
	    throw new IllegalArgumentException("The entered k is out of bounds");
	}
	return quickSelectOld(data,k,0,data.length-1);
    }
	
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length

    private static int quickSelectOld(int[]data, int k, int left, int right){
	int newI = partitionOld(data,left,right);
	//printArray(data);
	if (newI==k){
	    return data[k];
	}else{
	    if (k<newI){
		return (quickSelectOld(data,k,left,newI-1));
	    }else{
		return(quickSelectOld(data,k,newI+1,right));
	    }
	}
    }
    //return the kth smallest value in the given left/right range
    // left <= k <= right

	
    public static void quickSortOld(int[] data){
	quickSortOld(data,0,data.length-1);
    }
    
    public static void quickSortOld(int[]data, int left, int right){
	if (left<right){
	    int index = partitionOld(data,left,right);
	    quickSortOld(data, left, index-1);
	    quickSortOld(data,index+1, right);
	}
    }

    

    //choose a random partition element  at a location from left to right inclusive.
    //partition the array such that the randomly chosen element divides all values smaller and larger than it.
    //smaller elements on the left side of the partition, larger on the right side
    //return the index of the partition element.
    //	    this allows your quickselect method to decide where to go next.mew
	
    private static int[] partition(int[]data, int left, int right){
    	int part = ((int) (Math.random() * (right-left+1)) + left);
    	
    	int partVal = data[part];
    	//System.out.println("partition index:" + part + "\t part val:" + partVal);
    	int[] partedAry = new int[right-left+1];
    	int front = 0;
    	int back = partedAry.length-1;
    	int pivotVals = 0;
	
	// parting elements in separate partedAry
	for (int i = left; i<=right; i++){
	    if (data[i] < partVal){
	    	partedAry[front]=data[i];
	    	front++;
	    } else if (data[i] > partVal){
	    	partedAry[back]=data[i];
	    	back--;
	    } else {
	    	pivotVals++;
	    }
	}
	
	int[] pivots = new int[2];
	pivots[0] = left+front;
	pivots[1] = pivots[0] + pivotVals - 1;
	
	// adding in pivot values into middle of array
	for (int i=0; i<pivotVals; i++){
		partedAry[i+front]=partVal;
	}
	
	// parting values in original array
	for (int i=0; i<partedAry.length; i++){
		data[i+left] = partedAry[i];
	}
	
	return pivots;
    }
	

	
    public static int quickselect(int[]data, int k){
	if (k < 0 || k > data.length){
	    throw new IllegalArgumentException("The entered k is out of bounds");
	}
	return quickselect(data,k,0,data.length-1);
    }
	
    //return the kth smallest value.
    // when k = 0 return the smallest.
    // 0 <= k < data.length

    private static int quickselect(int[]data, int k, int left, int right){
	int[] pivots = partition(data,left,right);
	//printArray(data);
	if (k >= pivots[0] && k<=pivots[1]){
	    return data[k];
	}else{
	    if (k<pivots[0]){
	    	return (quickselect(data,k,left,pivots[0]-1));
	    }else{
	    	return(quickselect(data,k,pivots[1]+1,right));
	    }
	}
    }
    //return the kth smallest value in the given left/right range
    // left <= k <= right

	
    public static void quickSort(int[] data){
    	quickSort(data,0,data.length-1);
    	System.out.println(data.length-1);
    }
    
    
    private static int count = 0;
    public static void quickSort(int[]data, int left, int right){
    	
//    	count++;
//    	if ( count > 14)
//    		return;
//    	System.out.print("quicksort: ");
//    	printArray(data);
//    	System.out.println("left:" + left + "   right:" + right);
//    	System.out.println("-----------------------------");
    	
    	if (left<right && right>0)
    	{
    		int[] pivots = partition(data,left,right);
    		
//    		System.out.println("after partition: pivots=");
//    		printArray(pivots);
//    		System.out.println("-----------------------------");
    		
    		
    		quickSort(data, left, pivots[0]-1);
    		quickSort(data,pivots[1]+1, right);
    	}
    }
    
    


    public static void printArray(int[] data){
	System.out.print("[");
	for (int i = 0; i < data.length; i++){
	    if (i < data.length-1){
		System.out.print(data[i] + ", ");
	    }else{
		System.out.print(data[i]);
	    }
	}
	System.out.print("]");     
    }

	
    public static void main(String[] args){
		
//	int[] data = {5,13,6,9,1,87,3,0,1,1,1,1,1,4,4,4,4,5,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
//	//int[] data = {3,1,2,5,4};
//    printArray(data);
//	quickSort(data);
//	//printArray(partition(data,0,data.length-1));
//	printArray(data);
    	
    	int[] d = new int [4000000];
    	

    	for(int i = 0; i < d.length; i++){
    		d[i]= (int)(Math.random()*Integer.MAX_VALUE);
    		//d[i]= (int)(Math.random()*4);
    	}
    	
    	// a1
    	long startTime = System.currentTimeMillis();
    	Arrays.sort(d); 
    	long endTime = System.currentTimeMillis();
    	
    	
    	long elapsedTime = endTime - startTime;  // this is milliseconds
    	System.out.println("Arrays Time:"+ (elapsedTime)/1000.0 + " seconds");
    	
    	
    	// a2
    	startTime = System.currentTimeMillis();
    	quickSortOld(d); 
    	endTime = System.currentTimeMillis();
    	
    	
    	elapsedTime = endTime - startTime;  // this is milliseconds
    	System.out.println("Time:"+ (elapsedTime)/1000.0 + " seconds");
    	
    	// a3
    	startTime = System.currentTimeMillis();
    	quickSort(d); 
    	endTime = System.currentTimeMillis();
    	
    	
    	elapsedTime = endTime - startTime;  // this is milliseconds
    	System.out.println("A3 Time:"+ (elapsedTime)/1000.0 + " seconds");
    	
    	
    	
    	
    	
    }
}