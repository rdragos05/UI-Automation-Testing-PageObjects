package com.endava.pageObjects;

import com.gargoylesoftware.htmlunit.Page;
import org.apache.xerces.parsers.IntegratedParserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.fail;

/**
 * Created by draicu on 8/1/2016.
 */
public class JobListPage {

    @FindBy(xpath = "//div[contains(@class,'jResultsActive')]//span[@class='total_results']")
    private WebElement totalResultsField;

    @FindBy(xpath = "//div[contains(@class,'jResultsActive')]//a[@class='job_link font_bold']")
    private List<WebElement> jobList;

    private WebDriver webDriver;
    public JobListPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public Integer getTotalJobs(){
        String totalResults = totalResultsField.getText();
        return Integer.parseInt(totalResults);
    }

    public Integer getDisplayedJobNumber(){
        return jobList.size();
    }

    public JobDetailPage clickJob(String jobToClick){
        for (WebElement job : jobList){
            if(job.getText().equals(jobToClick)){
                job.click();

                JobDetailPage jobDetailPage = PageFactory.initElements(webDriver, JobDetailPage.class);
                return jobDetailPage;
            }
        }

        fail("No job with name " + jobToClick + "was found! ");
        return null;
    }

    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfAllElements(jobList));
        wait.until(ExpectedConditions.textToBePresentInElement(totalResultsField,""));
    }


}