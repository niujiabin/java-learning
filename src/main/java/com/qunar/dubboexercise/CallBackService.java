package com.qunar.dubboexercise;

/**
 * @Author:jiabin.niu
 * @Date:2018/9/21 02 21
 * @Description:
 */
public interface CallBackService {

    void addListener(String key, CallBackListener listener);
}
