package com.mycomp.tests.pac_03_css_xpath;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HW02_radio_button_utility_method {


    @Test
    void test() {

        // TC#2: Radiobutton handling
        //1. Open Chrome browser
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();


        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--lang=en-US", "--force-english-ui")));

        Page page = browser.newContext().newPage();


        //2. Go to https://practice.cydeo.com/radio_buttons
        page.navigate("https://practice.cydeo.com/radio_buttons");

        //for 3 - 4 - 5, do not repeat yourself create a method to click and verify the radio button

        //3. Click to “Hockey” radio button
        clickAndVerifyRadioButton(page, "id", "hockey");

        //4. Click to “Football” radio button
        clickAndVerifyRadioButton(page, "id", "football");
        //5. Click to “Red” radio button
        clickAndVerifyRadioButton(page, "id", "red");


        //wait 3 seconds
        page.waitForTimeout(3000);


        //close the page
        page.close();

        //close the browser
        browser.close();

        //close the playwright
        playwright.close();


    }

    private void clickAndVerifyRadioButton(Page page, String attribute, String value) {

        //Find the element
        Locator byRole = page.getByRole(AriaRole.RADIO);

        ElementHandle element = null;
        for (ElementHandle radio : byRole.elementHandles()) {
            if (radio.getAttribute(attribute).equalsIgnoreCase(value)) {
                radio.check();
                element=radio;
                System.out.println(element.getAttribute(attribute));
                break;
            }
        }


        // Verify radio button is selected after clicking.
        Assertions.assertTrue(element.isChecked());


    }
}