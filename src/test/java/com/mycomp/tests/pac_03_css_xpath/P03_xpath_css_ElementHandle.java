package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.management.PlatformLoggingMXBean;

public class P03_xpath_css_ElementHandle {


    @Test
    public void test1() {

        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/forgot_password");

        ElementHandle homeLink = page.querySelector("a.nav-link");
        ElementHandle emailLabel = page.querySelector("div label");

        System.out.println("homeLink.textContent() = " + homeLink.textContent());

        System.out.println("emailLabel.textContent() = " + emailLabel.textContent());
        Assertions.assertTrue(homeLink.isVisible());
        Assertions.assertTrue(emailLabel.isVisible());

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();


    }
}
