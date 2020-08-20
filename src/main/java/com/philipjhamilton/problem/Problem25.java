package com.philipjhamilton.problem;

import java.math.BigInteger;

public class Problem25 implements Problem<String>{
    @Override
    public String solve() {

        Boolean found = false;
        int idx = 0;

        BigInteger prev1 = new BigInteger("1");
        BigInteger prev2 = new BigInteger("1");

        while(!found){
            BigInteger tempBI = prev1.add(prev2);

            prev1 = prev2;
            prev2 = tempBI;

            if(tempBI.toString().length()>1000){
                System.out.println(tempBI.toString());
                found = true;
            }
            idx++;
        }

        return String.valueOf(idx-3);
    }
}
