package com.learning.utils;

public class Calculator {
    public static int add(String input){
        if(input.equals("")) return 0;

        if(!input.contains(",")){
            return Integer.parseInt(input);
        } else {
            String[] nums = input.split(",");
            int sum = 0;
            for(String num : nums){
                sum += Integer.parseInt(num);
            }
            return sum;
        }
    }
}
