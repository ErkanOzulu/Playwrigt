package com.mycomp.tests.pac_07_using_singleton_with_playwright;

import com.mycomp.utils.ConfigurationReader;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_BingSearchWithSingleton {

    @Test
    void test1() {

        Driver.getPage().navigate(ConfigurationReader.getProperty("bing.url"));
        Driver.getPage().getByTestId("bnp_btn_reject").click();
        Driver.getPage().getByTestId("sb_form_q").fill("Now is the playwrigt's time");
        Driver.getPage().getByTestId("sb_form_q").press("Enter");
//        Driver.getPage().keyboard().press("Enter");
        Driver.getPage().waitForTimeout(3000);


//        Driver.getPage().locator("#sb_form_q").fill("new");  //same thing but we try to use getByTestId method in order to locate element

        System.out.println(Driver.getPage().title());
        Assertions.assertTrue(Driver.getPage().title().contains("Now is the playwrigt's time"));

        Driver.closeDriver();
    }
}
