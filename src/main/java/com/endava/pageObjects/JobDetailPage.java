package com.endava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by draicu on 8/1/2016.
 */
public class JobDetailPage {
    @FindBy(xpath = "//dd[@class='job_total_views']//span[@Class='field_value']")

    private WebElement totalViewsField;

    public Integer getTotalViews(){
        String totalViewsNumber = totalViewsField.getText();
        return Integer.parseInt(totalViewsNumber);
    }
}
