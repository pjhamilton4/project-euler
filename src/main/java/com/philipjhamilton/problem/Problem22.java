package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Problem22 implements Problem<Long> {
    @Override
    public Long solve() {

        ArrayList<String> str = FileReader.readStringsFromFile("p022_names.txt");

        str.sort(Comparator.naturalOrder());

        long totalSum = 0;
        int counter = 1;
        for (String s : str) {
            int sum = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                int val = c;
                int temp_integer = 96; //for lower case
                if (val <= 122 & val >= 97) {
                    sum += val-temp_integer;
                }
            }
            totalSum += (sum * counter);
            counter++;
        }

        return totalSum;
    }
}
