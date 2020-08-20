package com.philipjhamilton.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class FileReader {

    private FileReader(String file) {
    }

    public static List readToLongArray(String file) {
        List<Long> output = new ArrayList<Long>();
        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            while (scanner.hasNext()) {
                String temp = scanner.next();
                for (char c : temp.toCharArray()) {
                    output.add((long) Character.getNumericValue(c));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static int[][] readToGrid(String file, int rows, int cols) {
        int[][] output = new int[rows][cols];

        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            int rowCount = 0;
            int colCount = 0;

            while (scanner.hasNext()) {
                String temp = scanner.next();
                output[rowCount][colCount] = Integer.valueOf(temp);
                colCount++;
                if (colCount == 20) {
                    colCount = 0;
                    rowCount++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static int[][] readToTriangle(String file) {
        int[][] output = null;

        try {
            File inputFile = getFileFromResources(file);

            BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile));
            int lines = 0;
            while (reader.readLine() != null) lines++;

            reader.close();

            output = new int[lines][];

            //Setup 2d array - this can probably be done at scan time but this will work for now.
            for (int i = 0; i < lines; i++) {
                output[i] = new int[i+1];
            }

            Scanner scanner = null;
            scanner = new Scanner(inputFile);

            int x = 0;
            int y = 0;
            int temp;
            while (scanner.hasNext()) {
                temp = scanner.nextInt();
                //System.out.println(String.format("X: %d, Y: %d - input: %d", x, y, temp));
                output[x][y] = temp;
                if (y == output[x].length-1) {
                    x++;
                    y = 0;
                }else {
                    y++;
                }
            }

//            for (int[] arr : output) {
//                System.out.println(Arrays.toString(arr));
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return output;
        }
    }

    public static List<BigInteger> readLinestoBigIntegers(String file) {
        List<BigInteger> output = new ArrayList<BigInteger>(100);

        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            while (scanner.hasNextBigInteger()) {
                output.add(scanner.nextBigInteger());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<String> readStringsFromFile(String file){
        List<String> output = new ArrayList<String>(6000);

        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            while (scanner.hasNext()) {
                String[] temp = scanner.next().split(",");
                for(String s: temp){
                    output.add(s.replace("\"", ""));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return (ArrayList<String>)output;
    }

    private static File getFileFromResources(String fileName) {

        ClassLoader classLoader = FileReader.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
