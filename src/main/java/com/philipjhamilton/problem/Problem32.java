package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.Arrays;
import java.util.HashSet;

public class Problem32 implements Problem<Long>{
    @Override
    public Long solve() {

        char[] nums = {'1','2','3','4','5','6','7','8','9'};
        HashSet<Integer> products = new HashSet<Integer>();

        for(int a = 1; a < 10000; a++){
            for(int b = 1; b < 10000; b++ ){
                int product = a * b;
                String productString = String.valueOf(a) +  String.valueOf(b) +  String.valueOf(product);

                if(MathHelper.isPandigital(productString)){
                    System.out.println(productString);
                    products.add(product);
                }
            }
        }

        long totSum = 0;
        for(Integer i: products){
            totSum+=i;
        }

        System.out.println(Arrays.toString(products.toArray()));
        System.out.println("Total of products: " + totSum);

        return totSum;
    }
}
