package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.*;

// TODO - SOLVE THIS
public class Problem23 implements Problem<Long> {

    private static final int LIMIT = 28123;

    @Override
    public Long solve() {
        long totSum = 0;
        Set<Integer> abundant = new HashSet<Integer>(LIMIT);

        for(Integer i = 2; i < LIMIT; i++){
            if(MathHelper.sumForArrayList(MathHelper.findFactors((long)i)) > i){
                abundant.add(i);
            }
        }

        System.out.println(Arrays.toString(abundant.toArray()));
        System.out.println(abundant.size());

        List<Integer> abundantList = new ArrayList<Integer>(abundant);
        boolean[] abundentAdded = new boolean[LIMIT+1];
        for(int i = 0; i < abundantList.size(); i++){
            for(int j = i; j < abundantList.size(); j++){
                if(abundantList.get(i) + abundantList.get(j) <= LIMIT){
                    abundentAdded[abundantList.get(i) + abundantList.get(j)] = true;
                }else{
                    break;
                }
            }
        }

        for(int i = 1; i <= LIMIT; i++){
            if(!abundentAdded[i]){
                totSum+=i;
            }
        }

        return totSum;
    }
}
