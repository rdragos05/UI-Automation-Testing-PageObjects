package com.endava.pageObjects;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by draicu on 8/1/2016.
 */
public class jobSearchTest extends TestBaseClass {

    @Test
    public void searchExistingJob(){
        JobListPage jobListPage = homePage.searchJob("Testing", Locations.BUCHAREST);
        Integer totalJobsNumber = jobListPage.getTotalJobs();
        System.out.println("Total jobs: " + totalJobsNumber);
        assertTrue(totalJobsNumber > 0);

        Integer displayedJobs = jobListPage.getDisplayedJobNumber();
        System.out.println("Displayed jobs: " + displayedJobs);
        assertEquals(new Integer(10),displayedJobs);

        JobDetailPage jobDetailPage = jobListPage.clickJob("Automation Tester (Java)");
        System.out.println("Total displays: "+ jobDetailPage.getTotalViews());
    }


}
