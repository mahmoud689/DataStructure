import com.sorting.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
//        int[] numbers = {7, 3, 5, 2, 3, 1, 5, 8};
//        sorter.sorter(numbers);
        int[] left = {10, 5, 8};
        int[] right = {3, 1, 81};
        int[] result = mergeArrays(left, right);
        sorter.mergeSort(result);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }
}
