package com.rong.flora.practice;

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
    BROKEN(4),
    UNKNOWN(5);

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

