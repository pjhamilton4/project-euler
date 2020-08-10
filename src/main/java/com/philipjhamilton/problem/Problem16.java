package com.philipjhamilton.problem;

import java.math.BigInteger;

public class Problem16 implements Problem<Long> {

    @Override
    public Long solve() {
        BigInteger bigNum = new BigInteger("2");

        BigInteger num = bigNum.pow(1000);

        long sum = 0;

        System.out.println("Digit: " + num);

        while(num.compareTo(new BigInteger("0")) > 0){
            sum += num.mod(new BigInteger("10")).intValue();
            num = num.divide(new BigInteger("10"));
            //System.out.println("Current digit: " + num);
            //System.out.println("Current sum: " + sum);
        }

        System.out.println("Sum: " + sum);

        return sum;
    }
}
