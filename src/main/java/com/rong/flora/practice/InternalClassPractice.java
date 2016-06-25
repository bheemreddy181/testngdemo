package com.rong.flora.practice;

/**
 * Created by lafengnan on 16/6/22.
 */
public class InternalClassPractice {

    private Integer idx;
    private String name;
    private Integer size;

    private InternalClassPractice(Integer idx) {
        this.idx = idx;
    }

    public static class Builder {

        private Integer idx;
        private String name;
        private Integer size;

        public Builder(Integer idx) {
            this.idx = idx;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSize(Integer size) {
            this.size = size;
            return this;
        }

        public InternalClassPractice build(){
            InternalClassPractice internalClassPractice = new InternalClassPractice(this.idx);
            return internalClassPractice;
        }
    }

    public static void main(String[] args) {

        InternalClassPractice ob = new Builder(1).setName("anan").setSize(1).build();
        InternalClassPractice ob2 = new Builder(1).setSize(1).build();
    }
}
