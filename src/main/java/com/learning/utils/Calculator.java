package com.learning.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        if (input.isEmpty()) return 0;
        String delimiter = ",|\n";
        if (input.startsWith("//")) {

            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }

        String[] nums = input.split(delimiter);
        int sum = 0;
        for (String num : nums) {
            if (!num.isEmpty()) {
                sum += toInt(num);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.add("//;\n1;2"));  // Output: 3
        System.out.println(Calculator.add("1,2,3"));      // Output: 6
        System.out.println(Calculator.add(""));           // Output: 0
        System.out.println(Calculator.add("//:\n4:5"));   // Output: 9
        System.out.println(Calculator.add("1"));           // Output: 1

    }

    private static int toInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}
