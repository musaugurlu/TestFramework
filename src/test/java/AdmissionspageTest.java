package test.java;

import main.java.pageEvents.AdmissionsPageEvents;
import main.java.pageEvents.HomePageEvents;
import org.testng.annotations.Test;

public class AdmissionspageTest extends BaseTest{
    @Test
    public void validateAdmissionsPage() {
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickOnAdmissionsLinkInFooter();

        AdmissionsPageEvents admissionsPage = new AdmissionsPageEvents();
        admissionsPage.validateAdmissionsPage();
    }

    @Test
    public void validateIDs() {
        HomePageEvents homePage = new HomePageEvents();
        homePage.clickOnAdmissionsLinkInFooter();

        AdmissionsPageEvents admissionsPage = new AdmissionsPageEvents();
        admissionsPage.validateIDsUnique();
    }
}
