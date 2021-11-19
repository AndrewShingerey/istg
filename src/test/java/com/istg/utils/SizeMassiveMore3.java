package com.istg.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SizeMassiveMore3 {

    private int[]number;
    private boolean expected;

    public SizeMassiveMore3(int[]number,boolean expected){
        this.number = number;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new int[]{45,55,-4,-5},true},
                {new int[]{22,33},false},
                {new int[]{77,33,-2,-3},true},
                {new int[]{25,75,-1,-3,4},true},
                {new int[]{12,55},false},
                {new int[]{12,88,-2,-3},true},
                {new int[]{91,8},false}
        });
    }

    @Test
    public void testSizeMassiveMore3(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setNumber(number);

        boolean result = massiveUtils.SizeMassiveMore3();

        assertEquals(expected,result);
    }
}
