package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.HashSet;

public class Problem34 implements Problem<Long>{
    @Override
    public Long solve() {

        HashSet<Long> found = new HashSet<Long>();
        for(long i = 3; i < 100000; i++){
            long temp = i;
            long total = 0;
            while(temp > 0){
                long digit = temp % 10;
                total+=MathHelper.factorialUsingStreams(digit);
                temp /= 10;
            }
            if(total == i){
                found.add(i);
            }
        }

        return found.stream().reduce(0L, (a, b) -> a + b);
    }
}
