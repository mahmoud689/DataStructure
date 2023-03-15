package com.frequencyarray.example;

import java.util.HashMap;
import java.util.Map;

public class FrequencyArray {
    private static void frequentArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else
                map.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println(integerIntegerEntry.getKey() + "   " + integerIntegerEntry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] myArr = {10, 20, 20, 10, 10, 20, 5, 20};
        frequentArray(myArr);
    }
}
