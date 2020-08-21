package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem27 implements Problem<Integer> {
    @Override
    public Integer solve() {

        int aMax = 0;
        int bMax = 0;
        int nMax = 0;
        for (int a = -1000; a <= 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while(MathHelper.isPrime(Math.abs((long) Math.pow((double) n, 2)) + (a * n) + b)){
                    n++;
                }
                if(n > nMax){
                    nMax = n;
                    aMax = a;
                    bMax = b;
                }
            }
        }
        return nMax;
    }
}
