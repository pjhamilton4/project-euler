package com.philipjhamilton;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.LongStream;

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

    public static long sumForArrayList(List<Long> list){
        long sum = 0;
        for (long i : list) {
            sum += i;
        }
        return sum;
    }


    public static ArrayList<Long> findFactors(Long num){
        HashSet<Long> factors = new HashSet<Long>();

        for(long i = 2; i <= Math.sqrt(num); i += (num % 2 == 0? 1: 2)){
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

    public static ArrayList<Long> findFactorsPrime(Long num){
        HashSet<Long> factors = new HashSet<Long>();

        for(long i = 2; i <= Math.sqrt(num); i += (num % 2 == 0? 1: 2)){
            if (num % i == 0) {
                if(MathHelper.isPrime(i)) {
                    factors.add(i);
                }
                if (i != num / i && num != num / i) {
                    if(MathHelper.isPrime(i)) {
                        factors.add(num / i);
                    }
                }
            }
        }
        //Could sort if you needed
        //Collections.sort(factors)

        return new ArrayList<Long>(factors);
    }

    public static long factorialUsingStreams(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }

    public static List<Long> rotateLong(long num){
        Set<Long> output = new HashSet<Long>(10);

        output.add(num); //Add num to output before changing it
        char[] temp = String.valueOf(num).toCharArray();

        for(int i = 0; i < temp.length-1; i++){
            char last = temp[temp.length-1];

            for(int j = temp.length-1; j > 0; j--){
                temp[j] = temp[j-1];
            }

            temp[0] = last;
            output.add(Long.valueOf(new String(temp)));
        }

        return new ArrayList<Long>(output);
    }

    public static boolean isPalindrome(String num){
        boolean isPalindrome = true;

        char[] numArr =  num.toCharArray();

        for(int i=0; i <= numArr.length/2; i++){
            if (numArr[0+i] != numArr[(numArr.length-1) - i]){
                isPalindrome = false;
            }
        }

        return isPalindrome;
    }

    public static boolean isPalindrome(int num){
        return isPalindrome(String.valueOf(num));
    }

    public static boolean isPandigital(String num){
        boolean isPandigital = false;
        char[] nums = {'0', '1','2','3','4','5','6','7','8','9'};

        //System.out.println("Attempting to match string " + num + " to pandigital");
        int matched = 0;
        HashSet<Character> found = new HashSet<Character>();
        for(char c: num.toCharArray()){
            for(int i = 0; i < nums.length; i++){

                if( !found.contains(c) && c == nums[i] ){
                    matched++;
                    found.add(c);
                }
            }
        }
        if(matched == num.length()){
            isPandigital = true;
        }

        return isPandigital;
    }

    public static boolean isPandigital(String num, int digits){
        boolean isPandigital = false;
        char[] nums = {'1','2','3','4','5','6','7','8','9'};

        if(num.length() == digits){
            int matched = 0;
            HashSet<Character> found = new HashSet<Character>();
            for(char c: num.toCharArray()){
                for(int i = 0; i < digits; i++){
                    if(c == nums[i] && !found.contains(c)){
                        matched++;
                        found.add(c);
                    }
                }
            }
            if(matched == digits){
                isPandigital = true;
            }
        }
        return isPandigital;
    }


    public static boolean isPandigital(long num, int digits){
        return isPandigital(String.valueOf(num), digits);
    }

    public static long solveTriangle(long n){
        return n * (n + 1) / 2;
    }

    public static long solvePentagonal(long n){
        return n * ((3 * n) - 1) / 2;
    }

    public static long solveHexagonal(long n){
        return n * ((2 * n) - 1);
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true){
                output.add(i);
            }

        }
        return output;
    }

    public static int numberOfPrimeFacors(int number) {
        List<Integer> primes = sieveOfEratosthenes(10000);

        int nod = 0;
        boolean pf;
        int remain = number;

        for (int i = 0; i < primes.size(); i++) {
            // In case there is a remainder this is a prime factor as well
            // The exponent of that factor is 1
            if (primes.get(i) * primes.get(i) > number) {
                return ++nod;
            }

            pf = false;
            while (remain % primes.get(i) == 0) {
                pf = true;
                remain = remain / primes.get(i);
            }
            if (pf){
                nod++;
            }

            //If there is no remainder, return the count
            if (remain == 1) {
                return nod;
            }
        }
        return nod;
    }

}
