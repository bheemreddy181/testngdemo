package com.rong.test.model;

/**
 * Created by rongwf1 on 2016/4/17.
 */

public class RackInfo {
    private String deployNodeIp;
    private String deployNodeOS;
    private String hostName;
    private Boolean macSelected;
    private String subMask;
    private String gateWay;
    private String dns1;
    private String dns2;
    private Integer mtu;
    private String storage;

    public RackInfo(String deployNodeIp, String deployNodeOS, String hostName, Boolean macSelected, String subMask, String gateWay, String dns1, String dns2, Integer mtu, String storage) {
        this.deployNodeIp = deployNodeIp;
        this.deployNodeOS = deployNodeOS;
        this.hostName = hostName;
        this.macSelected = macSelected;
        this.subMask = subMask;
        this.gateWay = gateWay;
        this.dns1 = dns1;
        this.dns2 = dns2;
        this.mtu = mtu;
        this.storage = storage;
    }

    public String getDeployNodeIp() {
        return deployNodeIp;
    }

    public void setDeployNodeIp(String deployNodeIp) {
        this.deployNodeIp = deployNodeIp;
    }

    public String getDeployNodeOS() {
        return deployNodeOS;
    }

    public void setDeployNodeOS(String deployNodeOS) {
        this.deployNodeOS = deployNodeOS;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Boolean getMacSelected() {
        return macSelected;
    }

    public void setMacSelected(Boolean macSelected) {
        this.macSelected = macSelected;
    }

    public String getSubMask() {
        return subMask;
    }

    public void setSubMask(String subMask) {
        this.subMask = subMask;
    }

    public String getGateWay() {
        return gateWay;
    }

    public void setGateWay(String gateWay) {
        this.gateWay = gateWay;
    }

    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }

    public Integer getMtu() {
        return mtu;
    }

    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
