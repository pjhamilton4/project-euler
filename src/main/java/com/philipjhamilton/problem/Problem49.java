package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Problem49 implements Problem<String>{

    @Override
    public String solve() {

        String a = "ABC";
        String b = "ABC";
        String c = new String("ABC");
        String d = "A" + "B" +"C";

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a == d);



//        String temp = "";
//        for(int i = 1487; i < 1488; i++){
//            if(MathHelper.isPrime(i)){
//                temp = String.valueOf(i);
//                char[] digits = temp.toCharArray();
//
//                System.out.println("Running checks for: ");
//                System.out.println(Arrays.toString(digits));
//
//                Arrays.sort(digits);
//                char[] bkp = digits;
//
//                System.out.println("------------------------");
//
//                int idx = digits.length-1;
//                while(idx > 0){
//                    System.out.println(Arrays.toString(digits));
//
//
//
//
//                    //flip first
//                    char t = digits[0];
//                    digits[0] = digits[idx];
//                    digits[idx] = t;
//
//                    digits = bkp;
//                    idx--;
//                }
//                System.out.println(Arrays.toString(digits));
//
//
//            }
//        }




        return null;
    }

    private char[] swap(char[] arr, int a, int b) {
        char[] temp = arr;

        char k = temp[a];
        temp[a] = temp[b];
        temp[b] = k;

        return temp;
    }

}
