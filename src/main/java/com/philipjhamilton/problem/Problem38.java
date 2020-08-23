package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem38 implements Problem<Long>{
    @Override
    public Long solve() {

        long largestNum = 0;

        for(int i = 1; i < 1000000; i++){
            System.out.println("Index i: " + i);
            String concat = "";
            int n = 1;

            while(concat.length() < 9){
                System.out.println(String.format("solving for i: %d and n: %d", i, n));
                long temp = i * n;
                if((concat + String.valueOf(temp)).length() <= 9){
                    concat += String.valueOf(temp);
                    n++;
                }else{
                    break;
                }

            }
            if(MathHelper.isPandigital(concat)){
                if(Long.valueOf(concat) > largestNum){
                    largestNum = Long.valueOf(concat);
                }
            }
            System.out.println(concat);

        }

        return largestNum;
    }
}
