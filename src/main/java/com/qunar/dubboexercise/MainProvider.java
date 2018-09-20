package com.qunar.dubboexercise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:jiabin.niu
 * @Date:2018/9/21 01 55
 * @Description:
 */
public class MainProvider {

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-provider.xml");
        context.start();
        Thread.sleep(2000000L);


    }
}
