package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Test;

public class P07_RadioButton {
    @Test
    void test() {

        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/radio_buttons");

        //it will not work because there is no connection between label and input tag
        // page.getByRole(AriaRole.RADIO,new Page.GetByRoleOptions().setName("Red")).click();

        //RED RADIO BUTTON
//        Locator redRadioButton = page.locator("//label[.='Red']/../input");
//        redRadioButton.click();
//        System.out.println(redRadioButton.isChecked());


        page.locator("#red").click();
        String redText = page.getByText("Red", new Page.GetByTextOptions().setExact(true)).textContent();
        System.out.println("redText: " + redText);
        BrowserUtils.waitWithThread(3);


        Locator hockey = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey"));

        BrowserUtils.waitWithThread(3);
        System.out.println(hockey.isChecked());

        hockey.check();

        BrowserUtils.waitWithThread(3);
        System.out.println(hockey.isChecked());


        BrowserUtils.waitWithThread(3);

        page.close();
        browser.close();
        playwright.close();
    }
}
