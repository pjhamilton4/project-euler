package com.philipjhamilton.problem;

public class Problem14 implements Problem<Long>{
    @Override
    public Long solve() {

        long longestChain = 1;
        long numForLongestChain = 0;

        for(int i = 999999; i > 0; i--){
            long currNbr = i;
            long currChain = 1;
            while(currNbr > 1){
                if(currNbr % 2 == 0) {
                    currNbr = currNbr / 2;
                    currChain++;
                }else{
                    currNbr = (3 * currNbr) + 1;
                    currChain++;
                }
            }
            if(currChain>longestChain){
                System.out.println("(NEW LONGEST CHAIN) Found using: " + i + ". Chain was of length: " + currChain);
                longestChain=currChain;
                numForLongestChain=i;
            }
        }

        return numForLongestChain;
    }
}
