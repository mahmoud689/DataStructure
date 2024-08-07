package com.sorting;

public class MergeSort {

    public void mergeSort(int[] array) {
        //condition to stop recursion
        if (array.length < 2)
            return;
        //divide the array into half
        int middle = array.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];
        //sort each half
        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);

    }
    //merge the result

    public void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
