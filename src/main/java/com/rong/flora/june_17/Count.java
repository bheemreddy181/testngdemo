package com.rong.flora.june_17;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongwf1 on 2017/7/1.
 */
public class Count {

    public void acount(int... data){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            Integer cnt = map.get(data[i]);
            cnt = map.getOrDefault(data[i], 0);
            map.put(data[i], cnt+1);

            if (cnt == null){
                map.put(data[i], 1);
            }else {
                map.put(data[i], cnt+1);
            }

        }
    }


}
