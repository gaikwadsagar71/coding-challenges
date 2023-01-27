package org.sagar.algoexpert.medium.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Upper bound: O(n^2*n!) time | O(n*n!) space
// Roughly: O(n*n!) time | O(n*n!) space
public class PermutationWithRemovingElement {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3);
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> permutationList = new ArrayList<>();

        permutation(array, permutation, permutationList);

        // Display code
        permutationList.forEach(permutations -> {
            System.out.print(" ");
            permutations.forEach(System.out::print);
        });
    }

    private static void permutation(List<Integer> array, List<Integer> permutation, List<List<Integer>> permutationList) {
        if (array.size() == 0 && permutation.size() != 0) {
            permutationList.add(permutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                Integer current = array.get(i);
                List<Integer> newList = array.stream()
                        .filter(element -> element != current)
                        .collect(Collectors.toList());
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.add(current);
                permutation(newList, newPermutation, permutationList);
            }
        }
    }
}
