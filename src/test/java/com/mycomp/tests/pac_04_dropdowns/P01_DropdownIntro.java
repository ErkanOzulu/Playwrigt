package com.mycomp.tests.pac_04_dropdowns;

import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Test;

public class P01_DropdownIntro {
    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/dropdown");
        BrowserUtils.waitWithPage(page, 3);

        /*
        Playwrigt doesn't have any method to show selected options.So we can use javascript.
         */
        ElementHandle dropdown = page.querySelector("#dropdown");
        String selectedOption = page.evaluate("el=>el.selectedOptions[0].text",dropdown).toString();//it allows us to run javascript code "el=>el.selectedOptions[0].text"--> that is lambda express,

        BrowserUtils.waitWithPage(page,2);

        System.out.println(selectedOption);

        page.close();
        browser.close();
        playwright.close();


    }
}
