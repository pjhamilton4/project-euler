package com.philipjhamilton.problem;

public class Problem2 implements Problem<Long>{

    @Override
    public Long solve() {
        long[] prev = new long[]{1, 2};
        long sum = 2;
        long temp = 0;

        while(sum <= 4_000_000){
            temp = prev[0] + prev[1];
            if(temp % 2 == 0){
                sum += temp;
            }
            prev[0] = prev[1];
            prev[1] = temp;
        }

        return sum;
    }

}
