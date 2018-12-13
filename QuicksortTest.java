import java.util.Arrays;
import java.util.Random;


public class QuicksortTest {

	private static int[] numbers;
	private final static int SIZE = 700;
	private final static int MAX = 10000;
	
	public static void setUp() {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
	}
	
	public static void testNull() {
		QuickSort sorter = new QuickSort();
		sorter.sort(null);
	}
	public static void testEmpty() {
		QuickSort sorter = new QuickSort();
		sorter.sort(new int[0]);
		sorter.sort(new int[0]);
	}
	public static void testSimpleElement() {
		QuickSort sorter = new QuickSort();
		int[] test = new int[1];
		test[0] = 5;
		sorter.sort(test);
	}
	
	public void testSpecial() {
		QuickSort sorter = new QuickSort();
		int[] test = {5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5};
		sorter.sort(test);
	}
	public static void testQuickSort() {
		for(Integer i : numbers) {
		//	System.out.print(i + " ");
		
		}
		long startTime = System.currentTimeMillis();
		
		QuickSort sorter = new QuickSort();
		sorter.sort(numbers);
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Quicksort " + elapsedTime);
		printResult(numbers);
		
	}
	public static void testStandardSort() {
		long startTime = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Standard Java sort" + elapsedTime);
		printResult(numbers);
		
	}
	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}
	private static void printResult(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+", ");
			
		}
		
		
		System.out.println();
	}
	public static void main(String[] args) {
		setUp();
		testStandardSort();
		//testNull();
		//testEmpty();
		//testSimpleElement();
		testQuickSort();
	}
}
