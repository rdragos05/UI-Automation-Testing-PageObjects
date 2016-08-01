package com.endava.pageObjects;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by draicu on 8/1/2016.
 */
public class TestBaseClass {

    private static WebDriver webDriver;

    protected HomePage homePage;

    @BeforeClass
    public static void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://endava.referrals.selectminds.com");

    }

    @Before
    public  void initPageObjects(){
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

    @AfterClass
    public static void tearDown(){
        webDriver.close();
    }
}
