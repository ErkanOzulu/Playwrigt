package com.mycomp.tests.pac_07_using_singleton_with_playwright;


import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.*;

import java.util.List;

public class HW01_WebTable_Order_Verify {
    Page page;
    static Playwright playwright;
    static Browser browser;

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
    public void setupMethod(){
        //1. Open browser
        //1. Open Chrome browser
       page = browser.newContext().newPage();
        //2. Go to: https://practice.cydeo.com/web-tables
        page.navigate("https://practice.cydeo.com/web-tables");
    }

    @AfterEach
    public void tearDownMethod(){

        BrowserUtils.waitWithThread(3);

        page.close();

    }

    @Test
    public void order_verify_name_test(){

        //2. VerifyBob’s name is listed as expected.
        //below locator is locating me the Bob Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bob's cell using its name as the text.


        Locator bob = page.locator("//table//td[.='Bob Martin']");


        //Expected: “Bob Martin”

Assertions.assertTrue(bob.textContent().equals("Bob Martin"));

        //3. VerifyBobMartin’s order date is as expected.
        //WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));

        //Expected: 12/31/2021
        Locator orderDate=page.locator("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]");


        Assertions.assertEquals("12/31/2021",orderDate.textContent());


    }

  
}