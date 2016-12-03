package com.rong.flora.practice;

/**
 * Created by rong on 2016/11/29.
 */
public class BitOperation {
    private static final int MAX = 32;
    /**
     * flag identifies the appearance of protocol fields.
     * bit 31 ~ bit 8 are reserved.
     * bit 7 ~ bit 6 identifies protocol status
     * 00 - CLOSED
     * 01 - STARTING
     * 10 - RUNNING
     * 11 - CLOSING
     *
     * bit 5 - identifies client/server
     * 0 - client; 1 - server
     *
     * bit 4 ~ bit 1 identifies message types
     * bit 4 - video
     * bit 3 - audio
     * bit 2 - img
     * bit 1 - txt
     *
     * bit 0 - identifies charging status
     * 0 - free
     * 1 - charging
     */
    private static final int flag = 0;

    public int[] filterMissingNumbers(int[] data){
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

    public static void main(String... args){
        int[] data = {1,2,2,3};
        BitOperation bitOperation = new BitOperation();
        for (int i : bitOperation.filterMissingNumbers(data)){
            System.out.println(i);
        }

    }
}
