package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem35 implements Problem<Integer>{
    @Override
    public Integer solve() {

        HashSet<Integer> circulars = new HashSet<Integer>();

        int num = 1;
        while(num < 1_000_000){
            if(MathHelper.isPrime(num)){
                //System.out.println(num + " is PRIME!");
                List<Long> rotations = MathHelper.rotateLong(num);

                boolean allPrimes = true;
                for(Long l: rotations){
                    if(!MathHelper.isPrime(l)){
                        allPrimes=false;
                    }
                }

                if(allPrimes){
                    circulars.add(num);
                }
            }
            num++;
        }

        return circulars.size();
    }
}
