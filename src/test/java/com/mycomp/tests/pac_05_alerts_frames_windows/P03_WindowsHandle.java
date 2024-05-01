package com.mycomp.tests.pac_05_alerts_frames_windows;

import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.*;

public class P03_WindowsHandle {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                // .setSlowMo(1000) //do not use with window handle or use promise
        );
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
        page.navigate("https://practice.cydeo.com/windows");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.waitWithThread(3);
        page.close();
    }

    @Test
    void test1() {


//         page.pause();  //it works for debugging on browser
        //get the title
        System.out.println("before clicking page title = " + page.title());


        //click "Click Here" button (it will open a new tab)
        page.click("text=Click Here");

        //   search   it

/**
 * all below options work
        Page secondPage = page.context().waitForPage(() -> {  });

        Page secondPage = page.context().waitForPage(() -> {
           page.click("text=Click Here");
        });

        Page secondPage = page.waitForPopup(() -> { page.getByText("Click Here").click();});
 */
        Page secondPage = page.waitForPopup(() -> {});

        //get second window title
        System.out.println("Second page title = "+secondPage.title());


        //go back to first page

        page.waitForTimeout(2000);

        page.bringToFront();

        page.waitForTimeout(2000);

        secondPage.bringToFront();

        page.waitForTimeout(2000);
        page.bringToFront();

        //Click home
        page.click("text=Click Here");



        //get the title again
        System.out.println(page.title());

        secondPage.close();
    }
}