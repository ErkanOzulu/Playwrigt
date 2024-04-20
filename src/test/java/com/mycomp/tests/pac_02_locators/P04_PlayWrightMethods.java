package com.mycomp.tests.pac_02_locators;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlayWrightMethods {
    @Test
    void test() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://library2.cybertekschool.com/login.html");
        page.getByPlaceholder("Email address").fill("incorrectemail@gmail.com");

//        page.getByLabel("Password").fill("incorrectPassword");
//        page.querySelector("#inputPassword").fill("incorrectPassword");
        page.getByPlaceholder("Password", new Page.GetByPlaceholderOptions().setExact(true)).fill("incorrectPassword");
        page.getByRole(AriaRole.BUTTON).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign in")).click();
//        page.waitForTimeout(3000);


        System.out.println(page.getByRole(AriaRole.ALERT).textContent());

        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());//isVisible method doesn't have auto-wait

        page.close();
        browser.close();
        playwright.close();


    }
}
