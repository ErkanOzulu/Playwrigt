package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04_FindElements {
    @Test
    void test() {

        Playwright playwright=Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/abtest");

        List<ElementHandle> links = page.querySelectorAll("//a");


        for (ElementHandle each : links) {
            System.out.println(each.getAttribute("href"));

        }

        BrowserUtils.waitWithPage(page,3);

        page.close();
        browser.close();
        playwright.close();

    }
}
