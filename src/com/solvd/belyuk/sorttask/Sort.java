package com.solvd.belyuk.sorttask;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] intArray;
        if (args.length == 0) {
            intArray = new int[10];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = (int) (Math.random() * 20);
            }
            System.out.println("Sorted random array: " + Arrays.toString(intArray));
        } else {
            intArray = new int[args.length];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = Integer.parseInt(args[i]);
            }
            int[] sortedArray = mergeSort(intArray);
            System.out.println("Sorted array: " + Arrays.toString(sortedArray));
        }
    }

    private static int[] mergeSort(int[] numberArray) {
        int arrayLength = numberArray.length;
        if (arrayLength < 2) {
            return numberArray;
        }
        int midIndex = arrayLength / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[arrayLength - midIndex];
        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = numberArray[i];
        }
        for (int i = midIndex; i < numberArray.length; i++) {
            rightArray[i - midIndex] = numberArray[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(numberArray, leftArray, rightArray);
        return numberArray;
    }

    private static void merge(int[] numberArray, int[] leftArray, int[] rightArray) {
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int i = 0, j = 0, k = 0;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                numberArray[k] = leftArray[i];
                i++;
            } else {
                numberArray[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < leftArraySize) {
            numberArray[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArraySize) {
            numberArray[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
