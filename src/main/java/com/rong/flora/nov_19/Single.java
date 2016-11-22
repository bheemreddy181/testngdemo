package com.rong.flora.nov_19;

/**
 * Created by rongwf1 on 2016/11/19.
 */
public enum Single {
    inst;

    @Override
    public String toString(){
        return "" + hashCode();
    }
    public static Single getInst(){
        return inst;
    }
}
