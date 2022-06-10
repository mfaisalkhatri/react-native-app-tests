package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.mobileautomation.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LambdaTests extends BaseTest{

    private MainPage mainPage;

    @BeforeClass
    public void setupTest () {
        mainPage = new MainPage (driverManager);
    }

    @Test
    public void proverbialAppTests () {
        assertEquals (mainPage.getText (), "Hello! Welcome to lambdatest Sample app called Proverbial");
        mainPage.textButton ().click ();
        assertEquals (mainPage.getText (), "Proverbial");
    }
}
