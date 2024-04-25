package com.mycomp.tests.pac_02_locators;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HWP1_Etsy_Search_Title {

    @Test
    void test1() {

        //HWP #1: Etsy Title Verification
        //1. Open chromium browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();


        //2. Go to https://www.etsy.com

        page.navigate("https://www.etsy.com");


        page.setViewportSize(1280,1024);
        //3. Search for “wooden spoon”
        Keyboard keyboard = page.keyboard();
        try {
            page.querySelector("[data-id='search-query']").fill("wooden spoon");
            page.keyboard().press("Enter");
        } catch (Exception e) {
            page.reload();
//             page.locator("[class='slider']").hover();
//             page.mouse().down();
//             page.mouse().move(0,168);
//             page.mouse().up();

             page.querySelector("[data-id='search-query']").fill("wooden spoon");

            page.keyboard().press("Enter");

        }



        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”
        String expected = "Wooden spoon - Etsy";

        page.waitForTimeout(2000);
        String actual = page.title();

        System.out.println("actual = " + actual);
        Assertions.assertEquals(expected, actual);

        //close the page
        page.close();

        //close the browser
        browser.close();
        //close the playwright
        playwright.close();


    }
}