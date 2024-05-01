package com.mycomp.tests.pac_05_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {


    static private Playwright playwright;
    static private Browser browser;
    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                .setSlowMo(1000));// make it a little slow to see action
    }

    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
        page.navigate("https://practice.cydeo.com/javascript_alerts");

    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {
//if it is information alert that means there is only one option, it clicks by default no need to add page.onceDialog(d->d.accept());

        page.onceDialog(d->d.accept());
        page.locator("button")
//        .nth(0)
                .first().click();

        System.out.println(page.locator("#result").textContent());
    }

    @Test
    void test2() {
//if it is confirmation alert it clicks cancel by default.If you want to click OK you need to add page.onceDialog(d->d.accept()); before click the button

        page.onceDialog(d->d.accept());

        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();

        System.out.println(page.locator("#result").textContent());

    }
}
