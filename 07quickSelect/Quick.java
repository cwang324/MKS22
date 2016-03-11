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
	
    private static int partition(int[]data, int left, int right){
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
	int newI = partition(data,left,right);
	//printArray(data);
	if (newI==k){
	    return data[k];
	}else{
	    if (k<newI){
		return (quickselect(data,k,left,newI-1));
	    }else{
		return(quickselect(data,k,newI+1,right));
	    }
	}
    }
    //return the kth smallest value in the given left/right range
    // left <= k <= right

	
    public static void quickSort(int[] data){
	quickSort(data,0,data.length-1);
    }
    
    public static void quickSort(int[]data, int left, int right){
	if (data.length > 1){
	    int index = partition(data,left,right);
	    quickSort(data, left, index-1);
	    quickSort(data,index+1, right);
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
		
	int[] data = {1,9,4,3,1,4,3,1,9,4,1,1,3};
	//System.out.println(quickselect(data,4));
	//System.out.println(partition(data,2,5));

	printArray(data);
        quickSort(data);
	printArray(data);
    }
}
