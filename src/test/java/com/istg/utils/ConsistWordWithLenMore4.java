package com.istg.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConsistWordWithLenMore4 {

    private String[]strings;
    private boolean expected;

    public ConsistWordWithLenMore4(String[]strings,boolean expected){
        this.strings = strings;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new String[]{"asda","dasdad","asdasd"},true},
                {new String[]{"asda","dasdad","asdasd"},true},
                {new String[]{"2","1","2"},false},
                {new String[]{"asda","dasdad","asdasd"},true},
                {new String[]{"asda","dasdad","asdasd"},true},
                {new String[]{"asd","da","a"},false},
                {new String[]{"asd"},false},
        });
    }

    @Test
    public void testSizeMassiveMore3(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setString(strings);

        boolean result = massiveUtils.ConsisteWordWithLenMore4();

        assertEquals(expected,result);
    }
}
