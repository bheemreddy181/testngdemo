package com.rong.flora.dec_7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2016/12/10.
 */
public enum UploadStatus {
    NOT_START(0), IN_PROGRESS(1), COMPLETE(2), UNDEFINED(-1);

    Integer value;
    static Map<Integer, UploadStatus> valueMap = new HashMap<>();
    static {
        for (UploadStatus u: UploadStatus.values()){
            valueMap.put(u.getValue(), u);
        }
    }
    private UploadStatus(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }

    public static UploadStatus valueOf(Integer value){
        return valueMap.getOrDefault(value,UNDEFINED);
    }
}
