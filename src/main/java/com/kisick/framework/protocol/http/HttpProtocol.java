package com.kisick.framework.protocol.http;

import com.kisick.framework.Invoker;
import com.kisick.framework.Protocol;
import com.kisick.framework.URL;
import com.kisick.framework.register.LocalRegister;
import com.kisick.framework.register.RemoteMapRegister;


public class HttpProtocol implements Protocol {

    @Override
    public void export(URL url) {
        LocalRegister.register(url.getInterfaceName(), url.getImplClass());
        RemoteMapRegister.register(url.getInterfaceName(), url);
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }
}
