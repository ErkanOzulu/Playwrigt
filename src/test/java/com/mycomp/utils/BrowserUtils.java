package com.mycomp.utils;


import com.microsoft.playwright.Page;

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


}
