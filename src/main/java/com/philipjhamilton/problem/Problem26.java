package com.philipjhamilton.problem;

public class Problem26 implements Problem<Long>{
    @Override
    public Long solve() {

        for(double i = 2; i < 1000; i++){
            System.out.println(1/i);
        }

        return null;
    }
}
