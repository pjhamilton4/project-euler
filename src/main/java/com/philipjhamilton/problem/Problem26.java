package com.philipjhamilton.problem;

import java.math.BigDecimal;
import java.util.Arrays;

public class Problem26 implements Problem<Integer>{

    @Override
    public Integer solve() {

        int sequenceLength = 0;

        for (int i = 1000; i > 1; i--) {
            if (sequenceLength >= i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                System.out.println(Arrays.toString(foundRemainders));
                System.out.printf("Value: %d | Position: %d | i: %d\n",value, position, i);
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                sequenceLength = position - foundRemainders[value];
            }
        }

        return sequenceLength;
    }
}
