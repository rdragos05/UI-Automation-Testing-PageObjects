package com.endava.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by draicu on 8/1/2016.
 */
public class HomePage {

    @FindBy(xpath = "//input[@id='keyword']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@id='loc_placeholder']")
    private WebElement locationBox;

    @FindBy(xpath = "//div[@id='location_facet_chzn']//input[@value='All locations']")
    private WebElement locationInput;

    @FindBy(xpath = "//div[@id='jSearchSubmit']")
    private WebElement searchButton;

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public JobListPage searchJob(String jobSearchText, Locations location){
        searchBox.sendKeys(jobSearchText);

        locationBox.click();
        locationInput.sendKeys(location.toString());
        locationInput.sendKeys(Keys.RETURN);

        searchButton.click();

        JobListPage jobListPage= PageFactory.initElements(webDriver, JobListPage.class);
        jobListPage.waitForPage();
        return jobListPage;
    }
}
