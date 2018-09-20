package com.qunar.dubboexercise;

import com.alibaba.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author:jiabin.niu
 * @Date:2018/9/21 01 56
 * @Description:
 */
public class MainConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MainConsumer.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext-consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoServiceRef");
        try {
            List<User> userList = demoService.getUsers();
            logger.info("userList立即返回值：{}", userList);
            //获得Future
            Future<List<User>> future = RpcContext.getContext().getFuture();
            userList = future.get();
            logger.info("异步调用后的返回值：{}", userList);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CallBackService callbackService = (CallBackService) context.getBean("callbackService");
        callbackService.addListener("foo.bar", new CallBackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });

    }
}
