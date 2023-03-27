package com.abc20230319.demo;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONObject;

import java.util.List;

@RestController
@CrossOrigin
public class HelloController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String abc(){
        return "Hello world!";
    }

    @GetMapping("/data1")
    public String getData1(){
        Data1 data1 = new Data1();
        int randomNum1 = (int)Math.floor(Math.random() * 1500) + 1500;
        int randomNum2 = (int)Math.floor(Math.random() * 1500) + 1500;
        data1.setData(randomNum1,randomNum2);
        String json = JSON.toJSONString(data1);
        return json;
    }

    @GetMapping("/data2")
    public String getData2(){
        Data2 data2 = new Data2();
        int randomNum1 = (int)Math.floor(Math.random() * 1000) + 1000;
        int randomNum2 = (int)Math.floor(Math.random() * 1000) + 1000;
        int randomNum3 = (int)Math.floor(Math.random() * 1000) + 1000;
        int randomNum4 = (int)Math.floor(Math.random() * 1000) + 1000;
        data2.setData(randomNum1,randomNum2,randomNum3,randomNum4);
        String json = JSON.toJSONString(data2);
        return json;
    }

    @GetMapping("/data3")
    public String getData3(){
        Data3 data3 = new Data3();
        int randomNum = (int)Math.floor(Math.random() * 45);
        data3.setData(randomNum);
        String json = JSON.toJSONString(data3);
        return json;
    }

    @GetMapping("/data4")
    public String getData4(){
        Data4 data4 = new Data4();
        int randomNum1 = (int)Math.floor(Math.random() * 1500);
        int randomNum2 = (int)Math.floor(Math.random() * 1500);
        int randomNum3 = (int)Math.floor(Math.random() * 1500);
        int randomNum4 = (int)Math.floor(Math.random() * 1500);
        int randomNum5 = (int)Math.floor(Math.random() * 1500);
        int randomNum6 = (int)Math.floor(Math.random() * 1500);
        int randomNum7 = (int)Math.floor(Math.random() * 1500);

        data4.setData(randomNum1,randomNum2,randomNum3,randomNum4,randomNum5,randomNum6,randomNum7);
        String json = JSON.toJSONString(data4);
        return json;
    }

    @GetMapping("/data5")
    public String getData5(){
        Data5 data5 = new Data5();
        int randomNum1 = (int)Math.floor(Math.random() * 1800) + 200;
        int randomNum2 = (int)Math.floor(Math.random() * 1800) + 200;
        int randomNum3 = (int)Math.floor(Math.random() * 1800) + 200;
        int randomNum4 = (int)Math.floor(Math.random() * 1800) + 200;

        data5.setObj1(randomNum1);
        data5.setObj2(randomNum2);
        data5.setObj3(randomNum3);
        data5.setObj4(randomNum4);
        String json = JSON.toJSONString(data5);
        return json;
    }

    @GetMapping("/data6")
    public String getData6(){
        Data6 data6 = new Data6();
        int randomNum1 = (int)Math.floor(Math.random() * 2700) + 300;
        int randomNum2 = (int)Math.floor(Math.random() * 2700) + 300;
        int randomNum3 = (int)Math.floor(Math.random() * 2700) + 300;
        int randomNum4 = (int)Math.floor(Math.random() * 2700) + 300;
        int randomNum5 = (int)Math.floor(Math.random() * 2700) + 300;
        data6.setData(randomNum1,randomNum2,randomNum3,randomNum4,randomNum5);
        String json = JSON.toJSONString(data6);
        return json;
    }

    @GetMapping("/data7")
    public String getData7(){
        Data7 data7 = new Data7();
        int randomNum1 = (int)Math.floor(Math.random() * 80) + 20;
        int randomNum2 = (int)Math.floor(Math.random() * 80) + 20;
        int randomNum3 = (int)Math.floor(Math.random() * 80) + 20;
        int randomNum4 = (int)Math.floor(Math.random() * 80) + 20;
        data7.setData(randomNum1,randomNum2,randomNum3,randomNum4);
        String json = JSON.toJSONString(data7);
        return json;
    }

    @GetMapping("/data8")
    public String getData8(){
        Data8 data8 = new Data8();
        int randomNum1 = (int)Math.floor(Math.random() * 40) + 60;
        int randomNum2 = (int)Math.floor(Math.random() * 30) + 30;
        int randomNum3 = (int)Math.floor(Math.random() * 29) + 1;

        data8.setObj1(randomNum1);
        data8.setObj2(randomNum2);
        data8.setObj3(randomNum3);
        String json = JSON.toJSONString(data8);
        return json;
    }

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(20);
        return person;
    }

    @GetMapping("getData1")
    public List<User> findAll() {
        return userDao.findAll();
    }
    @GetMapping("getUsersByName")
    public List<User> getUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }
}
