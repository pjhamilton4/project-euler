package com.philipjhamilton.problem;

public class Problem6 implements Problem<Long> {
    @Override
    public Long solve() {
        long sumOfSquares = 0;
        long squareOfSums = 0;

        for(int i = 1; i <= 100; i++){
            sumOfSquares += i*i;
            squareOfSums += i;
        }

        return Math.round(Math.pow(squareOfSums, 2) - sumOfSquares);
    }
}
