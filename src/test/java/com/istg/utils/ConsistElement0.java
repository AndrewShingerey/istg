package com.istg.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConsistElement0 {

    private int[]number;
    private boolean expected;

    public ConsistElement0(int[]number,boolean expected){
        this.number = number;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new int[]{45,0},true},
                {new int[]{22,33},false},
                {new int[]{77,0},true},
                {new int[]{25,0},true},
                {new int[]{12,55},false},
                {new int[]{12,0},true},
                {new int[]{91,8},false}
        });
    }

    @Test
    public void testConsistMorethen0(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setNumber(number);

        boolean result = massiveUtils.ConsistElement0();

        assertEquals(expected,result);
    }

}
