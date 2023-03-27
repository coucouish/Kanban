package com.abc20230319.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
