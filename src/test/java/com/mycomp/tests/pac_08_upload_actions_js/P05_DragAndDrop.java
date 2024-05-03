package com.mycomp.tests.pac_08_upload_actions_js;

import com.microsoft.playwright.Locator;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P05_DragAndDrop {

    @BeforeEach
    void setUp() {

        Driver.getPage().navigate("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.waitWithThread(2);
        Driver.closeDriver();
    }

    @Test
    void test1() {

        Locator target = Driver.getPage().getByTestId("droptarget");
        Locator source = Driver.getPage().getByTestId("draggable");
        System.out.println("before drag and drop = " + target.textContent());
        BrowserUtils.waitWithThread(2);
        source.dragTo(target);
        System.out.println("after drag and drop = " + target.textContent());
        Assertions.assertEquals("You did great!",target.textContent());


    }

    @Test
    void test2() {
        Locator target = Driver.getPage().getByTestId("droptarget");
        Locator source = Driver.getPage().getByTestId("draggable");
        System.out.println("before drag and drop = " + target.textContent());
        BrowserUtils.waitWithThread(2);
        source.click();
        Driver.getPage().mouse().down();
        BrowserUtils.waitWithThread(2);
        Driver.getPage().mouse().move(600,200);
        BrowserUtils.waitWithThread(2);
        Driver.getPage().mouse().up();
        System.out.println("after drag and drop = " + target.textContent());

        Assertions.assertEquals("You did great!", target.textContent());





    }
}
