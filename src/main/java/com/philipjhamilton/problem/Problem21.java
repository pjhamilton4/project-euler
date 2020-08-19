package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.*;

public class Problem21 implements Problem<Long>{

    @Override
    public Long solve() {
        Set<Long> amicable = new HashSet<Long>();

        for(long i = 2; i < 10_000; i++) {
            long sum1 = sumForArrayList(MathHelper.findFactors(i));

            //System.out.printf("Sum of first proper divisors %d \n", sum1);

            long sum2 = sumForArrayList(MathHelper.findFactors(sum1));

            //System.out.printf("Sum of proper divisors of %d \n", sum2);

            if(sum2 == i && sum1 != sum2){
                amicable.add(i);
                amicable.add(sum1);
            }
        }

        Long sumTotal = sumForArrayList(new ArrayList<Long>(amicable));

        System.out.println(Arrays.toString(amicable.toArray()));

        return sumTotal;
    }

    private long sumForArrayList(List<Long> list){
        long sum = 0;
        for (long i : list) {
            sum += i;
        }
        return sum;
    }
}
