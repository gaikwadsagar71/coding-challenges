package org.sagar.algoexpert.medium.permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithSwapping {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        List<int[]> permutationList = new ArrayList<>();

        permutationHelper(0, array, permutationList);

        // Display code
        permutationList.forEach(integerArr -> {
            for (int i : integerArr) {
                System.out.print(i);
            }
            System.out.print(" ");
        });
    }

    private static void permutationHelper(int i, int[] array, List<int[]> permutationList) {
        if (i == array.length) {
            permutationList.add(array.clone());
        } else {
            for (int j=i; j < array.length; j++) {
                swap(array, i, j);
                permutationHelper(i+1, array, permutationList);
                swap(array, j, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
