package com.kisick.framework;


import com.kisick.framework.protocol.http.HttpProtocol;

public class ProtocolFactory {

    public static Protocol getProtocol(String protocol) {
        switch (protocol) {
            case "http":
                return new HttpProtocol();
            default:
                break;
        }
        return new HttpProtocol();
    }
}
