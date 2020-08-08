package com.philipjhamilton.problem;

public class Problem5 implements Problem<Long>{

    @Override
    public Long solve() {
        Long currNum = 1L;
        boolean metAll = false;
        while(!metAll){
            int evenCount = 0;
            for(int i = 1; i <= 20; i++){
                if(currNum % i == 0){
                    evenCount++;
                }
            }
            if(evenCount == 20){
                metAll = true;
            }else{
                currNum++;
            }
        }

        return currNum;
    }

}
