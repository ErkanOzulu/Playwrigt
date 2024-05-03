package com.mycomp.tests.pac_08_upload_actions_js;

import com.microsoft.playwright.ElementHandle;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P03_ScrollPractice {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/");
    }

    @AfterEach
    void tearDown() {

        BrowserUtils.waitWithThread(2);

        Driver.closeDriver();
    }


    @Test
    void test1() {

        //first scroll with js
        BrowserUtils.waitWithThread(2);
        //scroll down 500 pixel

        Driver.getPage().evaluate("()=>{window.scrollBy(0,500);}");
        BrowserUtils.waitWithThread(2);

        //scroll up 500 pixel
        Driver.getPage().evaluate("()=>{window.scrollBy(0,-500)}");
        BrowserUtils.waitWithThread(2);

        //scroll bottom
        Driver.getPage().evaluate("() => { window.scrollBy(0, 3*window.innerHeight);}");
        BrowserUtils.waitWithThread(2);
        Driver.getPage().evaluate("() => { window.scrollBy(0, -3*window.innerHeight);}");
        BrowserUtils.waitWithThread(2);

        //using mouse


        Driver.getPage().mouse().wheel(0, 1000);

        BrowserUtils.waitWithThread(2);
        Driver.getPage().mouse().wheel(0, -500);
        BrowserUtils.waitWithThread(2);

        ElementHandle element = Driver.getPage().waitForSelector("text=Web Tables");
        element.scrollIntoViewIfNeeded();

    }

    @Test
    void ScrollIntoView() {

        ElementHandle cydeoLink = Driver.getPage().querySelector("text=CYDEO");

        ElementHandle homeLink = Driver.getPage().querySelector("text=Home");


        BrowserUtils.waitWithThread(2);
        cydeoLink.scrollIntoViewIfNeeded();
        BrowserUtils.waitWithThread(2);
        homeLink.scrollIntoViewIfNeeded();


    }
}