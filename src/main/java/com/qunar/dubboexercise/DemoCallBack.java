package com.qunar.dubboexercise;

import java.util.ArrayList;

/**
 * @author : jiabin.niu
 **/
public interface DemoCallBack {

    public ArrayList<User> onDemoCompleted();

    public void onError();


}
