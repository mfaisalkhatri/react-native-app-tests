package io.github.mfaisalkhatri.mobileautomation.tests;

import io.github.mfaisalkhatri.mobileautomation.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LambdaTests extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    public void setupTest () {
        homePage = new HomePage (driverManager);
    }

    @Test
    public void proverbialAppTests () {
        assertEquals (homePage.getText (), "Hello! Welcome to lambdatest Sample app called Proverbial");
        homePage.textButton ().click ();
        assertEquals (homePage.getText (), "Proverbial");
    }
}
