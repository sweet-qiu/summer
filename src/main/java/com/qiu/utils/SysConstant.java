package com.qiu.utils;

public class SysConstant {
    public enum Status{
        NOT_ACTIVE(0),ACTIVT(1);
        int code;
        Status(int code){
            this.code=code;
        }
      public   int getCode(){
            return code;
        }
    }
    public  static final int NOT_ACTIVE=0;
    public  static final  int CUSTOMER=0;


    public  static final String FORWARD="forward";
    public  static final String REDIRECT="redirect";
    public  static final String FLAG=":";
}
