package com.mycomp.utils;

import com.microsoft.playwright.Page;
import org.jetbrains.annotations.NotNull;

public class CRMUtils {

    public static void login(@NotNull Page page) {

        page.locator("//input[@name='USER_LOGIN']").fill("invalid@gmail.com");
        page.getByPlaceholder("password").fill("invalidpassord");

        page.locator(".login-btn").click();

    }
    public static void login(@NotNull Page page, String username, String password) {

        page.locator("//input[@name='USER_LOGIN']").fill(username);
        page.getByPlaceholder("password").fill(password);

        page.locator(".login-btn").click();

    }

}