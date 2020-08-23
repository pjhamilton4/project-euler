package com.philipjhamilton.problem;

import java.util.Arrays;

public class Problem39 implements Problem<Integer>{
    @Override
    public Integer solve() {

        int[] found = new int[1001];
        Arrays.fill(found, 0);

        for(int x = 1; x < 1000; x++){
            for(int y = 1; y < 1000; y++){
                for(int z =1; x + y + z < 1000; z++){
                    if (x * x + y * y == z * z) {
                        found[x + y + z]++;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 1; i < found.length; i++) {
            if (found[i] > found[result]) {
                result = i;
            }
        }

        return result;
    }
}
