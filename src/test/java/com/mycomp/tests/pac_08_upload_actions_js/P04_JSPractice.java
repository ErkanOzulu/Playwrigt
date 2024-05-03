package com.mycomp.tests.pac_08_upload_actions_js;

import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04_JSPractice {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/infinite_scroll");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.waitWithThread(3);
        Driver.closeDriver();
    }


    @Test
    void test1() {


        for (int i = 0; i<10; i++) {
         //   Driver.getPage().evaluate("window.scrollBy(0,500)");
          Driver.getPage().evaluate("window.scrollBy(0, 500)");

            BrowserUtils.waitWithThread(1);
        }



    }
}