package com.rong.flora.practice;

/**
 * Created by rongwf1 on 2016/10/19.
 */
public class Sort {

    public void quickSort(int[] data, int low, int high){
        if (low<high){
        int index = part(data, low, high);
        quickSort(data,low, index-1);
        quickSort(data, index+1, high);}

    }

    public int part(int[] data, int low, int high){
        int j = low;
        int i = low - 1;
        for(; j < high; j++){
            if (data[j] < data[high]) {
                i++;
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }

        }
        int tmp = data[i+1];
        data[i+1] = data[high];
        data[high] = tmp;
        return i+1;
    }

    public static void main(String... args){
        Sort sort = new Sort();
        int[] data ={1,2,4,2,5,3};
        sort.quickSort(data,0,data.length-1);
        for(int i : data){
            System.out.println(i);
        }
    }
}
