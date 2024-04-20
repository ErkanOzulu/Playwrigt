package com.mycomp.tests.pac_02_locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_ClickLinkWithText {

    @Test
    void test() {

        Playwright playwright=Playwright.create();
        BrowserType chromium= playwright.chromium();
        Browser browser=chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/");


//        page.setViewportSize(1080,1920);
        page.click("text=A/B Testing");  //text only uses for links text on the page

        page.goBack();

        page.click("text=Autocomplete");


        page.waitForTimeout(2000);

        System.out.println(page.title());
        Assertions.assertTrue(page.title().contains("Auto"));

        page.close();
        browser.close();
        playwright.close();
    }
}
