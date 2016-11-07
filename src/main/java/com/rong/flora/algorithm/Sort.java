package com.rong.flora.algorithm;

/**
 * Created by rongwf1 on 2016/10/30.
 */
public class Sort {

    public Integer[] quickSort(Integer low, Integer high, Integer[]op){
        if (low < high){
            Integer k = part(low, high, op);
            quickSort(low, k-1, op);
            quickSort(k+1, high, op);
        }
        return op;
    }

    public Integer part(Integer low, Integer high, Integer[] op){
        Integer j = low;
        Integer i = low -1;
        for (;j < high; j++){
            System.out.println("j = " + j);
            if (op[j] <= op[high]){
                i++;
                if (i != j){
                    op[i] ^= op[j];
                    op[j] ^= op[i];
                    op[i] ^= op[j];
                }
            }
        }
        Integer tem = op[high];
        op[high] = op[i+1];
        op[i+1] = tem;
        return i+1;
    }

    public static void main(String... args){
        Integer[] op = {1,2,4,2,5,3};
        Sort sort = new Sort();
        sort.quickSort(0,5,op);
        for (int i = 0; i < 6; i++){
            System.out.print(op[i]);
        }
    }
}
