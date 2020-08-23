package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.util.*;

public class Problem42 implements Problem<Long> {
    @Override
    public Long solve() {

        List<String> out = FileReader.readStringsFromFile("p042_words.txt");
        HashSet<Integer> triTerms = new HashSet<Integer>();

        for(int n = 1; n < 10000; n++){
            double term = (.5 * n) * (n + 1);
            triTerms.add((int) term);
        }

        //System.out.println(Arrays.toString(triTerms.toArray()));

        long totalTriangleWords = 0;

        for(String s: out) {

            //tn = ½n(n+1);

            int wordVal = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                int temp = (int) c;
                int temp_integer = 96;
                if (temp <= 122 & temp >= 97)
                    wordVal += temp - temp_integer;
            }
            if(triTerms.contains(wordVal)){
                totalTriangleWords++;
            }
            //System.out.println(s + " is worth: " + wordVal);
        }

        return totalTriangleWords;
    }
}
