package com.mycomp.tests.pac_09_pom_waits_actions;

import com.mycomp.page.DynamicPage;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_ExplicitWaitTask {



       @BeforeEach
        void setUp() {
            Driver.getPage().navigate("https://practice.cydeo.com/dynamic_loading/7");

        }

        @AfterEach
        void tearDown() {
            BrowserUtils.waitWithThread(2);
            Driver.closeDriver();
        }
    @Test
    void test1() {
        DynamicPage dynamicPage=new DynamicPage();

        //Driver.getPage().waitForFunction("document.URL.includes('search')");

        /**
         * == --> checks data type
         * === --> checks data type and Value
         */
        Driver.getPage().waitForFunction("document.title === 'Dynamic title'");

        System.out.println(dynamicPage.getAlertMessage().textContent());
        Assertions.assertTrue(dynamicPage.getAlertMessage().textContent().contains("Done"));



    }

        }
