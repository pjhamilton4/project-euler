package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

import java.io.IOException;

public class Problem18 implements Problem<Integer>{

    @Override
    public Integer solve(){
        int[][] triangle = FileReader.readToTriangle("Problem18.txt");
        int[] largestValues = new int[triangle.length-1];

        // Start at bottom of "tree"
        for(int x = triangle.length-2; x >= 0; x--){
            for(int y = 0; y <= x; y++){
                largestValues[y] = triangle[x][y] += (triangle[x+1][y] > triangle[x+1][y+1] ? triangle[x+1][y] : triangle[x+1][y+1]);
            }

        }

//        for(int x = triangle.length-1; x >= 0; x--){
//            if(x == 0){
//                System.out.println(String.format("Starting with X,Y: %d, %d with value: %d", x, bestIdx, triangle[x][bestIdx]));
//                pathSum += triangle[0][0];
//                continue;
//            }
//            if(triangle[x][bestIdx] > triangle[x][bestIdx+1]){
//                System.out.println(String.format("Choosing X,Y: %d, %d with value: %d", x, bestIdx, triangle[x][bestIdx]));
//                System.out.println(triangle[x][bestIdx]);
//                pathSum += triangle[x][bestIdx];
//                continue;
//            }else {
//                System.out.println(String.format("Choosing X,Y: %d, %d with value: %d", x, bestIdx+1, triangle[x][bestIdx+1]));
//                System.out.println(triangle[x][bestIdx+1]);
//                pathSum += triangle[x][bestIdx+1];
//                bestIdx = bestIdx+1;
//            }
//            for(int y = 0; y < triangle[x].length; y++){
//                if(y == 0){
//                    break;
//                }
//            }
//        }

        System.out.println(largestValues[0]);

        return largestValues[0];
    }

}
