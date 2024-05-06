package com.mycomp.tests.pac_09_pom_waits_actions;

import com.mycomp.page.LibraryLoginPage;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_POMPractice {

    LibraryLoginPage libraryLoginPage;
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://library1.cydeo.com");
        libraryLoginPage=new LibraryLoginPage();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.waitWithThread(2);
        Driver.closeDriver();
    }

    @Test
    void test1() {

        libraryLoginPage.getEmailInput().fill("invalid");
        libraryLoginPage.getPasswordInput().fill("invalid");
        libraryLoginPage.getSignInButton().click();

        Assertions.assertTrue(libraryLoginPage.getErrorMessage().isVisible());
    }

    @Test
    void test2() {

        libraryLoginPage.login("invalid","invalid");

        Assertions.assertTrue(libraryLoginPage.getErrorMessage().isVisible());
    }
}
