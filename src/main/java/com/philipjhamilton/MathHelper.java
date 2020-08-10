package com.philipjhamilton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class MathHelper {

    /**
     * Block from creation
     */
    private MathHelper(){};

    public static boolean isPrime(long n){

        if (n <= 1)
            return false;

        if(n == 2){
            return true;
        }

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

    public static List<Integer> getDivisors(long n){
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            if(n % i == 0){
                out.add(i);
            }
        }
        return out;
    }

    public static Long tau(Long numIn){
        long num = numIn;
        long start = 2;
        long product = 1;

        if(num == 1){
            return 1L;
        }

        while(start * start <= num){
            long count = 1;
            while(num % start == 0){
                num = num / start;
                count++;
            }
            start++;
            product = product * count;
        }

        if(num == numIn || num > 1){
            product *= 1 + 1;
        }

        return product;
    }
}
