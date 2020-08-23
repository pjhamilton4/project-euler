package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem36 implements Problem<Long>{
    @Override
    public Long solve() {

        long totSum = 0;
        for(int i = 0; i < 1_000_000; i++){
            //Check for palindrome
            boolean bothPalindrome = true;

            if(!MathHelper.isPalindrome(i)){
                bothPalindrome = false;
            }

            //Convert to binary
            String binary = Integer.toBinaryString(i);
            if(!MathHelper.isPalindrome(binary)){
                bothPalindrome = false;
            }

            if(bothPalindrome){
                totSum += i;
            }
        }

        return totSum;
    }



}
