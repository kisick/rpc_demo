package com.kisick.provider;

import com.kisick.common.api.HelloService;
import com.kisick.framework.Protocol;
import com.kisick.framework.ProtocolFactory;
import com.kisick.framework.URL;
import com.kisick.provider.impl.HelloServiceImpl;


public class Provider {
    public static void main(String[] args) {

        URL url = new URL("http", "localhost", 8080, HelloService.class.getName(), HelloServiceImpl.class);

        Protocol protocol = ProtocolFactory.getProtocol(url.getProcotol());
        protocol.export(url);

    }
}
