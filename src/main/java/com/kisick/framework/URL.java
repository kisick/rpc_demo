package com.kisick.framework;


import java.io.Serializable;

public class URL implements Serializable {
    private String procotol;
    private String hostname;
    private Integer port;
    private String interfaceName;
    private Class implClass;

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public URL(String procotol, String hostname, Integer port) {
        this.procotol = procotol;
        this.hostname = hostname;
        this.port = port;
    }

    public URL(String procotol, String hostname, Integer port, String interfaceName, Class implClass) {
        this.procotol = procotol;
        this.hostname = hostname;
        this.port = port;
        this.interfaceName = interfaceName;
        this.implClass = implClass;
    }

    public String getProcotol() {
        return procotol;
    }

    public void setProcotol(String procotol) {
        this.procotol = procotol;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Class getImplClass() {
        return implClass;
    }

    public void setImplClass(Class implClass) {
        this.implClass = implClass;
    }
}
