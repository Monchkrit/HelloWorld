package mergeSort;

public class MergeSort {
	
	static int[] list;
	static int length = 0;

	private static void printArray(int[] list) {
		for (int i: list) {
			System.out.print(i + " ");;
		}
		System.out.println();;
	}
	
	// I'm counting on this method being able to split an array into duples and return them.
	static public void  mergeSort(int[] list, int lowIndex, int highIndex) {
		System.out.println("The Low Index and High Index compared in the beginning of mergeSort are "+lowIndex+" "+highIndex);
		if (lowIndex == highIndex) {
			return;		
	}
	else {
		int midIndex = (lowIndex + highIndex) / 2;
		System.out.println("The Middle Index here is: "+ midIndex);
		System.out.println("The Low Index and Middle Index here are "+ lowIndex+" "+midIndex);
		mergeSort(list, lowIndex, midIndex);
		System.out.println("The indexes going into the right side for mergeSort are " + (midIndex+1)+" " +highIndex);
		mergeSort(list, midIndex + 1, highIndex);
		System.out.println("The indexes going into merge here are "+lowIndex+" "+midIndex+" "+highIndex);
		merge(list, lowIndex, midIndex, highIndex);
	}
		
	}
	
	static public void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
		int[] L = new int[midIndex - lowIndex + 2];
		
		// These loops put the right values from the input list into the left and right arrays as they are built.
		// They are sorting as they go along.
		for (int i = lowIndex; i <= midIndex; i++) {
			L[i - lowIndex] = list[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
		int[] R = new int[highIndex - midIndex + 1];
		
		for (int i = midIndex + 1; i <= highIndex; i++) {
			R[i - midIndex - 1] = list[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		
		// This for loop compares the value on the left and right of the duple to see if they need to get swapped.
		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) {
				list[k] = L[i];
				i++;
			}
			else {
				list[k] = R[j];
				j++;
			}
		}
		
		}
	
	public static void main(String args[]) {
		int[] array = {242, 523, 2103, 231, 4556, 724};
		int arrayLength = array.length;
		System.out.println("Initial Array: " );
		printArray(array);
		
		mergeSort(array, 0, arrayLength - 1);
		System.out.println("Sorted Array: " );
		printArray(array);
	}
}