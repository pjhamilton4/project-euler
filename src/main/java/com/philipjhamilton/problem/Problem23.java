package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// TODO - SOLVE THIS
public class Problem23 implements Problem<Long> {
    @Override
    public Long solve() {
        long totSum = 0;
        HashSet<Long> abundant = new HashSet<Long>();


        for(long i = 1; i < 28123; i++){
            List<Long> numDiv = MathHelper.findFactors(i);

            //System.out.println(Arrays.toString(numDiv.toArray()));
            long sum = 0;
            for (Long n : numDiv) {
                sum += n;
            }

            if(sum > i){
                abundant.add(i);
            }
        }

        System.out.println(Arrays.toString(abundant.toArray()));
        System.out.println(abundant.size());
        HashSet<Long> toRemove = new HashSet<Long>();
        for(Long l: abundant){
            if(abundant.contains(l+l)){
                toRemove.add(l+l);
            }
        }

        abundant.removeAll(toRemove);

        for(long l: abundant){
            totSum+=l;
        }

        System.out.println(Arrays.toString(abundant.toArray()));
        System.out.println(abundant.size());

        return totSum;
    }
}
