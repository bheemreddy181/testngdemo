package com.rong.flora.june_04;

/**
 * Created by rongwf1 on 2017/6/4.
 */
public class Sort {
    public int[] quickSort(int low, int high, int... args){
        if (low < high){
            int k = part(low, high, args);
            quickSort(low, k-1, args);
            quickSort(k+1, high, args);
        }
        return args;
    }

    public int part(int low, int high, int[] array){
        int x = array[high];
        int i = low - 1;
        int j = low;
        for(; j < high; j++) {
            if (array[j] <= x){
                i++;
                int tmp = array[i];
                array[i]= array[j];
                array[j] = tmp;
            }
        }
        int tmp = array[i+1];
        array[i+1] = x;
        array[high] = tmp;
        return i+1;
    }

    public static void main(String... args){
        int[] data = {1,6,4,7,9,0};
        Sort sort = new Sort();
        sort.quickSort(0, data.length-1, data);
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }
}
