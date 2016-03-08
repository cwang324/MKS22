
public class Quick {


	
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
//	    this allows your quickselect method to decide where to go next.
	
	private static int partition(int[]data, int left, int right, int part){
		//int part = ((int) (Math.random() * (right-left)) + left);
		//System.out.println(part);
		int partVal = data[part];
		swap(data, part, right);
		int storeIndex = left;
		for (int i = left; i<right; i++){
			if (data[i] < partVal){
				int leftVal = data[i];
				swap(data,i,storeIndex);
				storeIndex++;
			}	
		}
		swap(data,right,storeIndex);
		return storeIndex;
	}
	
	//public static int quickselect(int[]data, int k);
	//return the kth smallest value.
	// when k = 0 return the smallest.
	// 0 <= k < data.length

	//private static int quickselect(int[]data, int k, int left, int right);
	//return the kth smallest value in the given left/right range
	// left <= k <= right
	//start by calling the helper as follows:
//	    quickselect(data,k,0,data.length-1)
	
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
		
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		partition(data, 2, 6, 4);
		printArray(data);
	}
}
