package com.philipjhamilton.problem;

import java.math.BigInteger;

public class Problem48 implements Problem<String> {
    @Override
    public String solve() {

        BigInteger sum = BigInteger.ZERO;
        for(int i = 1; i <= 1000; i++){
            BigInteger temp = new BigInteger(String.valueOf(i)).pow(i);
            sum = sum.add(temp);
            System.out.println(sum);
        }

        return sum.toString().substring(sum.toString().length()-10, sum.toString().length());
    }
}
