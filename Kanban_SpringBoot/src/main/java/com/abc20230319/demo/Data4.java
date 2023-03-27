package com.abc20230319.demo;

public class Data4 {
    private int[] arr;

    Data4(){
        arr = new int[7];
    }

    public void setData(int num1,int num2,int num3,int num4,int num5,int num6,int num7){
        this.arr[0] = num1;
        this.arr[1] = num2;
        this.arr[2] = num3;
        this.arr[3] = num4;
        this.arr[4] = num5;
        this.arr[5] = num6;
        this.arr[6] = num7;
    }

    public int[] getData(){
        return arr;
    }
}
