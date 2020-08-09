package com.philipjhamilton;

public final class MathHelper {

    /**
     * Block from creation
     */
    private MathHelper(){};

    public static boolean isPrime(long n){

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
