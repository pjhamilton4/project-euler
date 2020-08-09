package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.util.List;

public class Problem8 implements Problem<Long>{

    @Override
    public Long solve() {

        Long longestNum = 0L;

        List<Long> arr = FileReader.readToLongArray("problem8.txt");

        for(int i = 12; i < arr.size(); i++)
        {
            Long temp = arr.get(i-12) * arr.get(i-11) * arr.get(i-10) * arr.get(i-9) * arr.get(i-8) * arr.get(i-7)
                    * arr.get(i-6) * arr.get(i-5) * arr.get(i-4) * arr.get(i-3) * arr.get(i-2) * arr.get(i-1) * arr.get(i);
            if(temp > longestNum){
                longestNum = temp;
            }
        }

        return longestNum;
    }
}
