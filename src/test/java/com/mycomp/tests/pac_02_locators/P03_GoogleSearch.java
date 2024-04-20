package com.mycomp.tests.pac_02_locators;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P03_GoogleSearch {

    @Test
    void test() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://google.com/");

        Locator searchBox = page.locator("textarea[name='q']");
        searchBox.type("selenium");
        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");

        page.waitForTimeout(2000);

        searchBox.clear();

        searchBox.fill("Palywrigt");
        keyboard.press("Enter");

        page.waitForTimeout(2000);

        searchBox.clear();

        //simulating human writing attribute
        searchBox.pressSequentially("Cypress", new Locator.PressSequentiallyOptions().setDelay(100));
        keyboard.press("Enter");

        page.close();
        browser.close();
        playwright.close();


    }
}
