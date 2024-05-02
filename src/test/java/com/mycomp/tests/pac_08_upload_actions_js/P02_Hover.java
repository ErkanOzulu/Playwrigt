package com.mycomp.tests.pac_08_upload_actions_js;

import com.microsoft.playwright.ElementHandle;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P02_Hover {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.waitWithThread(2);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        /*
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(webelemnt); in Selenium

         */

        Driver.getPage().locator("img").nth(0).hover();
        BrowserUtils.waitWithThread(2);

        System.out.println(Driver.getPage().locator("//h5").nth(0).textContent());
        Driver.getPage().locator("img").nth(1).hover();
        BrowserUtils.waitWithThread(2);

        System.out.println("Driver.getPage()..elementHandle().isVisible() = " + Driver.getPage().locator("//h5").nth(1).isVisible());
        System.out.println(Driver.getPage().locator("//h5").nth(1).textContent());
        Driver.getPage().locator("img").nth(2).hover();
        System.out.println(Driver.getPage().locator("//h5").nth(2).textContent());



    }


    @Test
    void test2() {
        /*
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(webelemnt);

         */

        ElementHandle firstImage = Driver.getPage().locator("(//img)[1]").elementHandle();
        ElementHandle firstImageName = Driver.getPage().querySelector("(//h5)[1]");
        BrowserUtils.waitWithThread(2);

        firstImage.hover();
        System.out.println(firstImageName.isVisible());
        Assertions.assertTrue(firstImageName.isVisible());







    }
}