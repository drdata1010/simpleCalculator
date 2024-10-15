package com.learning.utils;

import org.junit.jupiter.api.Test;

import static com.learning.utils.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void checkEmptyReturn0(){
        assertEquals(0, add(""));
    }
    @Test
    public void singleNumDontAdd(){
        assertEquals(28,Calculator.add("28"));
    }
}
