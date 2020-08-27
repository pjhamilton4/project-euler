package com.philipjhamilton.problem;

import com.philipjhamilton.MathHelper;
import com.philipjhamilton.files.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Problem50 implements Problem<Long> {

    @Override
    public Long solve() {

        ClassLoader classLoader = FileReader.class.getClassLoader();

        URL resource = classLoader.getResource("test_file.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(new File(resource.getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(areParanthesisBalanced(input));
        }

        return 0L;
        //return (long)sortedList.get(longestRun);
    }

    static boolean areParanthesisBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    stack.pop();
                    if (x == '{' || x == '[')
                        return false;
                    break;

                case '}':
                    stack.pop();
                    if (x == '(' || x == '[')
                        return false;
                    break;

                case ']':
                    stack.pop();
                    if (x == '(' || x == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
}
