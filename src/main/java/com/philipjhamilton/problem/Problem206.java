package com.philipjhamilton.problem;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem206 implements Problem<Long>{
    @Override
    public Long solve() {

        BigInteger bi = null;
        long min = (long)Math.sqrt(1020304050607080900L);
        long max = (long)Math.sqrt(1929394959697989990L);

        for(long i = max; i >= min; i-=10){
            bi = new BigInteger(String.valueOf(i));

            String s = bi.multiply(bi).toString();

            if(s.charAt(0) == 1 && s.charAt(2) == 2  && s.charAt(4) == 3 && s.charAt(6) == 4 && s.charAt(8) == 5 && s.charAt(10) == 6
                    && s.charAt(12) == 7 && s.charAt(14) == 8  && s.charAt(16) == 9  && s.charAt(18) == 0){
                System.out.print(" | " + i + " |");
                System.out.println(s);
                break;
            }
        }

        return null;
    }

    private boolean found(String s){
        char[] chars = s.toCharArray();
        // This pains me to write for some reason.
        //System.out.println(Arrays.toString(chars));
        System.out.println(chars[0] + "|" + chars[2] + "|" + chars[4] + "|" + chars[6] + "|" + chars[8] + "|" + chars[10] + "|" +
                chars[12] + "|" + chars[14] + "|" + chars[16] + "|" + chars[18]);
        if(chars[0] == 1 && chars[2] == 2  && chars[4] == 3 && chars[6] == 4  && chars[8] == 5 && chars[10] == 6
                && chars[12] == 7 && chars[14] == 8  && chars[16] == 9  && chars[18] == 0){
            return true;
        }

        return false;
    }
}
