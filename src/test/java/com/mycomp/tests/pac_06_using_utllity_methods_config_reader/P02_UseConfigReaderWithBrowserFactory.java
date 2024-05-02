package com.mycomp.tests.pac_06_using_utllity_methods_config_reader;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.mycomp.utils.BrowserFactory;
import com.mycomp.utils.CRMUtils;
import com.mycomp.utils.ConfigurationReader;
import org.junit.jupiter.api.*;

public class P02_UseConfigReaderWithBrowserFactory {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser= BrowserFactory.getBrowser(playwright);
    }


    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }


    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();

    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {

       page.navigate(ConfigurationReader.getProperty("google.url"));
    }
}