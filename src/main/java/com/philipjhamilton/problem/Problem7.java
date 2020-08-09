package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem7 implements Problem<Long>{

    @Override
    public Long solve() {

        long primesFound = 0;
        long number = 0;

        while(primesFound != 10001 ){
            number++;
            if(MathHelper.isPrime(number)){
                ++primesFound;
            }
        }

        //104743
        return number;
    }


}
