package com.qunar.dubboexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : jiabin.niu
 **/
public class DemoServiceImpl implements DemoService {

    private final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

   /* //public String sayHello(String name) {
        return "Hello : " + name;
    }*/

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        return users;
    }
}
