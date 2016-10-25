package com.rong.flora.data_structure;

/**
 * Created by rong 16/10/18.
 */
public class Sort {

    public void quickSort(int[] data, int low, int high){

        if (low < high) {
            int p = partition(data, low, high);
            quickSort(data, low, p - 1);
            quickSort(data, p + 1, high);
        }
    }

    public int partition(int[] data, int low, int high){
        int j = low;
        int i = low - 1;
        for(; j < high; j++){
            if (data[j] <= data[high]){
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
        int[] data = {1,2,4,5,2,3};
        Sort sort = new Sort();
        Sort sort1 = sort;
        Sort sort2 = new Sort();
        System.out.println(sort);
        System.out.println(sort1);
        System.out.println(sort2);
        sort.quickSort(data,0,data.length-1);
        for(int i : data){
           System.out.println(i);
        }
    }

}
