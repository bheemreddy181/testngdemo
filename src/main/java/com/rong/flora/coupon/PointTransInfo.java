package com.rong.flora.coupon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 16/6/14.
 */
public class PointTransInfo {

    private User sender;
    private User receiver;
    private Integer point;
    private static List<PointTransInfo> pointTransInfos;

    static {
        pointTransInfos = new LinkedList<>();
    }

     public PointTransInfo(User sender, User receiver, Integer point) {
        this.receiver = receiver;
        this.point = point;
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public static List<PointTransInfo> getPointTransInfos() {
        return pointTransInfos;
    }

    public static void setPointTransInfos(List<PointTransInfo> pointTransInfos) {
        PointTransInfo.pointTransInfos = pointTransInfos;
    }

    @Override
    public String toString() {
        return "PointTransInfo{" +
                "point=" + point +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }

    public static void addTransInfo(User sender, User receiver, Integer point){

        PointTransInfo pointTransInfo = new PointTransInfo(sender, receiver, point);
        pointTransInfos.add(pointTransInfo);

    }


}
