package com.yotaku.algorithms.sorting;

public class SortingAlgorithms {
	
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] array, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		
		int leftEnd = (rightEnd - leftStart) / 2 + leftStart;
		int rightStart = leftEnd + 1;
		
		mergeSort(array, leftStart, leftEnd);
		mergeSort(array, rightStart, rightEnd);
		
		int[] sortedArray = new int[rightEnd - leftStart + 1];

		int index = 0;
		while (index < sortedArray.length) {
			if (array[leftStart] < array[rightStart]) {
				sortedArray[index++] = array[leftStart++];
			} else {
				sortedArray[index++] = array[rightStart++];
			}
			
			if (leftStart > leftEnd) {
				while(rightStart <= rightEnd) {
					sortedArray[index++] = array[rightStart++];
				}
			}
			
			if (rightStart > rightEnd) {
				while(leftStart <= leftEnd) {
					sortedArray[index++] = array[leftStart++]; 
				}
			}
		}
		
		System.arraycopy(sortedArray, 0, array, rightEnd - sortedArray.length + 1, sortedArray.length);
	}
	
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
    }
	
	public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = right;
        int leftIndx = left;
        int rightIndx = pivot - 1;

        while (rightIndx > leftIndx) {
            while (array[rightIndx] >= array[pivot] && rightIndx > leftIndx) {
                --rightIndx;
            }

            while (array[leftIndx] <= array[pivot] && leftIndx <= rightIndx) {
                ++leftIndx;
            }

            if (rightIndx > leftIndx) {
                swap(array, leftIndx, rightIndx);
                --rightIndx;
                ++leftIndx;
            }
        }

        if (array[leftIndx] > array[pivot]) {
        	swap(array, leftIndx, pivot);
        }

        quickSort(array, left, leftIndx - 1);
        quickSort(array, leftIndx + 1, right);
    }

	public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = 0; j < array.length - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

	public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }
    }

	public static void swap(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
