package com.rong.flora.practice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lafengnan on 16/7/12.
 */
public enum CaseStatus {
    STOPPED(0),
    RUNNING(1),
    SUCCESS(2),
    FAIL(3),
    UNKNOWN(-1);

    private Integer value;

    private static Map<Integer, CaseStatus> map;

    static {
        map = new HashMap<>();
        for(CaseStatus caseStatus : CaseStatus.values()){
            map.put(caseStatus.value, caseStatus);
        }
    }

    public Integer getValue() {
        return value;
    }

    public static CaseStatus valueOf(Integer value){
        return map.getOrDefault(value, UNKNOWN);

    }

    private CaseStatus(Integer value){
        this.value = value;
    }
}

class Ants{
    public static final Ants SUCCESS ;
    public static final Ants FAILED;

    private Integer value;

    private Ants(Integer value){
        this.value = value;
    }

    private static Map<Integer, Ants> map = new HashMap<>();

       static {
        SUCCESS = new Ants(0);
        FAILED = new Ants(1);

        map.put(SUCCESS.value, SUCCESS);
        map.put(FAILED.value, FAILED);
    }

    public Integer getValue() {
        return value;
    }

    public Ants valueof(Integer value) {
        return map.getOrDefault(value, SUCCESS);

    }
}
