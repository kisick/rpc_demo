package com.kisick.framework.protocol.http;

import com.kisick.framework.Invocation;
import com.kisick.framework.Invoker;
import com.kisick.framework.URL;


public class HttpInvoker implements Invoker {

    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        return new HttpClient().send(url.getHostname(), url.getPort(), invocation);
    }
}
