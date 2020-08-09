package com.philipjhamilton.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileReader{

    private FileReader(){};

    public static List readToLongArray(String file){
        List<Long> output = new ArrayList<Long>();
        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            while(scanner.hasNext())
            {
                String temp = scanner.next();
                for (char c: temp.toCharArray()) {
                    output.add((long)Character.getNumericValue(c));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static int[][] readToGrid(String file, int rows, int cols){
        int[][] output = new int [rows][cols];

        File inputFile = getFileFromResources(file);

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);

            int rowCount = 0;
            int colCount = 0;

            while(scanner.hasNext())
            {
                String temp = scanner.next();
                output[rowCount][colCount] = Integer.valueOf(temp);
                colCount++;
                if(colCount == 20){
                    colCount = 0;
                    rowCount++;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return output;
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
