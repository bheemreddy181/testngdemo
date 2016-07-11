package com.rong.flora.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flora on 16/7/11.
 */
public enum Gender {
    FEMALE(0), MALE(1), UNKNOWN(-1);

    private Integer value;
    private static Map<Integer, Gender> map;
    static {
        map = new HashMap<>();
        for (Gender gender: Gender.values()) {
            map.put(gender.value, gender);
        }
    }
    private Gender(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public static Gender valueOf(Integer value) {
        return map.getOrDefault(value, UNKNOWN);
    }

}
