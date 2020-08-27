package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.Arrays;
import java.util.List;

public class Problem47 implements Problem<Long> {
    @Override
    public Long solve() {
        int targetpf = 4;
        int targetConsec = 4;
        int consec = 1;
        int result = 2 * 3 * 5 *7;

        while (consec < targetConsec) {
            result++;
            if (MathHelper.numberOfPrimeFacors(result) >= targetpf) {
                consec++;
            } else {
                consec = 0;
            }
        }

//        int count = 0;
//        long[] nums = new long[]{0 ,0 ,0};
//        while(count != 3) {
//
//            for (long i = 10; i < 10000000; i++) {
//                //System.out.println("Solving for i: " + i);
//                List<Long> factors = MathHelper.findFactorsPrime(i);
//                //System.out.println(Arrays.toString(factors.toArray()));
//                boolean allPrime = true;
//                if(factors.size() > 1) {
//                    for (Long l : factors) {
//                        if (!MathHelper.isPrime(l)) {
//                            allPrime = false;
//                        }
//                    }
//                    if (allPrime) {
//                        //System.out.println(i + " allPrime factors? " + allPrime);
//                        nums[count] = i;
//                        count++;
//                    } else {
//                        count = 0;
//                        nums = new long[]{0, 0, 0};
//                    }
//                }
//            }
//        }
//        return nums[0];
        return (long)result-targetConsec+1;
    }
}
