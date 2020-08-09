package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem3 implements Problem<Long>{

    @Override
    public Long solve() {
        Long primeFactor = 600_851_475_143L;
        Long largestPrime = 0L;

        for(long i = 3; i*i <= primeFactor; i += 2){
            //System.out.println("i = " + i);
            if(primeFactor % i == 0){
                if(MathHelper.isPrime(i)){
                    //System.out.println("New Largest is: " + i);
                    largestPrime = i;
                }
            }
        }

        return largestPrime;
    }


}
