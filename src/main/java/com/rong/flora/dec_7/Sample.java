package com.rong.flora.dec_7;

/**
 * Created by rongwf1 on 2016/12/18.
 */
public class Sample {

    public void function(SampleInerface si){
        if (si != null){
            si.method("hi");
        }
    }

    public class InnerSample{
        private int a = 0;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }

    public static void main(String... args){
        Sample sample = new Sample();
        Sample sample1 = new Sample();
        sample.function(new SampleInterfaceImpl());
        Sample.InnerSample innerSample = sample.new InnerSample();
        Sample.InnerSample innerSample1 = sample1.new InnerSample();
        System.out.println("sample "+ innerSample.getA());
        innerSample1.setA(10);
        System.out.println("sample1 " + innerSample1.getA());

        sample.function(new SampleInerface() {
            @Override
            public void method(String a) {
                System.out.println(a);
            }
        });

        sample.function(a ->System.out.println(a));
        sample.function(System.out::println);
    }

}

class SampleInterfaceImpl implements SampleInerface {

    @Override
    public void method(String a) {
        System.out.println(a);
    }
}
