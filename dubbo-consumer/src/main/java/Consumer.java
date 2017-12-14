import com.dubbo.hcw.service.DemoService;
import com.dubbo.hcw.service.TestService;
import service.RemoteService;

/**
 * Copyright (C), 2017，jumore Tec.
 * Author: hechengwen
 * Version:
 * Date: 2017/12/12 14:48
 * Description:
 * Others:
 */
public class Consumer {

    public static void main(String[] args) {
        System.out.println("consumer start");
        TestService testService = RemoteService.getRemoteService(TestService.class);
        testService.test("消费者调用服务"+ testService.toString() +"的test方法");
        DemoService demoService = RemoteService.getRemoteService(DemoService.class);
        demoService.getPermissions("消费者调用服务"+ demoService.toString() +"的getPermissions方法");

    }

}
