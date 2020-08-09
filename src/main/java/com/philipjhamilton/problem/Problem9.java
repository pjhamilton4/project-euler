package com.philipjhamilton.problem;

public class Problem9 implements Problem<Long>{

    @Override
    public Long solve() {

        long[] output = new long[]{0, 0, 0};

        boolean found = false;
        while(found != true){
            for(int a = 1; a < 1_000; a++) {
                for (long b = 1; b < 1_000; b++) {
                    for (long c = 1; c < 1_000; c++) {
                        if (a + b + c == 1000 && (a < b && b < c)) {
                            if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                                System.out.println(String.format("FOUND IT!: %d - %d - %d", a, b, c));
                                output[0] = a;
                                output[1] = b;
                                output[2] = c;
                                found = true;
                            }
                        }
                    }
                }
            }
        }

        return output[0] * output[1] * output[2];
    }

}
