package com.philipjhamilton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class MathHelper {

    private enum NumberToWord{
        ZERO ("zero", 0),
        ONE ("one", 1),
        TWO ("two", 2),
        THREE ("three", 3),
        FOUR ("four", 4),
        FIVE ("five", 5),
        SIX ("six", 6),
        SEVEN ("seven", 7),
        EIGHT ("eight", 8),
        NINE ("nine", 9),
        TEN ("ten", 10),
        ELEVEN ("eleven", 11),
        TWELVE ("twelve", 12),
        THIRTEEN ("thirteen", 13),
        FOURTEEN ("fourteen", 14),
        FIFTEEN ("fifteen", 15),
        SIXTEEN ("sixteen", 16),
        SEVENTEEN ("seventeen", 17),
        EIGHTEEN ("eighteen", 18),
        NINETEEN ("nineteen", 19),
        TWENTY ("twenty", 20),
        THIRTY ("thirty", 30),
        FORTY ("forty", 40),
        FIFTY ("fifty", 50),
        SIXTY ("sixty", 60),
        SEVENTY ("seventy", 70),
        EIGHTY ("eighty", 80),
        NINETY ("ninety", 90);

        private final String word;
        private final Integer number;

        NumberToWord(String word, Integer number){
            this.word = word;
            this.number = number;
        }

        private String word() {return word;}
        private Integer number() {return number;}

        public static String valueOf(Integer value){
            for (NumberToWord l : NumberToWord.values()) {
                if (l.number == value) return l.word;
            }
            throw new IllegalArgumentException("Number not found. Value given: " + value);
        }
    }

    /**
     * Block from creation
     */
    private MathHelper(){};

    public static boolean isPrime(long n){

        if (n <= 1)
            return false;

        if(n == 2){
            return true;
        }

        if( n % 2 == 0 ){
            return false;
        }

        for(long i = 3L; i*i <= n; i += 2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static List<Integer> getDivisors(long n){
        List<Integer> out = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            if(n % i == 0){
                out.add(i);
            }
        }
        return out;
    }

    public static Long tau(Long numIn){
        long num = numIn;
        long start = 2;
        long product = 1;

        if(num == 1){
            return 1L;
        }

        while(start * start <= num){
            long count = 1;
            while(num % start == 0){
                num = num / start;
                count++;
            }
            start++;
            product = product * count;
        }

        if(num == numIn || num > 1){
            product *= 1 + 1;
        }

        return product;
    }

    // Only works for english of course
    public static String numberToWord(Integer number){
        StringBuilder sb = new StringBuilder(50);
        if(number < 100){
            if(number <= 20) {
                sb.append(NumberToWord.valueOf(number));
                return sb.toString();
            }else{
                if(number % 10 == 0){
                    String tens = NumberToWord.valueOf(number % 100);
                    sb.append(tens);
                }else {
                    String singles = NumberToWord.valueOf(number % 10);
                    number = number - (number % 10);
                    sb.append("-");
                    sb.append(singles);
                }
                return sb.toString();
            }
        }


//        else{
//            sb.append(NumberToWord.valueOf(number % 100));
//        }

        return sb.toString();
    }
}
