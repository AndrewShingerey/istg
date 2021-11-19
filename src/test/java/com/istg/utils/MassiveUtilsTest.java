package com.istg.utils;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassiveUtilsTest extends TestCase {

    private int[]number;
    private boolean expected;

    public MassiveUtilsTest(int[]number,boolean expected){
        this.number = number;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new int[]{45,55},true},
                {new int[]{22,33},false},
                {new int[]{77,33},true},
                {new int[]{25,75},true},
                {new int[]{12,55},false},
                {new int[]{12,88},true},
                {new int[]{91,8},false}
        });
    }

    @Test
    public void testSummaMoreThen100() {
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setNumber(number);

        boolean result = massiveUtils.SummaMoreThen100();

        assertEquals(expected,result);
    }


}