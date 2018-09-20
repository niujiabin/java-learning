import com.alibaba.dubbo.rpc.RpcContext;
import com.qunar.dubboexercise.DemoService;
import com.qunar.dubboexercise.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author : jiabin.niu
 **/


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations = {"classpath:applicationContext-consumer.xml",
        "classpath:applicationContext-provider.xml"}) //加载配置文件
public class DuuboDemoTest {

    private final Logger logger = LoggerFactory.getLogger(DuuboDemoTest.class);

    @Resource(name = "demoServiceRef")
    private DemoService demoService;

    /**
     * 普通Dubbo测试
     */
    @Test
    public void dubboTest() {
        String hello = demoService.sayHello("tom");
        logger.info(hello);
    }

    /**
     * 异步dubbo测试
     */
    @Test
    public void asynDubboTest() {
        try {
            List<User> userList = demoService.getUsers();
            logger.info("userList立即返回值：{}", userList.size());
            //获得Future
            Future<List<User>> future = RpcContext.getContext().getFuture();
            userList = future.get();
            logger.info("异步调用后的返回值：{}", userList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
