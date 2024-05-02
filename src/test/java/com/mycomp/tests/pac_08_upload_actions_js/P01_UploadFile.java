package com.mycomp.tests.pac_08_upload_actions_js;

import com.mycomp.utils.BrowserUtils;
import com.mycomp.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P01_UploadFile {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/upload");
    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }

    @Test
    void fileUploadTest() {

                        //to get path of the project
        String filePath=System.getProperty("user.dir")+"/src/test/resources/uploadedFile.txt";

//        Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(filePath));
        Driver.getPage().getByTestId("file-upload").setInputFiles(Paths.get(filePath));
                                                 //.sendKeys(pathOfFile) //selenium


        /*
        for multiple files
        Driver.getPage().getByLabel("Upload files").setInputFiles(new Path[] {Paths.get("pathOfFirstFile"), Paths.get
        ("pathOfSecondFile")});

         */

        Driver.getPage().getByTestId("file-submit").click();

        Assertions.assertEquals("File Uploaded!",Driver.getPage().locator("//h3[.=\"File Uploaded!\"]").textContent());

        Driver.getPage().goBack();

        BrowserUtils.waitWithThread(2);

        // to delete uploaded file go on with below line
        Driver.getPage().getByTestId("file-upload").setInputFiles(new Path[0]);

        BrowserUtils.waitWithThread(2);

    }
}
