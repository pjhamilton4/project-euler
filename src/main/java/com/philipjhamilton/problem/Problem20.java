package com.philipjhamilton.problem;

import java.math.BigInteger;

public class Problem20 implements Problem<Long> {
    @Override
    public Long solve() {
        BigInteger solved = new BigInteger("100");
        long sum = 0;

        for(int i = 99; i > 0; i--){
            solved = solved.multiply(new BigInteger(String.valueOf(i)));
        }

        while(solved.compareTo(new BigInteger("0")) > 0){
            BigInteger mod = solved.mod(new BigInteger("10"));
            sum += mod.intValue();
            solved = solved.divide(new BigInteger("10"));
        }

        return sum;
    }
}
