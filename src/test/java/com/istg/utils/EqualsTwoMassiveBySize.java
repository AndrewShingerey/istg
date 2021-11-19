package com.istg.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class EqualsTwoMassiveBySize {

    private int[]number_1;
    private int[]number_2;
    private int[]expected;

    public EqualsTwoMassiveBySize(int[] number_1, int[] number_2, int[] expected) {
        this.number_1 = number_1;
        this.number_2 = number_2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new int[]{45,55},new int[]{45,55,12},new int[]{45,55,12}},
                {new int[]{425,551,2,1,2,3},new int[]{45,55,12},new int[]{425,551,2,1,2,3}},
                {new int[]{45},new int[]{45,55,12},new int[]{45,55,12}},
                {new int[]{45,55,1,2,2},new int[]{45,55,12,3,4,5,1},new int[]{45,55,12,3,4,5,1}},
                {new int[]{45,55,1,2},new int[]{45,55,12},new int[]{45,55,1,2},},
                {new int[]{45,55},new int[]{45,55,12,12,123},new int[]{45,55,12,12,123}},
                {new int[]{45,55},new int[]{12},new int[]{45,55}},
                {new int[]{0},new int[]{12},new int[]{12}},
                {new int[]{45,55,33},new int[]{12},new int[]{45,55,33}},
                {new int[]{45,55},new int[]{12,12,34},new int[]{12,12,34}},
                {new int[]{45,55},new int[]{12,12,34},new int[]{12,12,34}}

        });
    }

    @Test
    public void equalsTwoMassive(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setNumber_1(number_1);
        massiveUtils.setNumber_2(number_2);

        int[]result = massiveUtils.equalsTwoMassiveBySize();
        Assert.assertEquals(expected.length,result.length);
    }

}
