package com.kisick.framework;

import com.kisick.framework.register.RemoteMapRegister;

import java.util.ArrayList;
import java.util.List;


public class ClusterInvoker implements Invoker {

    private List<Invoker> invokers = new ArrayList<>();

    public void addInvoker(Invoker invoker) {
        invokers.add(invoker);
    }

    public static Invoker join(Class interfaceClass) {
        ClusterInvoker clusterInvoker = new ClusterInvoker();
        // 从注册中心获取URLs
        List<URL> urls = RemoteMapRegister.get(interfaceClass.getName());
        urls.forEach(url -> {
            Protocol protocol = ProtocolFactory.getProtocol(url.getProcotol());
            Invoker invoker = protocol.refer(url);
            clusterInvoker.addInvoker(invoker);
        });
        return clusterInvoker;
    }

    @Override
    public String invoke(Invocation invocation) {
        Invoker invoker = LoadBalance.random(invokers);
        return invoker.invoke(invocation);
    }
}
