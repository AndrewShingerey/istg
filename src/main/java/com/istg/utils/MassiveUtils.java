package com.istg.utils;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;

public class MassiveUtils {
        private int[]number;
        private String[]string;
        private int[]number_1;
        private int[]number_2;
        public MassiveUtils() {
        }

        public MassiveUtils(int[] number, String[] string) {
                this.number = number;
                this.string = string;
        }

        public int[] getNumber_1() {
                return number_1;
        }

        public void setNumber_1(int[] number_1) {
                this.number_1 = number_1;
        }

        public int[] getNumber_2() {
                return number_2;
        }

        public void setNumber_2(int[] number_2) {
                this.number_2 = number_2;
        }

        public int[] getNumber() {
                return number;
        }

        public void setNumber(int[] number) {
                this.number = number;
        }

        public String[] getString() {
                return string;
        }

        public void setString(String[] string) {
                this.string = string;
        }

        public boolean SummaMoreThen100(){
                if(Arrays.stream(number).sum()>99){
                        return true;
                }else{
                        return false;
                }
        }

        public boolean ConsistMoreThen2NagativeElement(){
                int count = 0;
                for (int i = 0; i < this.number.length; i++) {
                        if(this.number[i]<0){
                                count++;
                        }
                }

                if(count>=2){
                        return true;
                }else{
                        return false;
                }
        }

        public boolean ConsistElement0(){
                int count = 0;
                for (int i = 0; i < this.number.length; i++) {
                        if(this.number[i]==0){
                                count++;
                        }
                }

                if(count>=1){
                        return true;
                }else{
                        return false;
                }
        }

        public boolean SizeMassiveMore3(){
                if(this.number.length >=3){
                        return true;
                }else{
                        return false;
                }
        }

        public boolean ConsisteWordWithLenMore4(){
                int count = 0;
                for (int i = 0; i < this.string.length; i++) {
                        if(this.string[i].length()>=4){
                                count++;
                        }
                }
                if(count>=1){
                        return true;
                }else{
                        return false;
                }
        }

        public String moreShortWord(){
                return Arrays.stream(string).min((o1, o2)->o1.length()-o2.length()).get();
        }

        public int[]equalsTwoMassiveBySize(){
                if(getNumber_2().length>getNumber_1().length) {
                     return getNumber_2();
                }else{
                     return getNumber_1();
                }
        }

}


