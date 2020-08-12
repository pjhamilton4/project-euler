package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.io.IOException;

public class Problem18 implements Problem<Integer>{

    @Override
    public Integer solve(){
        int[][] triangle = FileReader.readToTriangle("Problem18.txt");

        int bestIdx = 0;
        int pathSum = 0;
        for(int x = 0; x < triangle.length; x++){
            if(x == 0){
                System.out.println(String.format("Starting with X,Y: %d, %d with value: %d", x, bestIdx, triangle[x][bestIdx]));
                pathSum += triangle[0][0];
                continue;
            }
            if(triangle[x][bestIdx] > triangle[x][bestIdx+1]){
                System.out.println(String.format("Choosing X,Y: %d, %d with value: %d", x, bestIdx, triangle[x][bestIdx]));
                System.out.println(triangle[x][bestIdx]);
                pathSum += triangle[x][bestIdx];
            }else {
                System.out.println(String.format("Choosing X,Y: %d, %d with value: %d", x, bestIdx+1, triangle[x][bestIdx+1]));
                pathSum += triangle[x][bestIdx+1];
                bestIdx = bestIdx+1;
            }
//            for(int y = 0; y < triangle[x].length; y++){
//                if(y == 0){
//                    break;
//                }
//            }
        }

        System.out.println(pathSum);

        return null;
    }

}
