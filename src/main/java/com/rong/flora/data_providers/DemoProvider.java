package com.rong.flora.data_providers;

import com.rong.flora.model.RackInfo;
import org.testng.annotations.DataProvider;

/**
 * Created by rongwf1 on 2016/4/17.
 */
public class DemoProvider {
    @DataProvider(name = "demo")
    public Object[][] createData() {
        return new Object[][] {
                {"10.240.198.103", ""},
        };
    }

    @DataProvider(name = "rackinfo")
    public Object[][] createRackInfo() {
        return new Object[][] {
                {new RackInfo("192.168.0.1", "windows", "lenovo", true, "255.255.255.0", "192.160.0.1", "", "", 1500, "local disk" )}
        };
    }
}


