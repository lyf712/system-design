package org.example.isolation;

import com.netflix.hystrix.HystrixCommand;

/**
 * @author liyunfei
 **/
public class HystrixDemoServiceCommand extends HystrixCommand<HystrixDemoService> {

    private HystrixDemoService hystrixDemoService;

    protected HystrixDemoServiceCommand(Setter setter) {
        //setter.andCommandKey()
        super(setter);
    }

//    private Setter setter(){
//        //Setter setter = new Setter();
//    }

    @Override
    protected HystrixDemoService run() throws Exception {
        return hystrixDemoService;
    }
}
