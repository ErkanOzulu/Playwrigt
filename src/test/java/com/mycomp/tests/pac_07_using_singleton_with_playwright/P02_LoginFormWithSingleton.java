package com.mycomp.tests.pac_07_using_singleton_with_playwright;

import com.microsoft.playwright.Locator;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_LoginFormWithSingleton {

    @Test
    void loginTest() {
        Driver.getPage().navigate("https://practice.cydeo.com/login");


        Driver.getPage().locator("input").first().fill("tomsmith");
        Driver.getPage().locator("input").last().fill("SuperSecretPassword");
        Driver.getPage().getByTestId("wooden_spoon").click();

        Assertions.assertTrue(Driver.getPage().locator("#flash").textContent().contains("You logged into a secure area!"));
        BrowserUtils.waitWithPage(Driver.getPage(), 3);
        Driver.closeDriver();


    }
}
