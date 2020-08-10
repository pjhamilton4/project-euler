package com.philipjhamilton.problem;

import java.util.Arrays;

public class Problem15 implements Problem<Long>{
    @Override
    public Long solve() {

        long[][] grid = new long[21][21];

        // INIT
        for(int i = 0; i <= 20; i++){
            grid[i][20] = 1;
            grid[20][i] = 1;
        }

//        for(int[] arrIn: grid){
//            System.out.println(Arrays.toString(arrIn));
//        }

        for(int i = 19; i >= 0; i--){
            for(int j = 19; j >= 0; j--){
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }

        for(long[] arrIn: grid){
            System.out.println(Arrays.toString(arrIn));
        }

        return null;
    }
}
