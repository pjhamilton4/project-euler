package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem17 implements Problem<Long> {
    @Override
    public Long solve() {

        long lettersUsed = 0;

        for (int i = 1; i <= 1000; i++) {
            String temp = MathHelper.numberToWord(i);
            temp = temp.replace(" ", "").replace("-", "");
            lettersUsed += temp.length();
        }

        return lettersUsed;
    }
}
