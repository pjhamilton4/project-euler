package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Problem13 implements Problem<String>{
    @Override
    public String solve() {

        List<BigInteger> bigInts = FileReader.readLinestoBigIntegers("Problem13.txt");

        BigInteger sum = new BigInteger("0");
        for(BigInteger bi: bigInts){
            sum = sum.add(bi);
        }

        return sum.toString().substring(0,10);
    }
}
