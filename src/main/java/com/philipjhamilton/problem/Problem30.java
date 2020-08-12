package com.philipjhamilton.problem;

import javax.swing.*;

public class Problem30 implements Problem<Long>{
    @Override
    public Long solve() {

        long sum = 0;

        for(int i = 2; i < 1000000; i++){
            System.out.println("Trying digit fifth powers for " + i);
            double squares = 0;
            int temp = i;
            while(temp > 0){
                System.out.println("Temp: " + temp);
                int digit = temp % 10;
                double powered = Math.pow(digit, 5);
                System.out.println("Powered: " + powered);
                squares += powered;
                temp = (int) Math.floor(temp / 10);
                System.out.println("Temp after: " + temp);
            }

            if(squares == i){
                System.out.println(String.format("Sum of digits 5th powers equals index (%d)! %f", i, squares));
                sum += squares;
            }

            ;
        }

        return sum;
    }
}
