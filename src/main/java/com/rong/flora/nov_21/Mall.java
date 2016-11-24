package com.rong.flora.nov_21;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rong on 2016/11/22.
 */
public class Mall {
    private static final Logger logger = Logger.getLogger(Mall.class);
    private String name;
    private String address;
    private String level;
    private Integer capacity;
    private Integer left;
    private List<Store>  storeList = new LinkedList<>();

    public Mall(String name, String address, String level, Integer capacity){
        this.name = name;
        this.address = address;
        this.level = level;
        this.capacity = capacity;
        this.left = capacity;
        for (int i = 0; i < capacity; i++) storeList.add(new Store());
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }

    private static class Store {
        private double size;
        private double rentPerSize;
        private Integer floor;
        private Integer no;
        private String owner;
        private double begin;
        private double end;
        private double leaseTerm;
        private Map<Object, Object> optional;

        public void setSize(double size) {
            this.size = size;
        }

        public void setRentPerSize(double rentPerSize) {
            this.rentPerSize = rentPerSize;
        }

        public void setFloor(Integer floor) {
            this.floor = floor;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public void setBegin(double begin) {
            this.begin = begin;
        }

        public void setEnd(double end) {
            this.end = end;
        }

        public void setLeaseTerm(double leaseTerm) {
            this.leaseTerm = leaseTerm;
        }

        public void setOptional(Map<Object, Object> optional) {
            this.optional = optional;
        }

        public double getSize() {
            return size;
        }

        public double getRentPerSize() {
            return rentPerSize;
        }

        public Integer getFloor() {
            return floor;
        }

        public Integer getNo() {
            return no;
        }

        public String getOwner() {
            return owner;
        }

        public double getBegin() {
            return begin;
        }

        public double getEnd() {
            return end;
        }

        public double getLeaseTerm() {
            return leaseTerm;
        }

        public Map<Object, Object> getOptional() {
            return optional;
        }

        private Store(){
            begin = RandomUtils.nextDouble(1.0, 3.0);
            end = RandomUtils.nextDouble(4.0, 5.0);
        }
        private Store(Integer floor, Integer no, double size) {
            this.floor = floor;
            this.no = no;
            this.size = size;
        }

        static class Builder{
            private double size;
            private double rentPerSize;
            private Integer floor;
            private Integer no;
            private String owner;
            private double leaseTerm;
            private double begin;
            private double end;
            private Map<Object, Object> optional;

            public Builder(Integer floor, Integer no, double size){
                this.floor = floor;
                this.no = no;
                this.size = size;
            }

            public Builder size( double size){
                this.size = size;
                return this;
            }

            public Builder rentPerSize(double rentPerSize){
                this.rentPerSize = rentPerSize;
                return this;
            }

            public Builder floor(Integer floor){
                this.floor = floor;
                return this;
            }

            public Builder no(Integer no){
                this.no = no;
                return this;
            }

            public Builder owner(String owner){
                this.owner = owner;
                return this;
            }

            public Builder leaseTerm(double leaseTerm){
                this.leaseTerm = leaseTerm;
                return this;
            }

            public Builder begin(double begin){
                this.begin = begin;
                return this;
            }
            public Builder end(double end){
                this.end = end;
                return this;
            }

            public Store build(){
                Store store = new Store(this.floor, this.no, this.size);
                store.end = this.end;
                store.begin = this.begin;
                store.leaseTerm = this.leaseTerm;
                store.owner = this.owner;
                store.rentPerSize = this.rentPerSize;
                return store;
            }
        }
    }

    public synchronized Boolean rent(Integer floor, Integer no, String owner, double size, double rentPerSize,
                        double begin, double end){
        Boolean flag = true;
        if (left <= 0){
            flag = false;
            logger.debug("no left store");

        } else {
            Store store = storeList.get(RandomUtils.nextInt(0, capacity));
            if ((store.getOwner() == null)||(store.getBegin() > begin)){
                store.setFloor(floor);
                store.setNo(no);
                store.setBegin(begin);
                store.setOwner(owner);
                store.setSize(size);
                store.setEnd(end);
                store.setRentPerSize(rentPerSize);
                left--;
            } else {
                flag = false;
                logger.debug("this store is already rent " + store.toString());
            }
        }
        return flag;
    }

    public static void main(String... args) {
        final int LOOP = 200;
        Mall mall = new Mall("八佰伴", "张杨路100号", "中等", 100);
        for (int i = 0; i < LOOP; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    logger.info(mall.rent(
                            RandomUtils.nextInt(1, 10),
                            RandomUtils.nextInt(0, 10),
                            "" + RandomUtils.nextInt(1,3),
                            RandomUtils.nextDouble(50.0, 100),
                            RandomUtils.nextDouble(1.0, 10.0),
                            RandomUtils.nextDouble(1.0, 5.0),
                            RandomUtils.nextDouble(6.0, 10.0)));
                }
            };
            new Thread(runnable).start();
        }

        logger.info("left: " + mall.left);
    }
}
