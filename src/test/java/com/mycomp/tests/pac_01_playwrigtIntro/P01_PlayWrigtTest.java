package com.mycomp.tests.pac_01_playwrigtIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class P01_PlayWrigtTest {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://google.com");

        Thread.sleep(3000);
        page.close();
        browser.close();
        playwright.close();

    }

}
