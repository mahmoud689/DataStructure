package com.sorting;

public class QuickSort {
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end)
            return;
        var boundry = partition(array, start, end);
        //Sort left
        quickSort(array, start, boundry - 1);
        //Sort right
        quickSort(array, boundry + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundry = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, i, ++boundry);
        }
        return boundry;
    }

    private void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
