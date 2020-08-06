package com.philipjhamilton.problem;

public class Problem1 implements Problem<Integer> {

    @Override
    public Integer solve() {
        int sum = 0;

        for(int i = 0; i < 1000; i++){
            if(i % 15 == 0){
                sum += i;
            }else if (i % 5 == 0){
                sum += i;
            }else if (i % 3 == 0){
                sum += i;
            }
        }
        return sum;
    }

}
