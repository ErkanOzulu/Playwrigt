package com.mycomp.utils;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ElementState;

public class BrowserUtils {

    public static void waitWithThread(int seconds){


        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }

    public static void waitWithPage(Page page, int seconds){

        page.waitForTimeout(seconds*1000);


    }

    public static void waitForInvisibilityOfElement(Locator locator){
        locator.elementHandle().waitForElementState(ElementState.HIDDEN);
    }


}
