package com.qunar.dubboexercise;

import java.util.List;

/**
 * @author : jiabin.niu
 **/
public interface DemoService {

   /* *//**
     * 打招呼
     * @param name
     * @return
     *//*
    public String sayHello(String name);*/

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> getUsers();

}
