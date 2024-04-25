package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P05_ClickWithIndex {
    @Test
    void test1(){
        Playwright playwright=Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com");
        BrowserUtils.waitWithPage(page,3);


        page.locator("div#content a").first().click();
        BrowserUtils.waitWithPage(page,1);
        page.goBack();
        BrowserUtils.waitWithPage(page,1);
        page.locator("div#content a").last().click();
        BrowserUtils.waitWithPage(page,1);
        page.goBack();
        BrowserUtils.waitWithPage(page,1);
        page.locator("div#content a").nth(4).click();
        BrowserUtils.waitWithPage(page,1);

        page.goBack();


        List<ElementHandle> elementHandles = page.querySelectorAll("div#content a");
        System.out.println("elementHandles.size() = " + elementHandles.size());

        for (int i = 0; i < elementHandles.size(); i++) {

            Locator locator=page.locator("div#content a").nth(i);
            if (locator.textContent().equals("A/B Testing"))
                locator.click();
            break;

        }


        page.close();
        browser.close();
        playwright.close();


    }



}
