// IMyAidlInterface.aidl
package com.dkjc.jiangchao.serviceapp;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    //修改字符串data数据
    void setData(String str);
}
