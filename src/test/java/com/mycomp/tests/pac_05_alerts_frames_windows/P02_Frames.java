package com.mycomp.tests.pac_05_alerts_frames_windows;

import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.*;

public class P02_Frames {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)
        );
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/iframe");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {

        FrameLocator firstIframe = page.frameLocator("#mce_0_ifr");
        firstIframe.locator("#tinymce").clear();

        BrowserUtils.waitWithThread(2);
        firstIframe.locator("#tinymce").fill("Write whatever you want");
        //    page.locator("//p").textContent();
        String pValue = firstIframe.locator("//p").textContent();

        System.out.println("pValue = " + pValue);
        Assertions.assertEquals("Write whatever you want", pValue);


        System.out.println(page.locator("//h3").textContent());

    }
}