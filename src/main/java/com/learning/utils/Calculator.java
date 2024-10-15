package com.learning.utils;

public class Calculator {
    public static int add(String input){
        if(input.equals("")) return 0;

        if(!input.contains(",")){
            return Integer.parseInt(input);
        } else {
            String[] nums = input.split(",");
            return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        }
    }
}
