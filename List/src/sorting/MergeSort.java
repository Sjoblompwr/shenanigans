package sorting;

public class MergeSort {

	/*
	 * Ta emot en array dela upp i vänster och höger -> skicka in i samma metod igen
	 * -> När enbart ett objekt återstår i vänster och höger compare and sort and
	 * return.
	 */

	static public int[] mergesort(int[] array) {
		int length = array.length;
		int left = length / 2; 
		int right = length / 2 + length % 2;
		int[] leftArray = new int[left];
		int[] rightArray = new int[right];
		
		for(int i = 0;i < left;i++) {
			leftArray[i] = array[i];
		}
		for(int i = right - length%2; i < length;i++) {
			rightArray[i - right + length%2] = array[i];
		}
		if(leftArray.length > 1)
			leftArray = mergesort(leftArray);
		if(rightArray.length > 1)
			rightArray = mergesort(rightArray);

		
		
		
		//This bit merges the left and right array, not the prettiest of solution I think, but it does the trick.
		/**
		 * Compares the next element in the leftArray with the next in the rightArray and adds the lowest to the array.
		 */
		int leftCount = 0,rightCount = 0;
		for(int i = 0;i< length;i++) {
			if(rightCount < right && leftCount < left) {
				if(leftArray[leftCount] >= rightArray[rightCount] ) {
					array[i] = rightArray[rightCount];
					rightCount++;
				}
				else {
					array[i] = leftArray[leftCount];
					leftCount++;
				}
			}
			else if(rightCount < right && !(leftCount < left)){
				array[i] = rightArray[rightCount];
				rightCount++;
			}
			else {
				array[i] = leftArray[leftCount];
				leftCount++;
			}
		}
		return array;
	}
	static public int[] mergesortReverse(int[] array) {
		int length = array.length;
		int left = length / 2; 
		int right = length / 2 + length % 2;
		int[] leftArray = new int[left];
		int[] rightArray = new int[right];
		
		for(int i = 0;i < left;i++) {
			leftArray[i] = array[i];
		}
		for(int i = right - length%2; i < length;i++) {
			rightArray[i - right + length%2] = array[i];
		}
		if(leftArray.length > 1)
			leftArray = mergesort(leftArray);
		if(rightArray.length > 1)
			rightArray = mergesort(rightArray);

		
		
		
		//This bit merges the left and right array, not the prettiest of solution I think, but it does the trick.
		/**
		 * Compares the next element in the leftArray with the next in the rightArray and adds the lowest to the array.
		 */
		int leftCount = 0,rightCount = 0;
		for(int i = 0;i< length;i++) {
			if(rightCount < right && leftCount < left) {
				if(leftArray[leftCount] >= rightArray[rightCount] ) {
					array[i] = leftArray[leftCount];
					leftCount++;
				}
				else {
					array[i] = rightArray[rightCount];
					rightCount++;
				}
			}
			else if(rightCount < right && !(leftCount < left)){
				array[i] = rightArray[rightCount];
				rightCount++;
			}
			else {
				array[i] = leftArray[leftCount];
				leftCount++;
			}
		}
		return array;
	}

}
