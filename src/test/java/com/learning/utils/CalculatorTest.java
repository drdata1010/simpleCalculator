package com.learning.utils;

import org.junit.jupiter.api.Test;

import static com.learning.utils.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public void checkEmptyReturn0(){
        assertEquals(0, add(""));
    }
    @Test
    public void singleNumDontAdd(){
        assertEquals(28,Calculator.add("28"));
    }
    @Test
    public void addTwoNumsReturnSum(){
        assertEquals(3, Calculator.add("1,2"));
    }
    @Test
    public void addAnyNumsReturnSum(){
        assertEquals(6,Calculator.add("1,2,3"));
    }
    @Test
    public void addNumsWithNewlines(){
        assertEquals(9, Calculator.add("1,4\n4"));
    }
    @Test
    public void addNumsWithNewDelim(){
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
    @Test
    public void notAddNegativeNumbers(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            Calculator.add("1,-2,-3");
        });
        assertEquals("Negative numbers not allowed: -2,-3", exception.getMessage());
    }
    @Test
    public void notAddGreaterNums(){
        assertEquals(2,Calculator.add("1002,2"));
    }
    @Test
    public void acceptNLengthDelim(){
        assertEquals(6,Calculator.add("//***\\n1***2***3"));
    }
}
