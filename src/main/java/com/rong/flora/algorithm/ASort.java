package com.rong.flora.algorithm;

/**
 * Created by rongwf1 on 2016/10/31.
 */
public class ASort {

    public void quickSort(Integer low, Integer high, Integer[] array){
        if (low < high){
            Integer index = sort(low, high, array);
            quickSort(low, index-1, array);
            quickSort(index+1, high, array);
        }
    }

    public Integer sort(Integer low, Integer high, Integer[] array){
        Integer j = low;
        Integer i = low - 1;
        for (;j < high; j++){
            if (array[j] <= array[high]){
                i++;
                Integer temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Integer temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
        return i+1;
    }

    public static void main(String... args){
        Integer[] array = {1,2,4,2,5,3};
        ASort aSort = new ASort();
        aSort.quickSort(0, 5, array);
        for (int i: array ){
            System.out.print(i);
        }
    }
}
