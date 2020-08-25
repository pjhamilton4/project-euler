package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;

import java.util.HashSet;

public class Problem45 implements Problem<Long>{

    private static final int SOLVE_FOR = 100000000;

    @Override
    public Long solve() {

//        Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
//        Pentagonal 	  	Pn=n(3n−1)/2 	  	1, 5, 12, 22, 35, ...
//        Hexagonal 	  	Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...

        long found = 0;
        // THIS WILL TAKE FOREVER TO SOLVE
//        int count = 0;
//        for(int t = 285; t < 100000; t++){
//            long tn = MathHelper.solveTriangle(t);
//            for(int p = 165; p < 100000; p++){
//                long pn = MathHelper.solvePentagonal(p);
//                for(int h = 143; h < 100000; h++){
//                    long hn = MathHelper.solveHexagonal(h);
//                    if(tn == pn && pn == hn){
//                        System.out.println(String.format("FOUND ONE! t: %d, p: %d, h: %d = %d", t, p, h, tn));
//                        found = tn;
//                        count++;
//                    }
//                }
//            }
//        }

        //Apparently you just need to check for hexagonal numbers
        HashSet<Long> pentSet = new HashSet<Long>(SOLVE_FOR);

        //Probably a formula to check for these numbers on the fly, but for now I'll build a reference set
        System.out.println("---------------- START BUILDING PENTAGONALS ----------------");
        for(int i = 1; i < SOLVE_FOR; i++){
            Long temp = MathHelper.solvePentagonal(i);
            //pentMap.put((long)i, temp);
            pentSet.add(temp);
        }
        System.out.println("---------------- DONE ----------------");


        int i = 144; //Start at 144 since we know 143 was the first hexagonal1
        boolean foundNext = false;
        while(!foundNext){
            long pn = i * ((2 * i) - 1);
            System.out.println("-----------------" + i + "-----------------");
            System.out.println(pn);
            if(pentSet.contains(pn)){
                System.out.println(pn);
                foundNext = true;
            }
            i++;
        }

        return found;
    }
}
