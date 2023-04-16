package com.kisick.provider.impl;

import com.kisick.common.api.HelloService;


public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}
