package com.qiu.utils;

import java.util.Random;

public class CodeUtils {
    public static  String getActiveCode(){
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i <20 ; i++) {
char c=(char) (new Random().nextInt(26)+'A');
   buffer.append(c);
        }
        return buffer.toString();
    }
}
