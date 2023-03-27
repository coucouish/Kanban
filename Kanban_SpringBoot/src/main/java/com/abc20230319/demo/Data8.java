package com.abc20230319.demo;

public class Data8 {
    private Obj obj1;
    private Obj obj2;
    private Obj obj3;

    Data8(){
        obj1 = new Obj();
        obj2 = new Obj();
        obj3 = new Obj();
    }
    public void setObj1(int value){
        obj1.setName("市级");
        obj1.setValue(value);
    }
    public void setObj2(int value){
        obj2.setName("省级");
        obj2.setValue(value);
    }
    public void setObj3(int value){
        obj3.setName("国家级");
        obj3.setValue(value);
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
}
