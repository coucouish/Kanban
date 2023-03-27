package com.abc20230319.demo;

import java.util.HashMap;

public class Data5 {

    private Obj obj1;
    private Obj obj2;
    private Obj obj3;
    private Obj obj4;

    Data5(){
        obj1 = new Obj();
        obj2 = new Obj();
        obj3 = new Obj();
        obj4 = new Obj();
    }
    public void setObj1(int value){
        obj1.setName("升学");
        obj1.setValue(value);
    }
    public void setObj2(int value){
        obj2.setName("单位就业");
        obj2.setValue(value);
    }
    public void setObj3(int value){
        obj3.setName("创业");
        obj3.setValue(value);
    }
    public void setObj4(int value){
        obj4.setName("自由职业");
        obj4.setValue(value);
    }

    public Obj getObj1() {
        return obj1;
    }

    public Obj getObj2() {
        return obj2;
    }

    public Obj getObj3() {
        return obj3;
    }

    public Obj getObj4() {
        return obj4;
    }
}
