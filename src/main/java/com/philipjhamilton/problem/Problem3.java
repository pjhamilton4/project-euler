package com.philipjhamilton.problem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Problem3 implements Problem<Long>{

    @Override
    public Long solve() {
        Long primeFactor = 600_851_475_143L;
        Long largestPrime = 0L;

        for(long i = 3; i*i <= primeFactor; i += 2){
            System.out.println("i = " + i);
            if(primeFactor % i == 0){
                if(isPrime(i)){
                    System.out.println("New Largest is: " + i);
                    largestPrime = i;
                }
            }
        }

        return largestPrime;
    }

    private boolean isPrime(long n){

        if( n % 2 == 0 ){
            return false;
        }

        for(long i = 3L; i*i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
