package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem46 implements Problem<Integer>{
    @Override
    public Integer solve() {
        int result = 1;
        List<Integer> primes = MathHelper.sieveOfEratosthenes(10000);

        //System.out.println(Arrays.toString(primes.toArray()));
        boolean found = false;
        while(!found){
            result += 2;

            int idx = 1;
            found = true;
            while (result >= primes.get(idx)) {
                if(isTwiceSquare(result-primes.get(idx))){
                    found = false;
                    break;
                }
                idx++;
            }
        }
        return result;
    }

    private boolean isTwiceSquare(long num){
        double squareTest = Math.sqrt(num/2);
        return squareTest == (int)squareTest;
    }
}
