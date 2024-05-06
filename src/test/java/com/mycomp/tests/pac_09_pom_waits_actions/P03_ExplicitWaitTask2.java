package com.mycomp.tests.pac_09_pom_waits_actions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.ElementState;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_ExplicitWaitTask2 {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/dynamic_controls");
    }


    @AfterEach
    void tearDown() {

        BrowserUtils.waitWithThread(2);

        Driver.closeDriver();
    }


    @Test
    void test1() {


       Driver.getPage().getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Remove")).click();

       Driver.getPage().locator("#loading").elementHandle().waitForElementState(ElementState.HIDDEN);
//       BrowserUtils.waitForInvisibilityOfElement(Driver.getPage().locator("#loading"));

        System.out.println(Driver.getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add")).isVisible());

    }
}