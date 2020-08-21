package com.philipjhamilton.problem;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem206 implements Problem<Long>{
    @Override
    public Long solve() {

        BigInteger bi = null;
        long min = (long)Math.sqrt(1020304050607080900L);
        long max = (long)Math.sqrt(1929394959697989990L);

        for(long i = max; i >= min; i--){
            bi = new BigInteger(String.valueOf(i));

            bi = bi.pow(2);

            if(found(bi)){
                return i;
            }

        }

        return null;
    }

    private boolean found(BigInteger s){
        char[] nr = s.toString().toCharArray();

        if (nr[0] == '1' && nr[2] == '2' && nr[4] == '3' && nr[6] == '4' && nr[8] == '5' && nr[10] == '6'
                && nr[12] == '7' && nr[14] == '8' && nr[16] == '9' && nr[18] == '0'){
            return true;
        }

        return false;
    }
}
