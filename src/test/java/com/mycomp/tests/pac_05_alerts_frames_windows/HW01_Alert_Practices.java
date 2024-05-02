package com.mycomp.tests.pac_05_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.*;

import java.util.List;

public class HW01_Alert_Practices {

//    https://playwright.dev/java/docs/test-runners

    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    static void beforeAll() {
        //1. Open browser
        //1. Open Chrome browser
        playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    public void setupMethod() {
        //1. Open browser
        //1. Open Chrome browser
        page = browser.newContext().newPage();
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    public void tearDownMethod() {

        BrowserUtils.waitWithThread(3);

        page.close();
    }

    @Test
    public void confirmation_alert_test2() {
        //TC #2: Prompt alert practice

        //3. Click to “Click for JS Prompt” button

        page.onDialog(dialog -> dialog.accept("prompt"));
        page.locator(".btn.btn-primary").nth(2).click();


        //4. Type "prompt" and click to OK button from the alert

        page.waitForTimeout(3000);



        //5. Verify “You entered: prompt” text is displayed.
        playwright.selectors().setTestIdAttribute("id");
        Assertions.assertEquals("You entered: prompt", page.getByTestId("result").textContent());

    }


}
