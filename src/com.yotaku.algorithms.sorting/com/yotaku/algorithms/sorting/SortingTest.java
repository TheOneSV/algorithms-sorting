package com.yotaku.algorithms.sorting;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortingTest {
	
	public static void main(String[] args) {
		
		int[] testData = generateTestData(100000, 1000);
		
		test("Selection Sort", testData, SortingAlgorithms::selectionSort);
		test("Bubble Sort", testData, SortingAlgorithms::bubbleSort);
		test("Merge Sort", testData, SortingAlgorithms::mergeSort);
		test("Quick Sort", testData, SortingAlgorithms::quickSort);
		
	}
	
	public static void test(String testName, int[] testData, Consumer<int[]> testAlgorithm) {
		// warm-up
		int[] testDataCopy = Arrays.copyOf(testData, testData.length / 4);
		testAlgorithm.accept(testDataCopy);
		
		// actual test
		testDataCopy = Arrays.copyOf(testData, testData.length);
		
		long start = System.currentTimeMillis();
		testAlgorithm.accept(testDataCopy);
		long end = System.currentTimeMillis();
		
		System.out.println(testName + ": " + (end - start));
	}
	
	public static int[] generateTestData(int size, int bound) {
		int[] arr = new int[size];
		Random rand = new Random();
		
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = rand.nextInt(bound);
		}
		
		return arr;
	}
	
}
