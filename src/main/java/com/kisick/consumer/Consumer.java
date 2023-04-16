package com.kisick.consumer;

import com.kisick.common.api.HelloService;
import com.kisick.framework.ProxyFactory;


public class Consumer {
    public static void main(String[] args) {

        HelloService helloServiceProxy = ProxyFactory.getProxy(HelloService.class);
        String result = helloServiceProxy.sayHello("kisick");
        System.out.println(result);

    }
}
