package com.rong.flora.test_case;

import com.rong.flora.logic.Coffee;
import com.rong.flora.logic.CoffeeConfig;
import com.rong.flora.rest_api.TestRestAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by rongwf1 on 2016/5/8.
 */
public class TestCoffee {
    CoffeeConfig coffeeConfig = new CoffeeConfig("Latte", 1 ,1);
    Coffee coffee = new Coffee(coffeeConfig, 30);
    @Test
    public void testGetPrice(){
        Assert.assertEquals(coffee.getPrice(), Integer.valueOf(30), "ok");
    }
}
