package com.philipjhamilton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class MathHelper {

    private enum NumberToWord {
        ZERO("zero", 0),
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9),
        TEN("ten", 10),
        ELEVEN("eleven", 11),
        TWELVE("twelve", 12),
        THIRTEEN("thirteen", 13),
        FOURTEEN("fourteen", 14),
        FIFTEEN("fifteen", 15),
        SIXTEEN("sixteen", 16),
        SEVENTEEN("seventeen", 17),
        EIGHTEEN("eighteen", 18),
        NINETEEN("nineteen", 19),
        TWENTY("twenty", 20),
        THIRTY("thirty", 30),
        FORTY("forty", 40),
        FIFTY("fifty", 50),
        SIXTY("sixty", 60),
        SEVENTY("seventy", 70),
        EIGHTY("eighty", 80),
        NINETY("ninety", 90);

        private final String word;
        private final Integer number;

        NumberToWord(String word, Integer number) {
            this.word = word;
            this.number = number;
        }

        private String word() {
            return word;
        }

        private Integer number() {
            return number;
        }

        public static String valueOf(Integer value) {
            for (NumberToWord l : NumberToWord.values()) {
                if (l.number == value) return l.word;
            }
            throw new IllegalArgumentException("Number not found. Value given: " + value);
        }
    }

    /**
     * Block from creation
     */
    private MathHelper() {
    }

    ;

    public static boolean isPrime(long n) {

        if (n <= 1)
            return false;

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (long i = 3L; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> getDivisors(long n) {
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                out.add(i);
            }
        }
        return out;
    }

    public static Long tau(Long numIn) {
        long num = numIn;
        long start = 2;
        long product = 1;

        if (num == 1) {
            return 1L;
        }

        while (start * start <= num) {
            long count = 1;
            while (num % start == 0) {
                num = num / start;
                count++;
            }
            start++;
            product = product * count;
        }

        if (num == numIn || num > 1) {
            product *= 1 + 1;
        }

        return product;
    }

    // Only works for english of course
    public static String numberToWord(Integer number) {
        StringBuilder sb = new StringBuilder(50);

        int tempNum = number;
        int numLen = String.valueOf(tempNum).length();

        if(numLen == 4){
            int thousands = tempNum / 1000;
            sb.append(NumberToWord.valueOf(thousands));
            sb.append(" thousand");
            tempNum = tempNum % 1000;
            if(tempNum != 0){
                numLen = String.valueOf(tempNum).length();
                sb.append(" and ");
            }
        }

        if(numLen == 3){
            int hundreds = tempNum /100;
            sb.append(NumberToWord.valueOf(hundreds));
            sb.append(" hundred");
            tempNum = tempNum % 100;
            if(tempNum != 0){
                numLen = String.valueOf(tempNum).length();
                sb.append(" and ");
            }
        }

        if(numLen == 2 && tempNum >= 21){
            int tens = tempNum / 10;
            sb.append(NumberToWord.valueOf(tens * 10));
            tempNum = tempNum % 10;
            if(tempNum != 0){
                numLen = String.valueOf(tempNum).length();
                sb.append("-");
            }
        }

        if(numLen <= 2 && tempNum < 21 && tempNum > 0){
            sb.append(NumberToWord.valueOf(tempNum));
        }

        //System.out.println(sb.toString().replace(" ","").replace("-", "").length());
        //System.out.println(sb.toString());
        return sb.toString();
    }

    public static ArrayList<Long> findFactors(Long num){
        HashSet<Long> factors = new HashSet<Long>();

        for(long i = 1; i <= Math.sqrt(num); i += (num % 2 == 0? 1: 2)){
            if (num % i == 0) {
                factors.add(i);

                if (i != num / i && num != num / i) {
                    factors.add(num / i);
                }
            }
        }
        //Could sort if you needed
        //Collections.sort(factors)

        return new ArrayList<Long>(factors);
    }

}
