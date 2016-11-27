package com.rong.flora.data_structure;

import java.util.LinkedList;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    public double[] bucketSort(double[] data){
        int length = data.length;
        List<Double>[] B = new List[length];

        for (int i= 0; i < length; i++ ){
            int index = (int)(length*data[i]);
            if( B[index] == null){
                B[index] = new LinkedList<>();
            }
            int j = B[index].size() - 1;
//            while (j >= 0 && B[index].get(j) > data[i]) {
//                j--;
//            }
//            B[index].add(j + 1, data[i]);

            for (; j >= 0 && B[index].get(j) > data[i]; j--);
            B[index].add(j + 1, data[i]);
        }

        int idx = 0;
        for (int k = 0; k < length; k++){
            if (B[k] != null) {
                for (int m = 0; m < B[k].size(); m++) {
                    data[idx++] = B[k].get(m);
                }
            }
        }
        return data;

    }
    public static void main(String... args){
        int[] data = {1,2,4,5,2,3};
        double[] data1 = {0.1, 0.05, 0.2, 0.5,0.9,0.8,0.5};
        Sort sort = new Sort();
        Sort sort1 = sort;
        Sort sort2 = new Sort();
        sort.bucketSort(data1);
        System.out.println(sort);
        System.out.println(sort1);
        System.out.println(sort2);
        sort.quickSort(data,0,data.length-1);
        for(double i : data1){
           System.out.println(i);
        }
    }

}
