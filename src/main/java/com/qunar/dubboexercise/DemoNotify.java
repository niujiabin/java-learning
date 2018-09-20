package com.qunar.dubboexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author:jiabin.niu
 * @Date:2018/9/21 02 06
 * @Description:
 */
public class DemoNotify {

    private static final Logger logger = LoggerFactory.getLogger(DemoNotify.class);

    public void onInvoke(){
        logger.info("execute invoke");
    }


    public void onReturn(List<User> userList){
        System.out.println("kkkkk");
        logger.info("execute return");
    }

    public void onThrow(Throwable throwable){
        logger.error("execute error");
    }
}
