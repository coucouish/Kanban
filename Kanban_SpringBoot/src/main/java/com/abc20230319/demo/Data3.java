package com.abc20230319.demo;

public class Data3 {
    private int[] arr;

    Data3(){
        arr = new int[1];
    }

    public void setData(int num1){
        this.arr[0] = num1;
    }

    public int[] getData(){
        return arr;
    }
}
