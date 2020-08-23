package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.ArrayList;
import java.util.List;

public class Problem37 implements Problem<Long>{
    @Override
    public Long solve() {
        long totSum = 0;

        List<Integer> found = new ArrayList<Integer>();
        for(int i = 8; i < 1_000_000 ; i++){
            if(MathHelper.isPrime(i)){
                System.out.println("Solving for prime: " + i);
                boolean allPrime = true;

                // From left
                int temp = i;
                while(temp > 9){
                    temp = Integer.parseInt(Integer.toString(temp).substring(1));
                    System.out.println("Temp is: " + temp);
                    if(!MathHelper.isPrime(temp)){
                        allPrime = false;
                        break;
                    }
                }
                System.out.println("Left remove resulted in allprime:" + allPrime);

                // From right
                temp = i/10;
                while (temp > 0) {
                    System.out.println("Temp is: " + temp);
                    if(!MathHelper.isPrime(temp)){
                        allPrime = false;
                        break;
                    }
                    temp = temp / 10;
                }

                System.out.println("Right remove resulted in allprime:" + allPrime);


                if(allPrime){
                    found.add(i);
                    totSum+=i;
                }
            }
        }

//        System.out.println(Arrays.toString(found.toArray()));

        return totSum;
    }
}
