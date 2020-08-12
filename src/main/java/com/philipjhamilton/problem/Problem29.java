package com.philipjhamilton.problem;

import java.util.HashSet;
import java.util.Set;

public class Problem29 implements Problem<Integer>{
    @Override
    public Integer solve() {

        Set<Double> nums = new HashSet<Double>();

        for(long a = 2; a <= 100; a++){
            for(long b=2; b <= 100; b++){
                nums.add( Math.pow(a, b) );
            }
        }

        return nums.size();
    }
}
