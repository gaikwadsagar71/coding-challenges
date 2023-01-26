package org.sagar.algoexpert.medium.permutation;

public class PermutationOfString {

    // stringLen is not part of algorithm.
    // It is just used for printing in new line
    static int stringLen;

    public static void main(String[] args) {
        String input = "abcd";
        String answer = " ";

        stringLen = input.length();
        System.out.println("Output is: ");
        printPermution(input, answer);
    }

    private static void printPermution(String input, String answer) {

        if (input.length() == 0) {
            System.out.print(answer + " ");

            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            String firstPart = input.substring(0, i);
            String lastPart = input.substring(i+1);

            printPermution(firstPart + lastPart, answer + character);

            if (input.length() == stringLen)  System.out.println("");
        }
    }
}
