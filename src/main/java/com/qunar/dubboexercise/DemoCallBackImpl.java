package com.qunar.dubboexercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author : jiabin.niu
 **/
public class DemoCallBackImpl implements DemoCallBack {

    private final Logger logger = LoggerFactory.getLogger(DemoCallBackImpl.class);

    @Override
    public ArrayList<User> onDemoCompleted() {
        logger.info("call back completed");
        return new ArrayList<>();
    }

    @Override
    public void onError() {
        logger.error("DemoCallBackImpl error!");
    }
}
