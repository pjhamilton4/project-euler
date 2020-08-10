package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem17 implements Problem<Long>{
    @Override
    public Long solve() {

        long lettersUsed = 0;

//        String s = MathHelper.numberToWord(22);
//        System.out.println(s);

        for(int i = 1; i <= 100; i++){
            String temp = MathHelper.numberToWord(i);
            System.out.println(temp);
            //lettersUsed += temp.length();
        }

        return lettersUsed;
    }
}
