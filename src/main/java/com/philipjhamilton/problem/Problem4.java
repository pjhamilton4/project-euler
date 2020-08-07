package com.philipjhamilton.problem;

public class Problem4 implements Problem<Integer>{
    @Override
    public Integer solve() {
        Integer solution = 0;

        for(int i = 100; i < 1000; i++){
            for(int y = 100; y < 1000; y++){
                Integer temp = i * y;

                Integer[] numArr = numberToArray(temp);
                if(numArr == null){
                    break;
                }

                if(numArr[0] == numArr[5]){
                    if(numArr[1] == numArr[4]){
                        if(numArr[2] == numArr[3]){
                            //System.out.println(String.format("Current found is || i: %d and y: %d = %d", i, y, temp));
                            if(temp > solution) {
                                solution = temp;
                            }
                        }
                    }
                }
            }
        }

        return solution;
    }

    public Integer[] numberToArray(Integer num){
        // Probably a better way to do this, but for time sake this will do
        if(num.toString().length() < 5){
            return null;
        }

        Integer[] numOut = new Integer[]{0, 0, 0, 0, 0, 0};

        numOut[5] = num % 10;
        num = num / 10;
        numOut[4] = num % 10;
        num = num / 10;
        numOut[3] = num % 10;
        num = num / 10;
        numOut[2] = num % 10;
        num = num / 10;
        numOut[1] = num % 10;
        num = num / 10;
        numOut[0] = num % 10;

        //System.out.println(Arrays.toString(numOut));

        return numOut;
    }
}
