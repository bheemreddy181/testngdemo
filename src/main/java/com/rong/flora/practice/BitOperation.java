package com.rong.flora.practice;

/**
 * Created by rong on 2016/11/29.
 */
public class BitOperation {
    private static final int MAX = 10;

    public int[] bitArray(int[] data){
        int[] data1 = new int[MAX + 1];
        int flag = 0;
        for (int i : data){
            flag |=(1<<i);
        }
        int idx = 0;
        for (int i = 0; i < 32; i++){
            if ((flag&(1<<i)) == 0){
                data1[idx++] = i;
            }
        }

        return data1;
    }
}
