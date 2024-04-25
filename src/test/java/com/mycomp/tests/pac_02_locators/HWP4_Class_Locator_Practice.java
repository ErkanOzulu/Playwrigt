package com.mycomp.tests.pac_02_locators;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HWP4_Class_Locator_Practice {


    @Test
    void test1() {

        //HWP #4: Practice Cydeo – Class locator practice
        //PS: Locate “Home” link using “className” locator

        //1- Open a Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        //2- Go to: https://practice.cydeo.com/inputs

        page.navigate("https://practice.cydeo.com/inputs");


        //3- Click to “Home” link

        //Locating the "Home" link web element

        Locator locator = page.locator(".nav-link");

        //click to the link
//        page.querySelector(".nav-link").click();
        locator.click();


        //4- Verify title is as expected:
        // Expected: Practice

//        assertThat(page).hasTitle("Practice");
        Assertions.assertTrue(page.title().equals("Practice"));

        //close the page
        page.close();

        //close the browser
        browser.close();
        //close the playwright
        playwright.close();
    }
}