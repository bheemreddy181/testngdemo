package com.rong.flora.test_case;
import org.testng.Assert;

import com.rong.flora.logic.Coffee;
import com.rong.flora.logic.CoffeeConfig;
import org.testng.annotations.Test;

/**
 * Created by rongwf1 on 2016/5/8.
 */
public class TestCoffeeConfig {

    CoffeeConfig coffeeConfig = new CoffeeConfig("latte", 1, 2);

    @Test
    public void testGetName() {
        Assert.assertEquals(coffeeConfig.getName(), "latte", "ok");
    }

}

