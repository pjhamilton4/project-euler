package com.philipjhamilton.problem;

import java.util.Arrays;

public class Problem24 implements Problem<String>{
    @Override
    public String solve() {

        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i=1; i< 1_000_000; i++){
            int size = digits.length;
            int idx = size-1;
            while(digits[idx-1] >= digits[idx]){
                idx = idx - 1;
            }

            int j = size;
            while(digits[j - 1] <= digits[idx -1]){
                j = j - 1;
            }

            swapPositions(digits, idx-1, j-1);
            int temp;

            idx++;
            j = size;

            while(idx < j){
              swapPositions(digits, idx-1, j-1);
                idx++;
                j--;
            }
            //System.out.println(Arrays.toString(digits));
        }

        //System.out.println(Arrays.toString(digits));

        //Need to write this out as a String value but for now just doing a string array...
        return Arrays.toString(Arrays.stream(digits).mapToObj(String::valueOf).toArray(String[]::new));
    }

    private void swapPositions(int[] digits, int idx, int j) {
        int temp = digits[idx];
        digits[idx] = digits[j];
        digits[j] = temp;
    }
}
