package com.rong.flora.july_29;

public class Search {

    public Integer biiSearch(Integer[] data, Integer begin, Integer end, Integer pattern){
        if (begin <= end){
            Integer mid = (end+begin)/2;
            if (pattern < data[mid]){
                return biiSearch(data, begin, (end+begin)/2-1,pattern );
            }else if (pattern > data[mid]){
                return biiSearch(data, (end+begin)/2 +1 , end, pattern);
            }else {
                return pattern;
            }
        }
        else {
            return null;
        }
    }

    public static void main(String...args){
        Search search = new Search();
        Integer[] arg = {1,2,3,4,5};
        System.out.println(search.biiSearch(arg,0, 4, 5));
    }
}
