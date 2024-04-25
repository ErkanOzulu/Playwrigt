package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.mycomp.utils.BrowserUtils;
import org.junit.jupiter.api.Test;

public class P06_Checkbox_RadioButton {
    @Test
    void test1() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://practice.cydeo.com/checkboxes");
        BrowserUtils.waitWithPage(page, 3);

        Locator box1 = page.locator("#box1");
//        Locator box1 =   page.getByRole(AriaRole.CHECKBOX,new Page.GetByRoleOptions().setChecked(false));
//        Locator box1 =page.getByRole(AriaRole.CHECKBOX).nth(0);
        Locator box2 = page.locator("#box2");


        BrowserUtils.waitWithPage(page, 2);
        if (!box1.isChecked()) {
            box1.check();
//            box1.click();
        }
        BrowserUtils.waitWithPage(page, 2);
        if (box2.isChecked()) {
            box2.click();
//            box2.uncheck();
        }
        BrowserUtils.waitWithPage(page, 2);

        page.close();
        browser.close();
        playwright.close();

    }
}
