package com.mycomp.tests.pac_07_using_singleton_with_playwright;


import com.github.javafaker.Faker;
import com.microsoft.playwright.options.SelectOption;
import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.ConfigurationReader;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class HW01_Registration_Form {


    @BeforeEach
    public void setupMethod() {
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration_form
        Driver.getPage().navigate(ConfigurationReader.getProperty("registration.form.url"));

    }

    @AfterEach
    void tearDown() {

        BrowserUtils.waitWithThread(3);
        Driver.closeDriver();
    }


    @Test
    public void registration_form() {

        Faker faker = new Faker();
        //3. Enter first name
        Driver.getPage().locator("[name='firstname']").fill(faker.name().firstName());

        //4. Enter last name
        Driver.getPage().locator("[name='lastname']").fill(faker.name().lastName());

        //5. Enter username
        Driver.getPage().locator("[name='username']").fill(faker.letterify("??????"));

        //6. Enter email address
        Driver.getPage().locator("[name='email']").fill(faker.internet().emailAddress());

        //7. Enter password
        Driver.getPage().locator("[name='password']").fill(faker.internet().password());


        //8. Enter phone number
        Driver.getPage().locator("[name='phone']").fill(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        Random num = new Random();
        Driver.getPage().locator("[type='radio']").nth(num.nextInt(3)).click();

        BrowserUtils.waitWithThread(2);
        //10.Enter date of birth
        // Generate a random birthday in MM/DD/YYYY format
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        Date birthday = faker.date().birthday();
//        String formattedBirthday = sdf.format(birthday);
        Driver.getPage().locator("[name='birthday']").fill(new SimpleDateFormat("MM/dd/yyyy").format(faker.date().birthday()));

        //11.Select Department/Office
        Driver.getPage().locator("//select[@name='department']").selectOption(new SelectOption().setIndex(num.nextInt(1,10)));
        BrowserUtils.waitWithThread(2);


        //12.Select Job Title
        Driver.getPage().locator("//select[@name='job_title']").selectOption(new SelectOption().setIndex(num.nextInt(1,9)));

        //13.Select programming language from checkboxes
        Driver.getPage().locator("[type='checkbox']").nth(num.nextInt(3)).check();


        //14.Click to sign up button
        Driver.getPage().locator("#wooden_spoon").click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.
        Assertions.assertEquals("You've successfully completed registration!",Driver.getPage().locator("[role='alert']>p").textContent());

    }


}