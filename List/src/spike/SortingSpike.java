package spike;

import sorting.MergeSort;

public class SortingSpike {

	public static void main(String[] args) {
		
		int[] array = {4,3,2,1,7,3,-1,0,0,10,-77};
		
		array = MergeSort.mergesort(array);

		for(int i = 0 ; i < array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
		array = MergeSort.mergesortReverse(array);

		for(int i = 0 ; i < array.length;i++) {
			System.out.print(array[i] + " ");
		}

	}

}
