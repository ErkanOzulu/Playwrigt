package com.mycomp.tests.pac_04_dropdowns;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class P02_DropdownSelectOption {
    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/dropdown");
        BrowserUtils.waitWithPage(page, 3);


        Locator yearDropdown = page.locator("#year");
        Locator monthDropdown = page.locator("#month");
        Locator dayDropdown = page.locator("#day");

        String expectedYear="1988";
        String expectedMonth="January";
        int expectedDay=12;




        //select With Value
        yearDropdown.selectOption(new SelectOption().setValue(expectedYear));
        //select with text(label)
        monthDropdown.selectOption(new SelectOption().setLabel(expectedMonth));
        //select with Index
        dayDropdown.selectOption(new SelectOption().setIndex(expectedDay-1));

        BrowserUtils.waitWithThread(2);

//we need to have reel element in order to interact with javascript.locator.elementHandle() method transforms locator to element

        String actualYear = page.evaluate("el=>el.selectedOptions[0].text", yearDropdown.elementHandle()).toString();
        String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", monthDropdown.elementHandle()).toString();
        String actualDay = page.evaluate("el=>el.selectedOptions[0].text", dayDropdown.elementHandle()).toString();


        System.out.println("with Dom knowledge " + page.evaluate("document.querySelector('#year').value").toString());
        Assertions.assertEquals(expectedYear,actualYear);
        Assertions.assertEquals(expectedMonth,actualMonth);
        Assertions.assertEquals(String.valueOf(expectedDay),actualDay);


        page.close();
        browser.close();
        playwright.close();




    }
}
