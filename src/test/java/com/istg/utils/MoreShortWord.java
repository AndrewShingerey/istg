package com.istg.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoreShortWord {
    private String[]strings;
    private String expected;

    public MoreShortWord(String[]strings,String expected){
        this.strings = strings;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection parametrs(){
        return Arrays.asList(new Object[][]{
                {new String[]{"as","dasdad","asdasd"},"as"},
                {new String[]{"asda","dasdad","asdasd"},"asda"},
                {new String[]{"2s","1ss","2"},"2"},
                {new String[]{"asda","dasdad","asdasd"},"asda"},
                {new String[]{"asda","dasdad","asdasd"},"asda"},
                {new String[]{"asd","da","a"},"a"},
                {new String[]{"asd"},"asd"}
        });
    }

    @Test
    public void MoreShortWord(){
        MassiveUtils massiveUtils = new MassiveUtils();
        massiveUtils.setString(strings);

        String result = massiveUtils.moreShortWord();

        assertEquals(expected,result);
    }


}
