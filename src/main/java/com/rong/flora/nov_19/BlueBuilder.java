package com.rong.flora.nov_19;

import java.io.BufferedReader;

/**
 * Created by rongwf1 on 2016/11/19.
 */
public class BlueBuilder {
    private String name;
    private Integer age;


    public static class Builder{
        private String name;
        private Integer age;

        public Builder(){}
        public Builder(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        public Builder name(String name) throws Exception{
            Thread.sleep(100);
            this.name = name;
            return this;
        }

        public Builder age(Integer age) throws Exception{
            Thread.sleep(100);
            this.age = age;
            return this;
        }

        public BlueBuilder build() throws Exception{
            Thread.sleep(100);
            BlueBuilder blueBuilder = new BlueBuilder();
            blueBuilder.name = this.name;
            blueBuilder.age = this.age;
            return blueBuilder;
        }
    }

    public static void main(String... args) throws Exception{
        BlueBuilder blueBuilder = new BlueBuilder.Builder().age(10).name("oppo").build();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                while (true) {
                    System.out.println("blueBuilider = " + blueBuilder);
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
    }
}
