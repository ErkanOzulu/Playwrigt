package com.mycomp.tests.pac_04_dropdowns;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HW01_dropdown {

    @Test
    void test() {


        //HW #1: Selecting state from State dropdown and verifying result

        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/dropdown

        page.navigate("https://practice.cydeo.com/dropdown");

        //locate the dropdown and create select object
        ElementHandle selectDropdown = page.querySelector("select#state");


        //Use all Select options. (visible text, value, index)
        //3. Select Illinois with visible text
        selectDropdown.selectOption(new SelectOption().setLabel("Illinois"));
        page.waitForTimeout(2000);

        //4. Select Virginia with value
        selectDropdown.selectOption(new SelectOption().setValue("VA"));
        page.waitForTimeout(2000);

        //5. Select California with index
        selectDropdown.selectOption(new SelectOption().setIndex(5));
        page.waitForTimeout(2000);


        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText=page.evaluate("o=>o.selectedOptions[0].text",selectDropdown).toString();
       ;

        Assertions.assertEquals(expectedOptionText, actualOptionText);



        //wait 3 seconds

        page.waitForTimeout(3000);

        //close the page
        page.close();

        //close the browser
        browser.close();
        //close the playwright
        playwright.close();

    }
}