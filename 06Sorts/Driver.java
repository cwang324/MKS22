public class Driver{

    public static void main(String[] args){
	
	int[] test = {1,2,9,5,0,3};
	Sorts.insertionSort(test);
	Sorts.printArray(test);

        int[] test1 = {1,2,9,5,0,3};
	Sorts.selection(test);
	Sorts.printArray(test1);

        int[]  test2 = {1,2,9,5,0,3};
	Sorts.mergesort(test2);
	Sorts.printArray(test);
    }

}
