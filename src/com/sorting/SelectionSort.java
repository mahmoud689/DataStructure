package com.sorting;

public class SelectionSort {
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = getMinIndex(array, i);
            swap(array, minIndex, i);
        }
    }

    private static int getMinIndex(int[] array, int i) {
        int minIndex = i;
        for (int j = i; j < array.length; j++) {
            if (array[j] < array[minIndex])
                minIndex = j;
        }
        return minIndex;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
