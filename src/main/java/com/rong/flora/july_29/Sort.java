package com.rong.flora.july_29;

public class Sort {

    public Integer[] bubbleSort(Integer[] data){

        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length-1-i; j++) {
                if (data[j] > data[j+1]) {
                    Integer k = data[j];
                    data[j] = data[j+1];
                    data[j+1] = k;
                }
            }

        }
        return data;
    }

    public static void main(String... args){
        Sort sort = new Sort();
        Integer[] data = {3,1,2,4};
        sort.bubbleSort(data);
        for (Integer i:data){
            System.out.println(i);
        }
    }
}
