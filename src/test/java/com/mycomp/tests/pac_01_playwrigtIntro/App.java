package com.mycomp.tests.pac_01_playwrigtIntro;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.webkit().launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }


        /**
         * By default, Playwright runs the browsers in headless mode. To see the browser UI, pass the setHeadless(false) flag while launching the browser. You can also use slowMo to slow down execution. Learn more in the debugging tools section.

         * playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
         */

    }
}

