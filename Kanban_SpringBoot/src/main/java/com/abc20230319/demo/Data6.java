package com.abc20230319.demo;

public class Data6 {
    private int[] arr;

    Data6(){
        arr = new int[5];
    }

    public void setData(int num1,int num2,int num3,int num4,int num5){
        this.arr[0] = num1;
        this.arr[1] = num2;
        this.arr[2] = num3;
        this.arr[3] = num4;
        this.arr[4] = num5;
    }

    public int[] getData(){
        return arr;
    }
}
