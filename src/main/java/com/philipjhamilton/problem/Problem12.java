package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem12 implements Problem<Long> {
    @Override
    public Long solve() {
        long num = 1;
        long tNumber = 1;

        while(MathHelper.tau(tNumber) <= 500){
            num++;
            tNumber += num;
        }

        return tNumber;
    }
}
