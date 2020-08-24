package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

public class Problem43 implements Problem<Long>{

    int[] perm = new int[] { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };


    public Long solveBackup(){
        long result = 0;

        int[] divisors = { 1,  2, 3, 5, 7, 11, 13, 17 };

        int count = 1;
        int numPerm = 3265920;

        while (count < numPerm) {
            int N = perm.length;
            int i = N - 1;
            while (perm[i - 1] >= perm[i]) {
                i = i - 1;
            }

            int j = N;
            while (perm[j - 1] <= perm[i - 1]) {
                j = j - 1;
            }

            // swap values at position i-1 and j-1
            swap(i - 1, j - 1);

            i++;
            j = N;
            while (i < j) {
                swap(i - 1, j - 1);
                i++;
                j--;
            }
            boolean divisible = true;
            for (int k = 1; k < divisors.length; k++) {
                int num = 100 * perm[k] + 10 * perm[k + 1] + perm[k + 2];
                if (num % divisors[k] != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                long num = 0;
                for(int k = 0; k < perm.length; k++){
                    num = 10*num + perm[k];
                }
                System.out.println(num);
                result += num;
            }
            count++;
        }
        return result;
    }

    private void swap(int i, int j) {
        int k = perm[i];
        perm[i] = perm[j];
        perm[j] = k;
    }


    @Override
    public Long solve() {

//        System.out.println(MathHelper.isPandigital(String.valueOf(1406357289)));
//        System.out.println(MathHelper.isPandigital(String.valueOf(1430952867)));
//        System.out.println(MathHelper.isPandigital(String.valueOf(1460357289)));
//        System.out.println(MathHelper.isPandigital(String.valueOf(4106357289L)));
//        System.out.println(MathHelper.isPandigital(String.valueOf(4130952867L)));
//        System.out.println(MathHelper.isPandigital(String.valueOf(4160357289L)));

//        //FALSE
//        System.out.println(isDivisible(1490357286L));
//        System.out.println(isDivisible(1490658327L));
//        System.out.println(isDivisible(1790658324));
//        System.out.println(isDivisible(1730952864));
//        System.out.println(isDivisible(1906357284));
//
//        //TRUE
//        System.out.println(isDivisible(1406357289));
//        System.out.println(isDivisible(1430952867));
//        System.out.println(isDivisible(1460357289));
//        System.out.println(isDivisible(4106357289L));
//        System.out.println(isDivisible(4130952867L));
//        System.out.println(isDivisible(4160357289L));

        long sum = 0;
        //THIS IS REALLY REALLY SLOW
        //Alternate way would be to swap numbers for all possible permutations.
        for(long i = 1406357289; i <= 4160357289L; i++){
            //System.out.println("Checking if " + i + " is a pandigital");
            if(i % 100000 == 0){
                System.out.println(i);
            }
            if(MathHelper.isPandigital(toString().valueOf(i))){
               if(isDivisible(i)){
                   sum += i;
                   System.out.println("I is pandigital and divisible: " + i);
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
        for(int i = 1; i < divisors.length; i++){
            int temp = Integer.valueOf(new String(new char[]{cArr[i], cArr[i+1], cArr[i+2]}));
            //System.out.println(String.format("Temp is %d and divisor will be: %d", temp, divisors[i]));
            if(temp % divisors[i] != 0){
                divisible = false;
                break;
            }
        }
        return divisible;
    }
}
