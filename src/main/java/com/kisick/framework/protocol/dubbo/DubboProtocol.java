package com.kisick.framework.protocol.dubbo;

import com.kisick.framework.Invoker;
import com.kisick.framework.Protocol;
import com.kisick.framework.URL;


public class DubboProtocol implements Protocol {

    @Override
    public void export(URL url) {

    }

    @Override
    public Invoker refer(URL url) {
        return null;
    }
}
