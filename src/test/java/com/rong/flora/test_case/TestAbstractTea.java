package com.rong.flora.test_case;

import com.rong.flora.friday.AbstractTea;
import com.rong.flora.friday.FinalTea;
import com.rong.flora.friday.GreenTea;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lafengnan on 16/5/23.
 */
public class TestAbstractTea {
    AbstractTea abstractTea = new GreenTea();
    FinalTea finalTea = new FinalTea();

    @Test
    public void testAbstractTea(){
        abstractTea.setName("Mccafe");
        System.out.println(abstractTea.getName());
        Assert.assertEquals(abstractTea.getName(),"Mccafe", "ok" );
    }


    @Test
    public void testFinalTea(){
        finalTea.setName("finalTea");
        System.out.println(finalTea.getName());
        Assert.assertEquals(finalTea.getName(), "finalTea", "ok");
    }
}