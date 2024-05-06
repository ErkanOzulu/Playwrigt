package com.mycomp.page;

import com.microsoft.playwright.Locator;
import com.mycomp.utils.Driver;
import lombok.Getter;


@Getter
public class DynamicPage {
    private final Locator alertMessage;


    public DynamicPage() {
        this.alertMessage = Driver.getPage().locator("#alert");
    }
}
