package com.philipjhamilton.problem;

import java.util.*;

public class Problem44 implements Problem<Long>{

    private static final int SOLVE_FOR = 100000000;

    @Override
    public Long solve() {

        // formula
        // pn=n(3n-1)/2
        //HashMap<Long, Long> pentMap = new HashMap<Long, Long>();
        HashSet<Long> pentSet = new HashSet<Long>(SOLVE_FOR);

        //Probably a formula to check for these numbers on the fly, but for now I'll build a reference set
        System.out.println("---------------- START BUILDING PENTAGONALS ----------------");
        for(int i = 1; i < SOLVE_FOR; i++){
            Long temp = Long.valueOf(i) * ((3 * Long.valueOf(i))-1)/2;
            //pentMap.put((long)i, temp);
            pentSet.add(temp);
        }
        System.out.println("---------------- DONE ----------------");

        //pentMap.forEach((keyInt, aLong) -> System.out.println(String.format("KEY: %d | VALUE: %d", keyInt, aLong)));

        int foundPent = 0;

        boolean found = false;

        int i = 1;
        while(!found){
            i++;
            int n = i * (3 * i - 1) / 2;
            for(int j = i-1; j > 0; j--){
                //Solve for j
                int m = j * (3 * j - 1) / 2;
                System.out.println(String.format("Checking for values n: %d and m: %d for index: %d", n, m, i));
                if(pentSet.contains((long)n - m) && pentSet.contains((long)n + m)){
                    found = true;
                    foundPent = Math.abs(n-m);
                    break;
                }
            }
        }

//        long minimum = Long.MAX_VALUE;
//        for(int j = 1; j < 5000; j++){
//            for(int k = j-1; k > 0; k--){
//                //System.out.println(String.format("Getting values for J: %d and K: %d", j, k));
//                long addedVal = pentMap.get((long)j) + pentMap.get((long)k);
//                long subbedVal = pentMap.get((long)k) - pentMap.get((long)j);
//                //System.out.println(String.format("AddedVal and subbedVal: %d | %d", addedVal, subbedVal));
//                if(pentMap.containsKey(subbedVal) && pentMap.containsKey(addedVal)){
//                    System.out.println(String.format("Added: %d | Subbed: %d | j: %d | k: %d", addedVal, subbedVal, j, k));
//                    long found = Math.abs(pentMap.get(addedVal) - pentMap.get(subbedVal));
//                    if(found < minimum && found > 0){
//                        minimum = found;
//                        //System.out.println(String.format("Added: %d | Subbed: %d | j: %d | k: %d"));
//                        System.out.println("FOUND IS: " + minimum);
//                    }
//                }
//            }
//        }

        return (long) foundPent;
    }
}
