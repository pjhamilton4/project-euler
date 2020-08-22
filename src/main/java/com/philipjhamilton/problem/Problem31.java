package com.philipjhamilton.problem;

import java.util.Arrays;

public class Problem31 implements Problem<Integer>{

    private static final int TARGET = 200;

    @Override
    public Integer solve() {

        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] ways = new int[TARGET+1];
        ways[0] = 1;

        for(int i=0; i < coins.length; i++){
            for(int j= coins[i]; j <= TARGET; j++){
                ways[j] += ways[j - coins[i]];
            }
        }

        return ways[ways.length-1];
    }
}
