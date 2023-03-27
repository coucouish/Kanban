package com.abc20230319.demo;

public class Data2 {
    private int[] arr;
    Data2(){
        arr = new int[4];
    }
    public void setData(int num1,int num2,int num3,int num4){
        this.arr[0] = num1;
        this.arr[1] = num2;
        this.arr[2] = num3;
        this.arr[3] = num4;
    }

    public int[] getData(){
        return arr;
    }
}
