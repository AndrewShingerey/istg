package com.istg.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConsistMorethen2Negative {

    private int[]number;
    private boolean expected;

    public ConsistMorethen2Negative(int[]number,boolean expected){
        this.number = number;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new int[]{45,55,-4,-5},true},
                {new int[]{22,33,-3,6},false},
                {new int[]{77,33,-2,-3},true},
                {new int[]{25,75,-1,-3,4},true},
                {new int[]{12,55,-1,5},false},
                {new int[]{12,88,-2,-3},true},
                {new int[]{91,8},false}
        });
    }

    @Test
    public void testConsistMorethen2Negative(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setNumber(number);

        boolean result = massiveUtils.ConsistMoreThen2NagativeElement();

        assertEquals(expected,result);
    }
}
