package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem43 implements Problem<Long>{
    @Override
    public Long solve() {

        long sum = 0;
        for(long i = 1023456789; i < 9999999999L; i++){
            if(MathHelper.isPandigital(toString().valueOf(i))){
               if(isDivisible(i)){
                   sum += i;
                   System.out.println(sum);
               }
            }
        }

        return sum;
    }

    public boolean isDivisible(long num){
        String s = String.valueOf(num);
        char[] cArr = s.toCharArray();
        int[] divisors = {1, 2, 3, 5, 7, 11, 13, 17};
        boolean divisible = true;
        for(int i = 0; i < divisors.length-1; i++){
            int temp = Integer.valueOf(new String(new char[]{cArr[i], cArr[i+1], cArr[i+2]}));
            if(temp % divisors[i] != 0){
                divisible = false;
                break;
            };
        }
        return divisible;
    }
}
