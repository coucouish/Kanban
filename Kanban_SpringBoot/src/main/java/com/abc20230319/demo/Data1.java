package com.abc20230319.demo;

public class Data1 {
    private int[] arr;

    Data1(){
        arr = new int[2];
    }

    public void setData(int num1,int num2){
        this.arr[0] = num1;
        this.arr[1] = num2;
    }

    public int[] getData(){
        return arr;
    }
}
