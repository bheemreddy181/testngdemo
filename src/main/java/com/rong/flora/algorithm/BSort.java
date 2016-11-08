package com.rong.flora.algorithm;

/**
 * Created by rongwf1 on 2016/11/7.
 */
public class BSort {
    public void quickSort(Integer[] data, Integer low, Integer high){
        if (low < high){
            Integer index = part(data, low, high);
            quickSort(data, low, index-1);
            quickSort(data, index+1, high);
        }
    }

    public Integer part(Integer[] data, Integer low, Integer high){
        Integer j = low;
        Integer i = low -1;
        for (;j < high; j++){
            System.out.println("j =" + j);
            if (data[j] <= data[high]){
                i++;
                if (i !=j){
                    data[i] ^= data[j];
                    data[j] ^= data[i];
                    data[i] ^= data[j];
                }
//                Integer tmp = data[i];
//                data[i] = data[j];
//                data[j] = tmp;
                System.out.println("data[i]= " +data[i]);
                System.out.println("data[j]= " +data[j]);
            }
        }
        data[i+1] ^= data[high];
        data[high] ^= data[i+1];
        data[i+1] ^= data[high];
//        Integer tmp = data[i+1];
//        data[i+1] = data[high];
//        data[high] = tmp;
        return i+1;
    }

    public static void main(String... args){
        Integer[] data ={1,2,4,2,5,3};
        BSort bSort = new BSort();
        bSort.quickSort(data,0,5);
        for (Integer k: data){
            System.out.print(k);
        }
        Integer a = 1;
        Integer b = 2;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a= "+ a);
        System.out.println("b= "+ b);
    }
}
