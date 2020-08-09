package com.philipjhamilton.problem;

import com.philipjhamilton.files.FileReader;

public class Problem11 implements Problem<Long>{

    @Override
    public Long solve() {
        Long greatestProduct = 0L;

        int[][] arrayIn = FileReader.readToGrid("Problem11.txt", 20, 20);

        // four up/down - row index: 0, 0+1, 0+2, 0+3
        // four right/left - column index: 0, 0+1, 0+2, 0+3
        // four diagonally
        // This can all probably be reduced to a few rules but this works for now
        for(int i = 0; i < arrayIn.length; i++){
//            System.out.println(Arrays.toString(arrayIn[i]));
            long temp = 0L;
            for(int y = 0; y < arrayIn[i].length; y ++){
                // four right
                if(y < arrayIn[i].length - 3) {
                    temp = arrayIn[i][y] * arrayIn[i][y + 1] * arrayIn[i][y + 2] * arrayIn[i][y + 3];
                    //System.out.println(String.format("RIGHT[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i][y + 1], arrayIn[i][y + 2], arrayIn[i][y + 3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four left
                if(y >= 3){
                    temp = arrayIn[i][y] * arrayIn[i][y - 1] * arrayIn[i][y - 2] * arrayIn[i][y - 3];
                    //System.out.println(String.format("LEFT[-3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i][y - 1], arrayIn[i][y - 2], arrayIn[i][y - 3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four up
                if(i >= 3){
                    temp = arrayIn[i][y] * arrayIn[i-1][y] * arrayIn[i-2][y] * arrayIn[i-3][y];
                    //System.out.println(String.format("UP[-3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i-1][y], arrayIn[i-2][y], arrayIn[i-3][y]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four down
                if(i < arrayIn.length-3){
                    temp = arrayIn[i][y] * arrayIn[i+1][y] * arrayIn[i+2][y] * arrayIn[i+3][y];
                    //System.out.println(String.format("DOWN[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i+1][y], arrayIn[i+2][y], arrayIn[i+3][y]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four down diagonally RIGHT
                if(i < arrayIn.length-3 && y < arrayIn[i].length - 3){
                    temp = arrayIn[i][y] * arrayIn[i+1][y+1] * arrayIn[i+2][y+2] * arrayIn[i+3][y+3];
                    //System.out.println(String.format("DIAGONAL RIGHT DOWN[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i+1][y+1], arrayIn[i+2][y+2], arrayIn[i+3][y+3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four up diagonally RIGHT
                if(i >= 3 && y < arrayIn[i].length - 3){
                    temp = arrayIn[i][y] * arrayIn[i-1][y+1] * arrayIn[i-2][y+2] * arrayIn[i-3][y+3];
                    //System.out.println(String.format("DIAGONAL RIGHT UP[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i-1][y+1], arrayIn[i-2][y+2], arrayIn[i-3][y+3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four down diagonally LEFT
                if(i < arrayIn.length-3 && y >= 3){
                    temp = arrayIn[i][y] * arrayIn[i+1][y-1] * arrayIn[i+2][y-2] * arrayIn[i+3][y-3];
                    //System.out.println(String.format("DIAGONAL LEFT DOWN[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i+1][y-1], arrayIn[i+2][y-2], arrayIn[i+3][y-3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
                // four UP diagonally LEFT
                if(i >= 3 && y >= 3){
                    temp = arrayIn[i][y] * arrayIn[i-1][y-1] * arrayIn[i-2][y-2] * arrayIn[i-3][y-3];
                    //System.out.println(String.format("DIAGONAL LEFT UP[+3 idx]: %d * %d * %d * %d", arrayIn[i][y], arrayIn[i-1][y-1], arrayIn[i-2][y-2], arrayIn[i-3][y-3]));
                    if(temp > greatestProduct){
                        greatestProduct = temp;
                        //System.out.println("FOUND LARGER: " + temp);
                    }
                }
            }
        }

        return greatestProduct;
    }

}
