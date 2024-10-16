package com.learning.utils;

import java.util.ArrayList;
import java.util.List;
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
        List<String> negativeNums = new ArrayList<>();
        String[] nums = input.split(delimiter);
        int sum = 0;
        for (String num : nums) {
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if(number < 0) {
                    negativeNums.add(num);
                } else {
                    if(number > 1000){
                        number = 0;
                    }
                    sum += number;
                }
            }
        }
        if(!negativeNums.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: "+String.join(",", negativeNums));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.add("//;\n1;2"));  // Output: 3
        System.out.println(Calculator.add("1,2,3"));      // Output: 6
        System.out.println(Calculator.add(""));           // Output: 0
        System.out.println(Calculator.add("//:\n4:5"));   // Output: 9
        System.out.println(Calculator.add("1002,2"));           // Output: 2

    }
}
