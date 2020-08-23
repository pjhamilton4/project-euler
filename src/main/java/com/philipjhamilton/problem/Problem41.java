package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem41 implements Problem<Long>{
    @Override
    public Long solve() {

        long longest = 0;

        for(long i=1 ; i < 10000000; i++){
            if(i % 1000000 == 0){
                System.out.println("At index: " + i);
            }
            if(MathHelper.isPrime(i)){
                if(MathHelper.isPandigital(i, String.valueOf(i).length()))
                {
                    System.out.println("Pandigital found!: " + i);
                    if(i > longest){
                        longest = i;
                    }
                }
            }
        }

        return longest;
    }
}
