package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.*;

public class Problem50 implements Problem<Long>{

    @Override
    public Long solve() {

        int longestRun = 0;

//        Set<Integer> primes = new TreeSet<Integer>();
//        //List of primes under 1 million
//        for(int i=1; i< 1000000; i++){
//            if(MathHelper.isPrime(i)){
//                primes.add(i);
//            }
//        }
//
//        List<Integer> sortedList = new ArrayList<Integer>(primes);
//        for(int i = 0; i < sortedList.size(); i++){
//            int sum = 0;
//            for(int j = i; j < sortedList.size(); j++){
//                    sum += sortedList.get(j);
//                    if (MathHelper.isPrime(sum) && sum < 1000000) {
//                        if (j > longestRun) {
//                            longestRun = j;
//                        }
//                    }else{
//                        break;
//                    }
//            }
//        }

        return 0L;
        //return (long)sortedList.get(longestRun);
    }
}
