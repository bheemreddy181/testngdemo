package com.rong.flora.test_case;

import com.rong.flora.animal.Cat;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

/**
 * Created by rongwf1 on 2016/6/18.
 */
public class TestCat {
   @Test
    public void testCat(){

        Cat cat = new Cat("ears", "eyes", "legs", "mouse", "miao", "ive");
       List<Cat> catList = cat.produceCat(3);
       Assert.assertEquals(catList.size(),3, "ok");
    }

}