package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HW01_isVisible {

    @Test
    void test1() {
        //1. Open Chrome browser

        Playwright playwright=Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();


        //2- Go to: https://practice.cydeo.com/abtest

        page.navigate("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed.
       Assertions.assertTrue(page.locator("[target='_blank']").isVisible());


        //4- Refresh the page.
        page.reload();


        //5- Verify it is displayed, again.

        Assertions.assertTrue(page.locator("[target='_blank']").isVisible());

        //close the page
        page.close();
        //close the browser
        browser.close();
        //close the playwright
        playwright.close();

    }
}