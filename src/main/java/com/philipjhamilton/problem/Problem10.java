package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem10 implements Problem<Long>{

    @Override
    public Long solve() {
        Long sum = 0L;

        for(long i = 2; i <= 2_000_000; i++){
            if(MathHelper.isPrime(i)){
                sum += i;
            }
        }

        return sum;
    }

}
